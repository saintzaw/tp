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

    public static void run(Duke chatBot) {
        Scanner in = new Scanner(System.in);
        Print.printHelloMessage(in);
        while (in.hasNextLine()) {
            String line = in.nextLine();

            if(line.equalsIgnoreCase("bye")) {
                printFarewellMessage();
                break;
            }
            chatBot.parser.checkUserInput(line, chatBot.moduleList);
        }
    }

    public static void main(String[] args) {
        Duke chatBot = new Duke();
        Duke.run(chatBot);
    }

}
