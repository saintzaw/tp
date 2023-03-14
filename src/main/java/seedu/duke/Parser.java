package seedu.duke;


import static java.lang.System.exit;

public class Parser {
    public Parser() {

    }
    public void checkManPageInput(String userInput) {
        assert userInput.split(" ").length==2: "Correct input should be man /*command*";
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
        String userCommand = userInput.split("/")[0].trim();
        switch (userCommand) {
        case "man":
            String[] input=userInput.split("/");
            if (input.length>1) {
                checkManPageInput(userInput);
            } else {
                Manpage.printManPage();
            }
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
        case "list":
            listOfModules.viewModuleList();
            break;
        case "bye":
            Print.printFarewellMessage();
            exit(0);
            break;
        default:
            break;
        }

    }

}
