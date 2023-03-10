package seedu.duke;

public class Parser {
    public Parser() {

    }

    public void checkUserInput(String userInput, ModuleList listOfModules) {
        String userCommand = userInput.split("/")[0].trim();
        switch (userCommand) {
        case "man":
            Manpage.printManPage();
            break;
        case "add":
            listOfModules.addModule(userInput.split("/")[1].trim(),
                    userInput.split("/")[2].trim(), userInput.split("/")[3]);
            break;
        case "find":
            listOfModules.findModule(userInput.split("/")[1]);
            break;
        case "delete":
            listOfModules.deleteModule(userInput.split("/")[1]);
            break;
        case "view":
            listOfModules.viewModuleList();
            break;
        default:
            break;
        }

    }

}
