package seedu.duke;

import java.util.Scanner;

import static seedu.duke.Print.printFarewellMessage;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private Parser parser;
    private ModuleList moduleList;
    public Duke() {
        parser = new Parser();
        moduleList = new ModuleList();
    }

    public static boolean isNameBye (String name) {
        return name.equalsIgnoreCase("bye");
    }

    public static void run(Duke chatBot) {
        Scanner in = new Scanner(System.in);
        Print.printLogo();
        System.out.println("What is your name?");
        String name = in.nextLine();
        if (isNameBye(name.trim())) {
            printFarewellMessage();
            return;
        }
        Print.printHelloMessage(name);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            chatBot.parser.checkUserInput(line, chatBot.moduleList);
        }
    }

    public static void main(String[] args) {
        Duke chatBot = new Duke();
        Duke.run(chatBot);
    }

}
