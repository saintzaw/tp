package seedu.main;

import java.util.ArrayList;
import java.util.logging.Level;

import static seedu.main.Main.LOGGER;

public class Command {
    private static final int REQUIRED_MC_CORE = 96;
    private static final int REQUIRED_MC_GE = 20;
    private static final int REQUIRED_MC_UE = 32;
    private static final int REQUIRED_MC_INTERNSHIP = 12;
    private InputChecker checkInput = new InputChecker();
    public Command () {

    }
    public void manPageCommand(String[] userCommands) {
        LOGGER.log(Level.INFO, "Starting manpage process");
        if (userCommands.length == 2) {
            checkInput.checkManPageInput(userCommands);
        } else {
            try {
                int numberOfFields = 1;
                checkInput.checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                Print.printErrorMessage(e);
                LOGGER.log(Level.WARNING, "User Input is invalid");
            }
            assert userCommands.length == 1;
            ManPage.printManPage();
        }
        LOGGER.log(Level.INFO, "End of manpage process");
    }

    public void addCommand(String[] userCommands, ModuleList moduleList) {
        try {
            LOGGER.log(Level.INFO, "Starting addModule process");
            checkInput.checkAddInput(moduleList, userCommands);
        } catch (MainException e) {
            LOGGER.log(Level.WARNING, "addModule Check failed: " + e.getDescription());
            Print.printErrorMessage(e);
        }
        LOGGER.log(Level.INFO, "End of addModule process");
    }

