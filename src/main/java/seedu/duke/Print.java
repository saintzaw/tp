package seedu.duke;
import java.util.ArrayList;

public class Print {

    public static void printHelloMessage(String name) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello " + name + "! I'm your personal Modganiser.");
        System.out.println("     What would you like to plan today?");
        System.out.println("     To find out more, type `man` and press enter :)");
        System.out.println("    ____________________________________________________________");
    }

    public static void printLogo() {
        String logo = "  __  __               _                           _\n" +
                " |  \\/  |   ___     __| |   __ _    __ _   _ __   (_)  ___    ___   _ __\n" +
                " | |\\/| |  / _ \\   / _` |  / _` |  / _` | | '_ \\  | | / __|  / _ \\ | '__|\n" +
                " | |  | | | (_) | | (_| | | (_| | | (_| | | | | | | | \\__ \\ |  __/ | |\n" +
                " |_|  |_|  \\___/   \\__,_|  \\__, |  \\__,_| |_| |_| |_| |___/  \\___| |_|\n" +
                "                           |___/";

        System.out.println("Hello from\n" + logo);
    }

    public static void promptForName() {
        System.out.println("What is your name?");
    }

    public static void printInvalidNameMessage() {
        System.out.println("Please key in a valid name:");
    }

    public static void printFoundModule(ArrayList<Module> foundModules) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the matching modules in your list:");
        System.out.println("    ____________________________________________________________");
        for (int i = 0; i < foundModules.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + foundModules.get(i));
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void printNoModuleFound(String keyword) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     There are no modules that match the keyword: " + keyword + " in your list");
        System.out.println("    ____________________________________________________________");
    }

    public static void printDeletedModule(Module deletedModule, int numOfModules) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Noted. I've removed this module:");
        System.out.println("       " + deletedModule);
        System.out.println("     Now you have " + numOfModules + " modules in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public static void printNoDeletedModuleFound(String moduleCode) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     There is no module that matches the module code: " + moduleCode + " in your list");
        System.out.println("    ____________________________________________________________");
    }

    public static void printAddedModule(Module addedModule, int numOfModules) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this module:");
        System.out.println("       " + addedModule);
        System.out.println("     Now you have " + numOfModules + " modules in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public static void printEditedModule(Module editedModule, int numOfModules) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've edited the information for this module:");
        System.out.println("       " + editedModule);
        System.out.println("     Now you have " + numOfModules + " modules in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public static void printModuleList(ArrayList<Module> listOfModules) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the modules in your list:");
        for (int i = 0; i < listOfModules.size(); i++) {
            System.out.println("     " + (i + 1) + "." + listOfModules.get(i));
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void printModuleListByYear(ArrayList<String> semOneModuleList,
                                             ArrayList<String> specialTermOneModuleList,
                                             ArrayList<String> semTwoModuleList,
                                             ArrayList<String> specialTermTwoModuleList ,String year) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the modules in your list for Year " + year + " :");
        System.out.println("    ____________________________________________________________");
        System.out.printf("       %-30s %-10s %-30s %-10s %-30s %-10s %-30s\n", "Semester One", "|",
                "Special Term One", "|", "Semester Two", "|", "Special Term Two");


        int max = Math.max(Math.max(semOneModuleList.size(), specialTermOneModuleList.size()),
                Math.max(semTwoModuleList.size(), specialTermTwoModuleList.size()));

        for (int i = 0; i < max; i++) {
            String semOne;
            String specialTermOne;
            String semTwo;
            String specialTermTwo;

            if (i < semOneModuleList.size()) {
                semOne = semOneModuleList.get(i);
            } else {
                semOne = " ";
            }

            if (i < specialTermOneModuleList.size()) {
                specialTermOne = specialTermOneModuleList.get(i);
            } else {
                specialTermOne = " ";
            }

            if (i < semTwoModuleList.size()) {
                semTwo = semTwoModuleList.get(i);
            } else {
                semTwo = " ";
            }

            if (i < specialTermTwoModuleList.size()) {
                specialTermTwo = specialTermTwoModuleList.get(i);
            } else {
                specialTermTwo = " ";
            }

            System.out.printf("       %-30s %-10s %-30s %-10s %-30s %-10s %-30s\n", semOne, "|", specialTermOne, "|",
                    semTwo, "|", specialTermTwo);
        }
    }

    public static void printEmptyModuleList(String year) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     There are currently no modules in your list for Year " + year);
        System.out.println("    ____________________________________________________________");
    }


    public static void printFarewellMessage() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye! Hope you enjoyed using Modganiser!");
        System.out.println("    ____________________________________________________________");
    }

    public static void printErrorMessage(DukeException e) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Error: " + e.getDescription());
        System.out.println("    ____________________________________________________________");
    }

    public static void printCreateNameFileError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    An error occurred when creating the name file");
        System.out.println("    ____________________________________________________________");
    }

    public static void printCreateModulesFileError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    An error occurred when creating the modules file");
        System.out.println("    ____________________________________________________________");
    }

    public static void printModulesSavingError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Modules were not saved to file");
        System.out.println("    ____________________________________________________________");
    }

    public static void printNameSavingError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Name was not saved to file");
        System.out.println("    ____________________________________________________________");
    }

    public static void printModulesFileLoadingError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Modules file was not found");
        System.out.println("    ____________________________________________________________");
    }

    public static void printNameFileLoadingError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Name file was not found");
        System.out.println("    ____________________________________________________________");
    }

    public static void printUpdatedModuleGrade(Module updatedModule) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've updated the grade for this module:");
        System.out.println("       " + updatedModule);
        System.out.println("    ____________________________________________________________");
    }

    public static void printInvalidModule(String moduleCode) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Unable to update the grade for " + moduleCode + " as it's not in your list!");
        System.out.println("    ____________________________________________________________");
    }

    public static void printCalculatedCAP(double calculatedCAP) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     I have calculated your CAP across your graded modules!");
        System.out.println("     Your CAP is currently: " + calculatedCAP + " :)");
        System.out.println("    ____________________________________________________________");
    }

    public static void printModuleTypeRequirements(ArrayList<Module> completedModules, int completedMCs,
                                                        int remainingMCs, int requiredMCs, String moduleType) {
        System.out.println("    ____________________________________________________________");
        if (completedModules.size() == 0) {
            System.out.println("     You have not completed any " + moduleType + " modules yet");
            System.out.println("    ____________________________________________________________");
        } else {
            System.out.println("     Here are the " + moduleType + " modules that you have completed so far:");
            System.out.println("    ____________________________________________________________");
            for (int i = 0; i < completedModules.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + completedModules.get(i));
            }
            System.out.println("     Congratulations! You have completed " + completedMCs + " of the "
                    + requiredMCs + " MCs required :)");
        }
        System.out.println("     You need to complete " + remainingMCs + " MCs more.");
        System.out.println("    ____________________________________________________________");
    }

}
