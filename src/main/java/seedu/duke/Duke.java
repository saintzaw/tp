package seedu.duke;

import java.util.Scanner;

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

    public static void run(Duke ChatBot) {
        Print.printHelloMessage();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println("Hello " + line);
        while (in.hasNextLine()) {
            line = in.nextLine();
            ChatBot.parser.checkUserInput(line, ChatBot.moduleList);
        }
    }

    public static void main(String[] args) {
        Duke ChatBot = new Duke();
        Duke.run(ChatBot);
    }
}
