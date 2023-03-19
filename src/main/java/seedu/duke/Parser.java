package seedu.duke;

import java.util.ArrayList;
import java.util.logging.Level;

import static java.lang.System.exit;
import static seedu.duke.Duke.LOGGER;

public class Parser {
    public Parser() {

    }
    public void checkManPageInput(String userInput) {
        String[] userCommands = userInput.split("/");
        assert userCommands.length == 2;

        switch (userCommands[1]) {
        case "add":
            Manpage.printManPageAdd();
            break;
        case "list":
            Manpage.printManPageList();
            break;
        case "find":
            Manpage.printManPageFind();
            break;
        case "delete":
            Manpage.printManPageDelete();
            break;
        case "bye":
            Manpage.printManPageExit();
            break;
        default:
            break;
        }
    }

    public void checkUserInput(String userInput, ModuleList listOfModules) throws DukeException {

        String[] userCommands = userInput.split("/");

        switch (userCommands[0].trim()) {
        case "man":
            LOGGER.log(Level.INFO, "Starting manpage process");
            assert userCommands.length >= 1;

            if (userCommands.length == 2) {
                checkManPageInput(userInput);
            } else {
                try {
                    checkInputLengthEqualsOne(userCommands);
                } catch (DukeException e) {
                    Print.printErrorMessage(e);
                    LOGGER.log(Level.WARNING, "User Input is invalid");
                }
                assert userCommands.length == 1;
                Manpage.printManPage();
            }

            LOGGER.log(Level.INFO, "End of manpage process");
            break;
        case "add":
            try {
                LOGGER.log(Level.INFO, "Starting addModule process");
                checkAddInput(listOfModules, userCommands);
            } catch (DukeException e) {
                LOGGER.log(Level.WARNING, "addModule Check failed: " + e.getDescription());
                Print.printErrorMessage(e);
            }
            LOGGER.log(Level.INFO, "End of addModule process");
            break;
        case "find":
            try {
                checkInputLengthEqualsTwo(userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 2;
            try {
                listOfModules.findModule(userCommands[1].trim());
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            break;
        case "delete":
            try {
                checkInputLengthEqualsTwo(userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 2;
            try {
                listOfModules.deleteModule(userCommands[1].trim());
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            break;
        case "list all":
            try {
                checkInputLengthEqualsOne(userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 1;
            listOfModules.listModules();
            break;
        case "edit":
            try {
                checkInputLengthEqualsFour(userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 4;
            try {
                editModuleField(listOfModules, userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            break;
        case "bye":
            try {
                checkInputLengthEqualsOne(userCommands);
            } catch (DukeException e) {
                Print.printErrorMessage(e);
            }
            assert userCommands.length == 1;
            Print.printFarewellMessage();
            LOGGER.log(Level.INFO, "Exiting Modganiser.");
            exit(0);
            break;
        default:
            throw new DukeException("Invalid Command");
        }
    }

    private void checkAddInput(ModuleList listOfModules, String[] userCommands) throws DukeException {
        //check for correct number of fields
        checkAddInputNumberOfFields(userCommands);

        //check for correct field in MC
        checkAddInputCorrectModularCreditField(userCommands);

        //check for correct field in type of module
        checkAddInputCorrectTypeOfModule(userCommands);

        //check for duplicate names
        String[] moduleList = userCommands[1].trim().split(" ");
        for (String moduleCode: moduleList) {
            checkAddInputNoDuplicates(moduleCode.trim(), listOfModules.getModuleList());
        }

        assert userCommands.length == 4; //change to 6 after year and sem added.
        for (String moduleCode: moduleList) {
            listOfModules.addModule(moduleCode.trim(), userCommands[2].trim(), userCommands[3].trim());
        }
        /*
        //check for correct year and semester
        checkAddInputYearAndSemester(userCommands);

        assert userCommands.length = 6:
         */
    }

    public void checkInputLengthEqualsTwo(String[] userCommands) throws DukeException {
        if (userCommands.length > 2) {
            throw new DukeException("Too many fields");
        } else if (userCommands.length < 2){
            throw new DukeException("Missing fields");
        }
    }

    public void checkInputLengthEqualsFour(String[] userCommands) throws DukeException {
        if (userCommands.length > 4) {
            throw new DukeException("Too many fields");
        } else if (userCommands.length < 4){
            throw new DukeException("Missing fields");
        }
    }

    public void checkInputLengthEqualsOne(String[] userCommands) throws DukeException {
        if (userCommands.length != 1) {
            throw new DukeException("Too many fields");
        }
    }
    private void checkAddInputNumberOfFields(String[] userCommands) throws DukeException {
        if (userCommands.length < 4) {
            // change to 6 after year and sem changes
            throw new DukeException("Missing fields");
        } else if (userCommands.length > 4) {
            throw new DukeException("Too many fields");
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
                throw new DukeException("Make sure Modular Credits is a number from 0-6, 8 and 12");
            }
        } catch (NumberFormatException e) {
            throw new DukeException("Make sure Modular Credits is a number from 0-6, 8 and 12");
        }
    }

    private void checkAddInputCorrectTypeOfModule(String[] userCommands) throws DukeException {
        String typeOfModule = userCommands[3].trim();
        boolean isCorrectModuleType = typeOfModule.equalsIgnoreCase("CORE")
                || typeOfModule.equalsIgnoreCase("UE")
                || typeOfModule.equalsIgnoreCase("GE")
                || typeOfModule.equalsIgnoreCase("INTERNSHIP") ;
        if (!isCorrectModuleType) {
            throw new DukeException("Incorrect Module Type, " + "Accepted Module Types are: (CORE,UE,GE,INTERNSHIP)");
        }
    }

    private void checkAddInputNoDuplicates(String moduleCode, ArrayList<Module> listOfModules) throws DukeException {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equalsIgnoreCase(moduleCode)) {
                throw new DukeException(moduleCode + " is already in the list");
            }
            return;
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
        String field = userCommands[2].trim();
        //the new information to replace in the indicated field
        String update = userCommands[3].trim();

        switch (field) {
        case "MC":
            listOfModules.editModularCredits(moduleCode, update);
            break;
        case "type":
            String modularCredits = listOfModules.getModularCredits(moduleCode);
            String year = listOfModules.getYear(moduleCode);
            String semester = listOfModules.getSemester(moduleCode);
            listOfModules.editModuleType(moduleCode, modularCredits, update, year, semester);
            break;
        case "year":
            listOfModules.editYear(moduleCode, update);
            break;
        case "semester":
            listOfModules.editSemester(moduleCode, update);
            break;
        default:
            throw new DukeException("Make sure the field to edit is MC, type, year or semester");
        }
    }

}
