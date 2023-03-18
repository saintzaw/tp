package seedu.duke;

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
                    LOGGER.log(Level.WARNING, "User Input is invalid" );
                }
                assert userCommands.length == 1;
                Manpage.printManPage();
            }

            LOGGER.log(Level.INFO, "End of manpage process");
            break;

        case "add":
            try {
                checkAddInput(listOfModules, userCommands);
            } catch (DukeException e) {
                LOGGER.log(Level.WARNING, "addModule Check failed: " + e.getDescription());
                Print.printErrorMessage(e);
            }
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
        if (userCommands.length < 4) {
            throw new DukeException("Missing fields");
        } else if (userCommands.length > 4) {
            throw new DukeException("Too many fields");
        }
        //check for correct field in MC
        try {
            int moduleCredits = Integer.parseInt(userCommands[2].trim());
            if ( moduleCredits < 0 || moduleCredits > 13 || moduleCredits == 7 || moduleCredits == 9
        || moduleCredits == 10 || moduleCredits == 11) {
                throw new DukeException("Make sure Modular Credits is a number from 0-6, 8 and 12");
            }
        } catch (NumberFormatException e) {
            throw new DukeException("Make sure Modular Credits is a number from 0-6, 8 and 12");
        }
        //check for correct field in type of module
        String typeOfModule = userCommands[3].trim();
        boolean isCorrectModuleType = typeOfModule.equals("CORE") || typeOfModule.equals("UE")
                || typeOfModule.equals("GE") || typeOfModule.equals("INTERNSHIP") ;
        if (!isCorrectModuleType) {
            throw new DukeException("Incorrect Module Type, " + "Accepted Module Types are: (CORE,UE,GE,INTERNSHIP)");
        }
        assert userCommands.length == 4;
        listOfModules.addModule(userCommands[1].trim(), userCommands[2].trim(), userCommands[3].trim());
    }

    public void checkInputLengthEqualsTwo(String[] userCommands) throws DukeException {
        if (userCommands.length > 2) {
            throw new DukeException("Too many fields");
        } else if (userCommands.length < 2){
            throw new DukeException("Missing fields");
        }
    }

    public void checkInputLengthEqualsOne(String[] userCommands) throws DukeException {
        if (userCommands.length != 1) {
            throw new DukeException("Too many fields");
        }
    }
}
