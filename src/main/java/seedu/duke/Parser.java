package seedu.duke;

import seedu.modules.ModuleList;
import seedu.ui.Manpage;

public class Parser {
    public Parser () {

    }
    public void checkUserInput(String userInput, ModuleList listOfModules) {
        String userCommand = userInput.split("/")[0];
        switch (userCommand) {
        case "man":
            Manpage.printManPage();
            break;
        case "find":
            listOfModules.findModule(userInput.split("/")[1]);
            break;
        default:
            break;
        }

    }

}
