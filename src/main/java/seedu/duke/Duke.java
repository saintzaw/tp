package seedu.duke;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.duke.Print.printFarewellMessage;

/**
 * Represents a ChatBot that acts as a Module Planner
 */
public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Parser parser;
    private ModuleList moduleList;

    /**
     * Loads users saved tasks if any
     */
    public Duke() {
        initialiseLogger();
        parser = new Parser();
        try {
            moduleList = new ModuleList(Storage.getSavedModules());
        } catch (FileNotFoundException e) {
            Print.printModulesFileLoadingError();
            moduleList = new ModuleList();
        }
    }

    /**
     * Checks if user key in name is bye as it indicates that user wants exit program
     *
     * @param name The string that the user inputs
     * @return a boolean that is set to true if the string given is "bye", else set to false.
     */
    public static boolean isNameBye(String name) {
        return name.equalsIgnoreCase("bye");
    }

    /**
     * Starts Chatbot and reads in user input
     *
     * @param chatBot Chatbot represents the module planner
     */
    public static void run(Duke chatBot) {
        LOGGER.log(Level.INFO, "Modganiser is starting up!");
        Print.printLogo();

        Scanner in = new Scanner(System.in);
        String name;
        try {
            name = getUserName(in);
        } catch (FileNotFoundException e) {
            Print.printNameFileLoadingError();
            return;
        }

        if (isNameBye(name.trim())) {
            printFarewellMessage();
            LOGGER.log(Level.INFO, "Name was given as 'bye', exiting Modganiser.");
            return;
        }
        assert !(name.equalsIgnoreCase("bye")) : "name is bye";
        Print.printHelloMessage(name);

        while (in.hasNextLine()) {
            String line = in.nextLine().toUpperCase();
            try {
                chatBot.parser.checkUserInput(line, chatBot.moduleList);
            } catch (DukeException e){
                Print.printErrorMessage(e);
            }
        }
    }

    public static String getUserName(Scanner in) throws FileNotFoundException{
        String savedName = Storage.getSavedName();
        String name = "";
        boolean nameIsValid = true;

        if (isNameSaved(savedName)) {
            name = savedName;
        } else {
            Print.promptForName();
            do {
                if (!nameIsValid) {
                    Print.printInvalidNameMessage();
                }
                name = in.nextLine().trim();
                if (name.trim().length() == 0) {
                    nameIsValid = false;
                } else {
                    nameIsValid = true;
                }
            } while (!nameIsValid);
            assert !(name.equalsIgnoreCase("bye")) : "name is bye";
            if (!name.equalsIgnoreCase("bye")) {
                Storage.saveName(name);
            }
        }
        return name;
    }

    public static boolean isNameSaved(String name) {
        if (name.length() == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Duke chatBot = new Duke();
        Duke.run(chatBot);
    }

    /**
     * Initialises the logger to log information about processes throughout the runtime of the program.
     * Logging information is written into the file "modganiserLog.txt".
     */
    private static void initialiseLogger() {
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        LOGGER.addHandler(consoleHandler);
        try {
            FileHandler fh = new FileHandler("modganiserLog.txt");
            fh.setLevel(Level.FINE);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            LOGGER.addHandler(fh);
        } catch (java.io.IOException e) {
            LOGGER.log(Level.SEVERE, "Error in file logger!", e);
        }
    }

}
