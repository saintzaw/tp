package seedu.duke;

import seedu.modules.ModuleList;
import seedu.ui.Print;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private Parser parser;
    private ModuleList moduleList;
    public Duke () {
        parser = new Parser();
    }

    public static void run (Duke ChatBot) {
        Print.printHelloMessage();
        while (true) {
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            ChatBot.parser.checkUserInput(line, ChatBot.moduleList);
        }
    }

    public static void main(String[] args) {
        Duke ChatBot = new Duke();
        Duke.run(ChatBot);
    }
}
