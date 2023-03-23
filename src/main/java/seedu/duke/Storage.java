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
    private static final String MODULES_FILE_PATH = "data/modules.txt";
    private static final String NAME_FILE_PATH = "data/name.txt";
    private static final String DIRECTORY = "data";

    public static String getSavedName() throws FileNotFoundException {
        File dir = new File(DIRECTORY);
        File f = new File(NAME_FILE_PATH);

        // Creates directory for file if it does not exist
        if (!dir.exists()){
            dir.mkdirs();
        }

        // Create file if it does not exist
        try {
            f.createNewFile();
        } catch (IOException e) {
            Print.printCreateNameFileError();
        }

        // Reading from text file to get stored data
        Scanner s = new Scanner(f);
        String name = "";
        if (s.hasNext()) {
            name = s.nextLine();
        }
        return name;
    }

    public static void saveName(String name) {
        LOGGER.log(Level.INFO, "Starting process to save name to text file");
        try {
            writeNameToFile(name);
            LOGGER.log(Level.INFO, "Finished saving name to text file");
        } catch (IOException e) {
            Print.printNameSavingError();
            LOGGER.log(Level.WARNING, "Failed to save name to text file");
        }
    }

    public static void writeNameToFile(String name) throws IOException {
        FileWriter fw = new FileWriter(NAME_FILE_PATH);
        fw.write(name);
        fw.close();
    }

    public static ArrayList<String> getSavedModules() throws FileNotFoundException {
        File dir = new File(DIRECTORY);
        File f = new File(MODULES_FILE_PATH);

        // Creates directory for file if it does not exist
        if (!dir.exists()){
            dir.mkdirs();
        }

        // Create file if it does not exist
        try {
            f.createNewFile();
        } catch (IOException e) {
            Print.printCreateModulesFileError();
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
            writeModulesToFile(savedModules);
            LOGGER.log(Level.INFO, "Finished saving modules to text file");
        } catch (IOException e) {
            Print.printModulesSavingError();
            LOGGER.log(Level.WARNING, "Failed to save modules to text file");
        }
    }

    private static void writeModulesToFile(ArrayList<Module> savedModules) throws IOException {
        FileWriter fw = new FileWriter(MODULES_FILE_PATH);
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
