package seedu.main;

import java.util.ArrayList;
import java.util.logging.Level;

import static java.lang.System.exit;
import static seedu.main.Main.LOGGER;

public class Parser {
    private static final int REQUIRED_MC_CORE = 96;
    private static final int REQUIRED_MC_GE = 20;
    private static final int REQUIRED_MC_UE = 32;
    private static final int REQUIRED_MC_INTERNSHIP = 12;

    public Parser() {

    }

    /**
     * It will display the description of the feature as requested by the
     * user's input.
     *
     * @param userInput the feature the user wants to find out more about
     */
    public void checkManPageInput(String userInput) {
        String[] userCommands = userInput.toUpperCase().split("/");
        assert userCommands.length == 2;

        switch (userCommands[1]) {
        case "ADD":
            ManPage.printManPageAdd();
            break;
        case "LIST":
            ManPage.printManPageList();
            break;
        case "EDIT":
            ManPage.printManPageEdit();
            break;
        case "FIND":
            ManPage.printManPageFind();
            break;
        case "DELETE":
            ManPage.printManPageDelete();
            break;
        case "CALCULATOR":
            ManPage.printManPageCalculator();
            break;
        case "GRADE":
            ManPage.printManPageUpdateGrade();
            break;
        case "BYE":
            ManPage.printManPageExit();
            break;
        default:
            break;
        }
    }

