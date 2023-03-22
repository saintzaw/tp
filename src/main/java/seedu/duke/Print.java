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

    public static void printEmptyModuleList() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     There are currently no modules in your list");
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

    public static void printCreateFileError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    An error occurred when creating the data file");
        System.out.println("    ____________________________________________________________");
    }

    public static void printSavingError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Data was not saved to file");
        System.out.println("    ____________________________________________________________");
    }

    public static void printFileLoadingError() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Data file was not found");
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

    public static void printGeneralElectiveRequirements(ArrayList<Module> completedModules, int completed_MCs,
                                                        int remaining_MCs, int required_MCs) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the GE modules that you have completed so far:");
        System.out.println("    ____________________________________________________________");
        for (int i = 0; i < completedModules.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + completedModules.get(i));
        }
        System.out.println("     Congratulations! You have completed " + completed_MCs + " of the "
                + required_MCs + " MCs required :)");
        System.out.println("     You need to complete " + remaining_MCs + " MCs more.");
        System.out.println("    ____________________________________________________________");
    }

    public static void printUnrestrictedElectiveRequirements(ArrayList<Module> completedModules, int completed_MCs,
                                                        int remaining_MCs, int required_MCs) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the UE modules that you have completed so far:");
        System.out.println("    ____________________________________________________________");
        for (int i = 0; i < completedModules.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + completedModules.get(i));
        }
        System.out.println("     Congratulations! You have completed " + completed_MCs + " of the "
                + required_MCs + " MCs required :)");
        System.out.println("     You need to complete " + remaining_MCs + " MCs more.");
        System.out.println("    ____________________________________________________________");
    }

    public static void printInternshipRequirements(ArrayList<Module> completedModules, int completed_MCs,
                                                             int remaining_MCs, int required_MCs) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the Internships that you have completed so far:");
        System.out.println("    ____________________________________________________________");
        for (int i = 0; i < completedModules.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + completedModules.get(i));
        }
        System.out.println("     Congratulations! You have completed " + completed_MCs + " of the "
                + required_MCs + " MCs required :)");
        System.out.println("     You need to complete " + remaining_MCs + " MCs more.");
        System.out.println("    ____________________________________________________________");
    }
}
