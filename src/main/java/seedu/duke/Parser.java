package seedu.duke;


import java.util.logging.Level;

import static java.lang.System.exit;
import static seedu.duke.Duke.LOGGER;

public class Parser {
    public Parser() {

    }
    public void checkManPageInput(String userInput) {
        assert userInput.split(" ").length == 2: "Correct input should be man /*command*";
        String userCommand = userInput.split("/")[1].trim();

        switch (userCommand) {

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
        case "exit":
            Manpage.printManPageExit();
            break;
        default:
            break;
        }
    }

    public void checkUserInput(String userInput, ModuleList listOfModules) {
        String[] userCommands = userInput.split("/");
        switch (userCommands[0].trim()) {
        case "man":
            assert userCommands.length >= 1;
            if (userCommands.length == 2) {
                checkManPageInput(userInput);
            } else {
                Manpage.printManPage();
            }
            break;
        case "add":
            assert userCommands.length == 4;
            listOfModules.addModule(userCommands[1].trim(),
                    userCommands[2].trim(), userCommands[3].trim());
            break;
        case "find":
            assert userCommands.length == 2;
            listOfModules.findModule(userCommands[1].trim());
            break;
        case "delete":
            assert userCommands.length == 2;
            listOfModules.deleteModule(userCommands[1].trim());
            break;
        case "list":
            assert userCommands.length == 1;
            listOfModules.viewModuleList();
            break;
        case "bye":
            assert userCommands.length == 1;
            Print.printFarewellMessage();
            LOGGER.log(Level.INFO, "Exiting Modganiser.");
            exit(0);
            break;
        default:
            break;
        }

    }

}
