package seedu.duke;

import java.util.ArrayList;
import java.util.logging.Level;

import static java.lang.System.exit;
import static seedu.duke.Duke.LOGGER;

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
            Manpage.printManPageAdd();
            break;
        case "LIST":
            Manpage.printManPageList();
            break;
        case "EDIT":
            Manpage.printManPageEdit();
            break;
        case "FIND":
            Manpage.printManPageFind();
            break;
        case "DELETE":
            Manpage.printManPageDelete();
            break;
        case "CALCULATOR":
            Manpage.printManPageCalculator();
            break;
        case "GRADE":
            Manpage.printManPageUpdateGrade();
            break;
        case "BYE":
            Manpage.printManPageExit();
            break;
        default:
            break;
        }
    }

    /**
     * Checks for valid user commands
     *
     * @param userInput The command that the user inputs to the ChatBot
     * @throws DukeException if user command is invalid
     */
    public void checkUserInput(String userInput, ModuleList moduleList) throws DukeException {

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
                } catch (DukeException e) {
                    Print.printErrorMessage(e);
                    LOGGER.log(Level.WARNING, "User Input is invalid");
                }
                assert userCommands.length == 1;
                Manpage.printManPage();
            }

            LOGGER.log(Level.INFO, "End of manpage process");
            break;
        case "ADD":
            try {
                LOGGER.log(Level.INFO, "Starting addModule process");
                checkAddInput(moduleList, userCommands);
                Storage.saveModules(moduleList.getModuleList());
            } catch (DukeException e) {
                LOGGER.log(Level.WARNING, "addModule Check failed: " + e.getDescription());
                Print.printErrorMessage(e);
            }
            LOGGER.log(Level.INFO, "End of addModule process");
            break;
        case "FIND":
            try {
                int numberOfFields = 3;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 3;
            ArrayList<Module> foundModules = new ArrayList<>();
            if (userCommands[1].trim().equals("CODE")) {
                try {
                    foundModules = moduleList.findModuleByCode(userCommands[2].trim());
                } catch (DukeException e) {
                    Print.printErrorMessage(e);
                }
            } else if (userCommands[1].trim().equals("TYPE")) {
                try {
                    foundModules = moduleList.findModuleByType(userCommands[2].trim());
                } catch (DukeException e) {
                    Print.printErrorMessage(e);
                }
            } else {
                throw new DukeException("Please specify type of search with /Code or /Type");
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
            } catch (DukeException e) {
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
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }

            break;
        case "LIST ALL":
            try {
                int numberOfFields = 1;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 1;
            moduleList.listModulesByYear("1");
            moduleList.listModulesByYear("2");
            moduleList.listModulesByYear("3");
            moduleList.listModulesByYear("4");
            break;
        case "LIST":
            try {
                int numberOfFields = 2;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 2;
            String year = userCommands[1].trim();
            try {
                checkYearInput(year);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
                return;
            }
            moduleList.listModulesByYear(year);
            break;
        case "EDIT":
            try {
                int numberOfFields = 4;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 4;
            try {
                editModuleField(moduleList, userCommands);
                Storage.saveModules(moduleList.getModuleList());
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            break;
        case "GRADE":
            try {
                LOGGER.log(Level.INFO, "Starting Grade process");
                int numberOfFields = 3;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (DukeException e) {
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
            } catch (DukeException e) {
                LOGGER.log(Level.WARNING, "valid grade input check failed: " + e.getDescription());
                Print.printErrorMessage(e);
            }
            break;
        case "CALCULATECAP":
            try {
                LOGGER.log(Level.INFO, "Starting process to calculate CAP");
                int numberOfFields = 1;
                checkNumberOfFields(numberOfFields, userCommands);
            } catch (DukeException e) {
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
            } catch (DukeException e) {
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
            } catch (DukeException e) {
                Print.printErrorMessage(e);
                return;
            }
            assert userCommands.length == 2;
            try {
                trackGraduationRequirements(moduleList, userCommands[1].trim());
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            break;
        default:
            throw new DukeException("Invalid Command");
        }

    }

    /**
     * Checks all the fields of addInput, which is the input captured when add command is called by user.
     * @param listOfModules The currently stored list of modules. Can be loaded or during the session.
     * @param userCommands The input that the user keyed in.
     * @throws DukeException if the user input is invalid.
     */
    private void checkAddInput(ModuleList listOfModules, String[] userCommands) throws DukeException {
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
     * @throws DukeException if user command is invalid
     */
    public void checkNumberOfFields(int numberOfFields, String[] userCommands) throws DukeException {
        if (userCommands.length > numberOfFields) {
            throw new DukeException("Too many fields");
        } else if (userCommands.length < numberOfFields) {
            throw new DukeException("Missing fields");
        }
    }

    private void checkAddInputCorrectModuleCode(String[] userCommands) throws DukeException {
        if (userCommands[1].trim().equals("")) {
            throw new DukeException("Module Code cannot be empty");
        }
        if (userCommands[1].trim().length() < 6) {
            throw new DukeException("Module Code cannot be less than 6 characters!");
        }
    }

    /**
     * Add Command Checks below this point is correct even for new addModule
     */

    private void checkAddInputCorrectModularCreditField(String[] userCommands) throws DukeException {
        try {
            int moduleCredits = Integer.parseInt(userCommands[2].trim());
            if ( moduleCredits < 0 || moduleCredits > 13 || moduleCredits == 7 || moduleCredits == 9
                    || moduleCredits == 10 || moduleCredits == 11) {
                throw new DukeException("Make sure Modular Credits is a number from 0-6, 8 or 12");
            }
        } catch (NumberFormatException e) {
            throw new DukeException("Make sure Modular Credits is a number from 0-6, 8 or 12");
        }
    }

    private void checkAddInputCorrectTypeOfModule(String[] userCommands) throws DukeException {
        String typeOfModule = userCommands[3].trim();
        boolean isCorrectModuleType = typeOfModule.equals("CORE")
                || typeOfModule.equals("UE")
                || typeOfModule.equals("GE")
                || typeOfModule.equals("INTERNSHIP") ;
        if (!isCorrectModuleType) {
            throw new DukeException("Incorrect Module Type, Accepted Module Types are: (CORE, UE ,GE ,INTERNSHIP)");
        }
    }

    private void checkAddInputNoDuplicates(String moduleCode, ArrayList<Module> listOfModules) throws DukeException {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                throw new DukeException(moduleCode + " is already in the list");
            }
        }
    }

    private void checkAddInputYearAndSemester(String[] userCommands) throws DukeException {
        try {
            int year = Integer.parseInt(userCommands[4].trim());
            if (year < 0 || year > 6) {
                throw new DukeException("Make sure Year of Study is a number from 0-6");
            }
            String semester = userCommands[5].trim();
            boolean isCorrectSemester = semester.equals("1")
                    || semester.equals("1.5")
                    || semester.equals("2")
                    || semester.equals("2.5");
            if (!isCorrectSemester) {
                throw new DukeException("Make sure Semester is 1, 1.5 (Sem 1 break), 2 or 2.5 (Sem 2 break)");
            }
        } catch (NumberFormatException e) {
            throw new DukeException("Make sure Year of Study is a number from 0-6");
        }
    }

    private void checkYearInput(String year) throws DukeException {

        int yearOfStudy;
        try {
            yearOfStudy = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            throw new DukeException("Make sure Year of Study is a number from 0-6");
        }
        if (yearOfStudy < 0 || yearOfStudy > 6) {
            throw new DukeException("Make sure Year of Study is a number from 0-6");
        }
    }

    private void editModuleField(ModuleList listOfModules, String[] userCommands) throws DukeException {
        //format: edit /moduleCode /field /update
        String moduleCode = userCommands[1].trim();
        //the field that the user wants to update
        String moduleField = userCommands[2].trim();
        //the new information to replace in the indicated field
        String update = userCommands[3].trim();

        switch (moduleField) {
        case "MC":
            listOfModules.editModularCredits(moduleCode, update);
            break;
        case "TYPE":
            ArrayList<Module> modules = listOfModules.getModuleList();
            for (Module module : modules) {
                if (module.getModuleCode().equals(moduleCode)) {
                    String modularCredits = module.getModularCredits();
                    String year = module.getYear();
                    String semester = module.getSemester();
                    String grade = module.getGrade();
                    listOfModules.editModuleType(moduleCode, modularCredits, update, year, semester, grade);
                    break;
                }
            }
            break;
        case "YEAR":
            listOfModules.editYear(moduleCode, update);
            break;
        case "SEMESTER":
            listOfModules.editSemester(moduleCode, update);
            break;
        default:
            throw new DukeException("Make sure the field to edit is MC, type, year or semester");
        }
    }

    /**
     * Checks if the grade input by the user is a valid grade string.
     *
     * @param inputGrade the string containing grade input by user.
     * @throws DukeException when the input grade is invalid
     */
    private void checkGradeInput (String inputGrade) throws DukeException {
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
            throw new DukeException("Please input a valid grade!");
        }
    }

    /**
     * Check how far the user is from meeting the requirement for each module type
     *
     * @param listOfModules list of modules that the user has
     * @param moduleType module type that the user wants to check
     * @throws DukeException if the moduleType the user input is not valid
     */
    private void trackGraduationRequirements (ModuleList listOfModules, String moduleType) throws DukeException {
        ArrayList<Module> foundModules = new ArrayList<>();
        switch(moduleType) {
        case "ALL":
            String[] moduleTypes = {"CORE", "GE" , "UE", "INTERNSHIP"};
            int[] requiredMCs = {REQUIRED_MC_CORE, REQUIRED_MC_GE, REQUIRED_MC_UE, REQUIRED_MC_INTERNSHIP};
            for (int i = 0; i < moduleTypes.length; i++) {
                listOfModules.trackModules(listOfModules.getModuleList(), moduleTypes[i], requiredMCs[i]);
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
            throw new DukeException("Make sure you're trying to track Core, GE, UE or Internship.");
        }
    }
}
