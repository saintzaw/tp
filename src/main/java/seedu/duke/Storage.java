package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import static seedu.duke.Duke.LOGGER;

public class Storage {
    private static final String FILE_PATH = "data/modules.txt";
    private static final String DIRECTORY = "data";

    public static ArrayList<String> getSavedModules() throws FileNotFoundException {
        File dir = new File(DIRECTORY);
        File f = new File(FILE_PATH);

        // Creates directory for file if it does not exist
        if (!dir.exists()){
            dir.mkdirs();
        }

        // Create file if it does not exist
        try {
            f.createNewFile();
        } catch (IOException e) {
            Print.printCreateFileError();
        }

        // Reading from text file to get stored data
        Scanner s = new Scanner(f);
        ArrayList<String> savedModules = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            savedModules.add(line);
        }
        return savedModules;
    }

    public static void saveModules(ArrayList<Module> savedModules) {
        LOGGER.log(Level.INFO, "Starting process to save modules to text file");
        try {
            writeToFile(savedModules);
            LOGGER.log(Level.INFO, "Finished saving modules to text file");
        } catch (IOException e) {
            Print.printSavingError();
            LOGGER.log(Level.WARNING, "Failed to save modules to text file");
        }
    }

    private static void writeToFile(ArrayList<Module> savedModules) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        for (int i = 0; i < savedModules.size(); i++) {
            Module currModule = savedModules.get(i);

            // Determine module type and add module type
            String lineToWrite = currModule.getModuleType();
            lineToWrite += "|" + currModule.getGrade(); // Add grade
            lineToWrite += "|" + currModule.getModuleCode(); // Add module code
            lineToWrite += "|" + currModule.getModularCredits(); // Add MC
            lineToWrite += "|" + currModule.getYear(); // Add year
            lineToWrite += "|" + currModule.getSemester(); // Add semester

            lineToWrite += System.lineSeparator();
            fw.write(lineToWrite);
        }
        fw.close();
    }
}