    /**
     * Checks for valid user commands
     *
     * @param userInput The command that the user inputs to the ChatBot
     * @throws MainException if user command is invalid
     */
    public void checkUserInput(String userInput, ModuleList moduleList) throws MainException {

        String[] userCommands = userInput.toUpperCase().split("/");

        switch (userCommands[0].trim()) {
        case "MAN":
            LOGGER.log(Level.INFO, "Starting manpage process");

            if (userCommands.length == 2) {
                checkManPageInput(userInput);
            } else {
                try {
                    int numberOfFields = 1;
                    checkNumberOfFields(numberOfFields, userCommands);
                } catch (MainException e) {
                    Print.printErrorMessage(e);
                    LOGGER.log(Level.WARNING, "User Input is invalid");
                }
                assert userCommands.length == 1;
                ManPage.printManPage();
            }

            LOGGER.log(Level.INFO, "End of manpage process");
            break;
        case "ADD":
            try {
                LOGGER.log(Level.INFO, "Starting addModule process");
                checkAddInput(moduleList, userCommands);
                Storage.saveModules(moduleList.getModuleList());
            } catch (MainException e) {
                LOGGER.log(Level.WARNING, "addModule Check failed: " + e.getDescription());
                Print.printErrorMessage(e);
            }
            LOGGER.log(Level.INFO, "End of addModule process");
            break;
        case "FIND":
            try {
                int numberOfFields = 3;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 3;
            ArrayList<Module> foundModules = new ArrayList<>();
            if (userCommands[1].trim().equals("CODE")) {
                try {
                    foundModules = moduleList.findModuleByCode(userCommands[2].trim());
                } catch (MainException e) {
                    Print.printErrorMessage(e);
                }
            } else if (userCommands[1].trim().equals("TYPE")) {
                try {
                    foundModules = moduleList.findModuleByType(userCommands[2].trim());
                } catch (MainException e) {
                    Print.printErrorMessage(e);
                }
            } else {
                throw new MainException("Please specify type of search with /Code or /Type");
            }
            if (foundModules.isEmpty()) {
                Print.printNoModuleFound(userCommands[2].trim());
                LOGGER.log(Level.INFO, "Finished findModule process with no matching module found");

            } else {
                LOGGER.log(Level.INFO, "Finished findModule process with matching module found");
                Print.printFoundModule(foundModules);
            }
            break;
        case "DELETE":
            try {
                int numberOfFields = 2;
                checkNumberOfFields(numberOfFields, userCommands);
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
                Storage.saveModules(moduleList.getModuleList());
            } catch (MainException e) {
                Print.printErrorMessage(e);
            }

            break;
        case "LIST":
            try {
                int numberOfFields = 2;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 2;
            listModules(moduleList, userCommands[1].trim());
            break;
        case "EDIT":
            try {
                int numberOfFields = 4;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 4;
            try {
                editModuleField(moduleList, userCommands);
                Storage.saveModules(moduleList.getModuleList());
            } catch (MainException e) {
                Print.printErrorMessage(e);
            }
            break;
        case "GRADE":
            try {
                LOGGER.log(Level.INFO, "Starting Grade process");
                int numberOfFields = 3;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                LOGGER.log(Level.WARNING, "grade input length check failed: " + e.getDescription());
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 3;
            try {
                checkGradeInput(userCommands[2].trim());
                Module moduleGradeUpdated =
                        moduleList.updateModuleGrade(userCommands[1].trim(), userCommands[2].trim());
                if (moduleGradeUpdated != null) {
                    LOGGER.log(Level.INFO, "Update grade process success!");
                    Print.printUpdatedModuleGrade(moduleGradeUpdated);
                } else {
                    Print.printInvalidModule(userCommands[1].trim());
                }
                Storage.saveModules(moduleList.getModuleList());
            } catch (MainException e) {
                LOGGER.log(Level.WARNING, "valid grade input check failed: " + e.getDescription());
                Print.printErrorMessage(e);
            }
            break;
        case "CALCULATECAP":
            try {
                LOGGER.log(Level.INFO, "Starting process to calculate CAP");
                int numberOfFields = 1;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                LOGGER.log(Level.WARNING, "calculatecap input length check failed: " + e.getDescription());
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 1;
            moduleList.calculateCAP();
            LOGGER.log(Level.INFO, "End of calculate CAP process");
            break;
        case "BYE":
            try {
                int numberOfFields = 1;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (MainException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 1;
            Print.printFarewellMessage();
            LOGGER.log(Level.INFO, "Exiting Modganiser.");
            exit(0);
            break;
        case "TRACK":
            try {
                int numberOfFields = 2;
                checkNumberOfFields(numberOfFields, userCommands);
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
            break;
        default:
            throw new MainException("Invalid Command");
        }

    }

    /**
     * Checks all the fields of addInput, which is the input captured when add command is called by user.
     *
     * @param listOfModules The currently stored list of modules. Can be loaded or during the session.
     * @param userCommands The input that the user keyed in.
     * @throws MainException if the user input is invalid.
     */
    private void checkAddInput(ModuleList listOfModules, String[] userCommands) throws MainException {
        //check for correct number of fields
        int numberOfFields = 6;
        checkNumberOfFields(numberOfFields, userCommands);
        assert userCommands.length == 6 : "Expected 6 fields";

        //check for non-empty and correct number of characters in the moduleCode field
        checkAddInputCorrectModuleCode(userCommands);

        //check for correct field in MC
        checkAddInputCorrectModularCreditField(userCommands);

        //check for correct field in type of module
        checkAddInputCorrectTypeOfModule(userCommands);

        //check for correct year and semester
        checkAddInputYearAndSemester(userCommands);

        //check for duplicate names and then add
        String[] moduleList = userCommands[1].trim().split(" ");

        for (String moduleCode: moduleList) {
            checkAddInputNoDuplicates(moduleCode.trim(), listOfModules.getModuleList());
            Module addedModule = listOfModules.addModule(moduleCode.trim(), userCommands[2].trim(),
                    userCommands[3].trim(), userCommands[4].trim(), userCommands[5].trim());
            Print.printAddedModule(addedModule, listOfModules.getModuleListSize());
        }
    }

    /**
     * Checks for the correct number of fields for the respective command
     *
     * @param numberOfFields The number of fields that the user should input for the command
     * @param userCommands the user input split into the respective fields and stored in an array
     * @throws MainException if user command is invalid
     */
    public void checkNumberOfFields(int numberOfFields, String[] userCommands) throws MainException {
        if (userCommands.length > numberOfFields) {
            throw new MainException("Too many fields");
        } else if (userCommands.length < numberOfFields) {
            throw new MainException("Missing fields");
        }
    }

    /**
     * Checks the moduleCode section of addInput command.
     * Currently checks for empty strings.
     * Currently checks for the correct number of parameters.
     *
     * @param userCommands the user input split into the respective fields and stored in an array
     * @throws MainException if user command is invalid
     */
    private void checkAddInputCorrectModuleCode(String[] userCommands) throws MainException {
        if (userCommands[1].trim().equals("")) {
            throw new MainException("Module Code cannot be empty");
        }
        if (userCommands[1].trim().length() < 6) {
            throw new MainException("Module Code cannot be less than 6 characters!");
        }
    }

    /**
     * Checks the modularCredit section of addInput command.
     * Currently checks for the correct modular credit of [0-6, 8, 12]
     * Currently checks for the modular credit to be an integer.
     *
     * @param userCommands the user input split into the respective fields and stored in an array
     * @throws MainException if user command is invalid
     */
    private void checkAddInputCorrectModularCreditField(String[] userCommands) throws MainException {
        try {
            int moduleCredits = Integer.parseInt(userCommands[2].trim());
            if ( moduleCredits < 0 || moduleCredits > 13 || moduleCredits == 7 || moduleCredits == 9
                    || moduleCredits == 10 || moduleCredits == 11) {
                throw new MainException("Make sure Modular Credits is a number from 0-6, 8 or 12");
            }
        } catch (NumberFormatException e) {
            throw new MainException("Make sure Modular Credits is a number from 0-6, 8 or 12");
        }
    }

    /**
     * Checks the moduleType section of addInput command.
     * Currently checks for whether they belong to [Core, UE, GE, Internship]
     *
     * @param userCommands the user input split into the respective fields and stored in an array
     * @throws MainException if user command is invalid
     */
    private void checkAddInputCorrectTypeOfModule(String[] userCommands) throws MainException {
        String typeOfModule = userCommands[3].trim();
        boolean isCorrectModuleType = typeOfModule.equals("CORE")
                || typeOfModule.equals("UE")
                || typeOfModule.equals("GE")
                || typeOfModule.equals("INTERNSHIP") ;
        if (!isCorrectModuleType) {
            throw new MainException("Incorrect Module Type, Accepted Module Types are: (CORE, UE ,GE ,INTERNSHIP)");
        }
    }

    /**
     * Checks the listOfModules to ensure that there are no duplicates.
     *
     * @param moduleCode The unique identifier of modules.
     * @param listOfModules The currently stored list of modules.
     * @throws MainException if the user input is invalid.
     */
    private void checkAddInputNoDuplicates(String moduleCode, ArrayList<Module> listOfModules) throws MainException {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                throw new MainException(moduleCode + " is already in the list");
            }
        }
    }

    /**
     * Checks the year and semester section of addInput command.
     * Currently checks for year being [0-4].
     * Currently checks for semester being [1, 1.5, 2, 2.5].
     * Currently checks for year being an integer.
     *
     * @param userCommands the user input split into the respective fields and stored in an array
     * @throws MainException if user command is invalid
     */
    private void checkAddInputYearAndSemester(String[] userCommands) throws MainException {
        try {
            int year = Integer.parseInt(userCommands[4].trim());
            if (year < 0 || year > 4) {
                throw new MainException("Make sure Year of Study is a number from 0-4");
            }
            String semester = userCommands[5].trim();
            boolean isCorrectSemester = semester.equals("1")
                    || semester.equals("1.5")
                    || semester.equals("2")
                    || semester.equals("2.5");
            if (!isCorrectSemester) {
                throw new MainException("Make sure Semester is 1, 1.5 (Sem 1 break), 2 or 2.5 (Sem 2 break)");
            }
        } catch (NumberFormatException e) {
            throw new MainException("Make sure Year of Study is a number from 0-4");
        }
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
            throw new MainException("Make sure Year of Study is a number from 0-4 or \"all\"");
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
            listOfModules.editModularCredits(moduleCode, update);
            break;
        case "TYPE":
            listOfModules.editModuleType(moduleCode, update);
            break;
        case "CODE":
            checkAddInputNoDuplicates(update, listOfModules.getModuleList());
            listOfModules.editModuleCode(moduleCode, update);
            break;
        case "YEAR":
            listOfModules.editYear(moduleCode, update);
            break;
        case "SEMESTER":
            listOfModules.editSemester(moduleCode, update);
            break;
        case "GRADE":
            listOfModules.editModuleGrade(moduleCode, update);
            break;
        default:
            throw new MainException("Make sure the field to edit is MC, type, code, " +
                    "year, semester or grade");
        }
    }

    /**
     * Checks if the grade input by the user is a valid grade string.
     *
     * @param inputGrade the string containing grade input by user.
     * @throws MainException when the input grade is invalid
     */
    private void checkGradeInput(String inputGrade) throws MainException {
        switch (inputGrade) {
        case "A+":
            //Fallthrough
        case "A":
            //Fallthrough
        case "A-":
            //Fallthrough
        case "B+":
            //Fallthrough
        case "B":
            //Fallthrough
        case "B-":
            //Fallthrough
        case "C+":
            //Fallthrough
        case "C":
            //Fallthrough
        case "D+":
            //Fallthrough
        case "D":
            //Fallthrough
        case "F":
            //Fallthrough
        case "S":
            //Fallthrough
        case "U":
            //Fallthrough
        case "CS":
            //Fallthrough
        case "CU":
            break;
        default:
            throw new MainException("Please input a valid grade!");
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