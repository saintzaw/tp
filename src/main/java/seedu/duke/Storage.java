package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static final String filePath = "data/modules.txt";

    public static ArrayList<String> getSavedModules() throws FileNotFoundException {
        File dir = new File("data");
        File f = new File(filePath);

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
        try {
            writeToFile(savedModules);
        } catch (IOException e) {
            Print.printSavingError();
        }
    }

    private static void writeToFile(ArrayList<Module> savedModules) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < savedModules.size(); i++) {
            Module currModule = savedModules.get(i);

            // Determine module type and add module type
            String lineToWrite = currModule.getModuleType();
            lineToWrite += "|" + currModule.getModuleCode(); // Add module code
            lineToWrite += "|" + currModule.getModularCredits(); // Add MC
            lineToWrite += "|" + currModule.getYear(); // Add year
            lineToWrite += "|" + currModule.getSemester(); // Add semester

            // Add grade
            //lineToWrite += "|" + currModule.getGrade();

            lineToWrite += System.lineSeparator();
            fw.write(lineToWrite);
        }
        fw.close();
    }
}