    public void findCommand(String[] userCommands, ModuleList moduleList) throws MainException {
        try {
            int numberOfFields = 3;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 3;
        ArrayList<Module> foundModules = new ArrayList<>();
        if (userCommands[1].trim().equals("CODE")) {
            try {
                foundModules = moduleList.findModuleByCode(userCommands[2].trim());
                if (foundModules.isEmpty()) {
                    Print.printNoModuleFound(userCommands[2].trim());
                    LOGGER.log(Level.INFO, "Finished findModule process with no matching module found");

                } else {
                    LOGGER.log(Level.INFO, "Finished findModule process with matching module found");
                    Print.printFoundModule(foundModules);
                }
            } catch (MainException e) {
                Print.printErrorMessage(e);
            }
        } else if (userCommands[1].trim().equals("TYPE")) {
            try {
                foundModules = moduleList.findModuleByType(userCommands[2].trim());
                if (foundModules.isEmpty()) {
                    Print.printNoModuleFound(userCommands[2].trim());
                    LOGGER.log(Level.INFO, "Finished findModule process with no matching module found");

                } else {
                    LOGGER.log(Level.INFO, "Finished findModule process with matching module found");
                    Print.printFoundModule(foundModules);
                }
            } catch (MainException e) {
                Print.printErrorMessage(e);
            }
        } else {
            throw new MainException("Please specify type of search with /Code or /Type");
        }
    }

    public void deleteCommand(String[] userCommands, ModuleList moduleList) {
        try {
            int numberOfFields = 2;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 2;
        try {
            Module deletedModule = moduleList.deleteModule(userCommands[1].trim());
            if (deletedModule == null) { // When no module matches the given module code
                Print.printNoDeletedModuleFound(userCommands[1].trim());
            } else { // When a matching module is found and successfully deleted
                Print.printDeletedModule(deletedModule, moduleList.getModuleListSize());
            }
        } catch (MainException e) {
            Print.printErrorMessage(e);
        }
    }

    public void listCommand(String[] userCommands, ModuleList moduleList) throws MainException {
        try {
            int numberOfFields = 2;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 2;
        listModules(moduleList, userCommands[1].trim());
    }

    private void listModules(ModuleList listOfModules, String year) throws MainException {
        switch(year) {
        case "ALL":
            listOfModules.listModulesByYear("1");
            listOfModules.listModulesByYear("2");
            listOfModules.listModulesByYear("3");
            listOfModules.listModulesByYear("4");
            break;
        case "1":
            listOfModules.listModulesByYear("1");
            break;
        case "2":
            listOfModules.listModulesByYear("2");
            break;
        case "3":
            listOfModules.listModulesByYear("3");
            break;
        case "4":
            listOfModules.listModulesByYear("4");
            break;
        default:
            throw new MainException("Make sure Year of Study is an integer from 1-4 or \"all\"");
        }
    }

    public void editCommand(String[] userCommands, ModuleList moduleList) {
        try {
            int numberOfFields = 4;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 4;
        try {
            editModuleField(moduleList, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
        }
    }

    private void editModuleField(ModuleList listOfModules, String[] userCommands) throws MainException {
        //format: edit /moduleCode /field /update
        String moduleCode = userCommands[1].trim();
        //the field that the user wants to update
        String moduleField = userCommands[2].trim();
        //the new information to replace in the indicated field
        String update = userCommands[3].trim();

        // Checks if the specified module exists
        ArrayList<Module> modules = listOfModules.getModuleList();
        boolean moduleIsFound = false;
        for (Module module : modules) {
            if (module.getModuleCode().equals(moduleCode)) {
                moduleIsFound = true;
                break;
            }
        }
        if (!moduleIsFound) {
            throw new MainException("The module you are trying to edit does not exist in the module plan. " +
                    System.lineSeparator() +
                    "\t Please add the module using the add command if you wish to take the module in the future.");
        }

        switch (moduleField) {
        case "MC":
            checkInput.checkEditInputCorrectModularCreditField(update);
            listOfModules.editModularCredits(moduleCode, update);
            break;
        case "TYPE":
            checkInput.checkEditInputCorrectTypeOfModule(update);
            listOfModules.editModuleType(moduleCode, update);
            break;
        case "CODE":
            checkInput.checkAddInputNoDuplicates(update, listOfModules.getModuleList());
            checkInput.checkEditInputCorrectModuleCode(update);
            listOfModules.editModuleCode(moduleCode, update);
            break;
        case "YEAR":
            checkInput.checkEditInputYear(update);
            listOfModules.editYear(moduleCode, update);
            break;
        case "SEMESTER":
            checkInput.checkEditInputSemester(update);
            listOfModules.editSemester(moduleCode, update);
            break;
        case "GRADE":
            checkInput.checkGradeInput(update);
            listOfModules.editModuleGrade(moduleCode, update);
            break;
        default:
            throw new MainException("Make sure the field to edit is MC, type, code, " +
                    "year, semester or grade");
        }
    }

    public void gradeCommand(String[] userCommands, ModuleList moduleList) {
        try {
            LOGGER.log(Level.INFO, "Starting Grade process");
            int numberOfFields = 3;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            LOGGER.log(Level.WARNING, "grade input length check failed: " + e.getDescription());
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 3;
        try {
            checkInput.checkGradeInput(userCommands[2].trim());
            Module moduleGradeUpdated =
                    moduleList.updateModuleGrade(userCommands[1].trim(), userCommands[2].trim());
            if (moduleGradeUpdated != null) {
                LOGGER.log(Level.INFO, "Update grade process success!");
                Print.printUpdatedModuleGrade(moduleGradeUpdated);
            } else {
                Print.printInvalidModule(userCommands[1].trim());
            }
        } catch (MainException e) {
            LOGGER.log(Level.WARNING, "valid grade input check failed: " + e.getDescription());
            Print.printErrorMessage(e);
        }
    }

    public void calculateCAPCommand(String[] userCommands, ModuleList moduleList) {
        try {
            LOGGER.log(Level.INFO, "Starting process to calculate CAP");
            int numberOfFields = 1;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            LOGGER.log(Level.WARNING, "calculatecap input length check failed: " + e.getDescription());
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 1;
        moduleList.calculateCAP();
        LOGGER.log(Level.INFO, "End of calculate CAP process");
    }

    public void byeCommand(String[] userCommands, ModuleList moduleList) {
        try {
            int numberOfFields = 1;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
        }
        assert userCommands.length == 1;
        Storage.saveModules(moduleList.getModuleList());
        Print.printFarewellMessage();
        LOGGER.log(Level.INFO, "Exiting Modganiser.");
    }

    public void trackCommand(String[] userCommands, ModuleList moduleList) {
        try {
            int numberOfFields = 2;
            checkInput.checkNumberOfFields(numberOfFields, userCommands);
        } catch (MainException e) {
            Print.printErrorMessage(e);
            return;
        }
        assert userCommands.length == 2;
        try {
            trackGraduationRequirements(moduleList, userCommands[1].trim());
        } catch (MainException e) {
            Print.printErrorMessage(e);
        }
    }

    /**
     * Check how far the user is from meeting the requirement for each module type
     *
     * @param listOfModules list of modules that the user has
     * @param moduleType module type that the user wants to check
     * @throws MainException if the moduleType the user input is not valid
     */
    private void trackGraduationRequirements(ModuleList listOfModules, String moduleType) throws MainException {
        ArrayList<Module> foundModules = new ArrayList<>();
        switch(moduleType) {
        case "ALL":
            String[] moduleTypes = {"CORE", "GE" , "UE", "INTERNSHIP"};
            int[] requiredMCs = {REQUIRED_MC_CORE, REQUIRED_MC_GE, REQUIRED_MC_UE, REQUIRED_MC_INTERNSHIP};
            for (int i = 0; i < moduleTypes.length; i++) {
                foundModules = listOfModules.findModuleByType(moduleTypes[i]);
                listOfModules.trackModules(foundModules, moduleTypes[i], requiredMCs[i]);
            }
            break;
        case "GE":
            foundModules = listOfModules.findModuleByType("GE");
            listOfModules.trackModules(foundModules, moduleType, REQUIRED_MC_GE);
            break;
        case "UE":
            foundModules = listOfModules.findModuleByType("UE");
            listOfModules.trackModules(foundModules, moduleType, REQUIRED_MC_UE);
            break;
        case "INTERNSHIP":
            foundModules = listOfModules.findModuleByType("INTERNSHIP");
            listOfModules.trackModules(foundModules, moduleType, REQUIRED_MC_INTERNSHIP);
            break;
        case "CORE":
            foundModules = listOfModules.findModuleByType("CORE");
            listOfModules.trackModules(foundModules, moduleType, REQUIRED_MC_CORE);
            break;
        default:
            throw new MainException("Make sure you're trying to track Core, GE, UE or Internship.");
        }
    }
}
