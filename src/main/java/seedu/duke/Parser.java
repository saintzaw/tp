package seedu.duke;

import java.util.ArrayList;
import java.util.logging.Level;

import static java.lang.System.exit;
import static seedu.duke.Duke.LOGGER;

public class Parser {
    public Parser() {

    }


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
            Manpage.printManPageCalculatorInput();
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
            assert userCommands.length >= 1;

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
            if (userCommands[1].trim().equals("NAME")) {
                try {
                    foundModules = moduleList.findModuleByName(userCommands[2].trim());
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
                throw new DukeException("Please specify type of search with /Name or /Type");
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
            moduleList.listModules();
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
            }
            assert userCommands.length == 2;
            try {
                trackGraduationRequirements(moduleList, userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            break;
        default:
            throw new DukeException("Invalid Command");
        }

    }

    private void checkAddInput(ModuleList listOfModules, String[] userCommands) throws DukeException {
        //check for correct number of fields
        int numberOfFields = 6;
        checkNumberOfFields(numberOfFields, userCommands);

        assert userCommands.length == 6 : "Expected 6 fields"; //change to 6 after year and sem added.

        //check for non-empty moduleCode field
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

    private void checkGradeInput (String inputGrade) throws DukeException {
        switch (inputGrade) {
        case "A+":
        case "A":
        case "A-":
        case "B+":
        case "B":
        case "B-":
        case "C+":
        case "C":
        case "D+":
        case "D":
        case "F":
        case "S":
        case "U":
        case "CS":
        case "CU":
            break;
        default:
            throw new DukeException("Please input a valid grade!");
        }
    }

    private void trackGraduationRequirements (ModuleList listOfModules, String[] userCommands) throws DukeException {
        String moduleType = userCommands[1].trim();
        ArrayList<Module> foundModules = new ArrayList<>();
        switch(moduleType) {
        case "GE":
            foundModules = listOfModules.findModuleByType("GE");
            listOfModules.trackGeneralElectives(foundModules, moduleType);
            break;
        case "UE":
            foundModules = listOfModules.findModuleByType("UE");
            listOfModules.trackUnrestrictedElectives(foundModules, moduleType);
            break;
        case "INTERNSHIP":
            foundModules = listOfModules.findModuleByType("INTERNSHIP");
            listOfModules.trackInternship(foundModules, moduleType);
            break;
        case "CORE":
            foundModules = listOfModules.findModuleByType("CORE");
            listOfModules.trackCoreModules(foundModules, moduleType);
            break;
        default:
            throw new DukeException("Make sure you're trying to track COre, GE, UE or Internship.");
        }
    }
}
