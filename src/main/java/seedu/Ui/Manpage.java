
package seedu.ui;
public class Manpage {
    public Manpage() {

    }
    public static void printManPage() {
        System.out.println("\n\n\n" +

                    "--------------------USER GUIDE--------------------\n\n" +
                    "Modganiser is effortless module planning, at your fingertips via the " +
                    "Command Line Interface (CLI).\n" +
                    "It helps Information security students graduate in time by " +
                    "giving you a platform to plan all 4 years\n" +
                    "of your modules to ensure that you meet graduation requirements (UE/GEs).\nIf you can type fast," +
                    "Modganiser can get your schedule up  faster than traditional GUI apps.\n\n" +

                    "----------COMMAND SUMMARY----------\n\n " +
                    "Man\n "+
                    "Command: man\n\n " +
                    "Add\n " +
                    "Command: add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE\n\n " +
                    "List\n " +
                    "Command: list all or list /x(year)\n\n " +
                    "Find\n " +
                    "Command: find /MODULE_CODE\n\n " +
                    "Delete\n " +
                    "Command: delete /MODULE_CODE\n\n " +
                    "Exit\n " +
                    "Command: exit\n\n\n"

                    +"----------FEATURES----------\n"

                    +"Type the command in the command box and press Enter to execute it. " +
                    "e.g. typing man and pressing Enter will open the manual.\n"
                    +"Some example commands you can try:\n\n " +

                    "1. Viewing manual: man\n "  +
                    "List the command summary. Example: man \n\n " +

                    "2. Adding a module: add\n Adds a module to the list of modules.\n " +
                    "Format: add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE\n " +
                    "Example: add /CS2113T /4 /CORE\n\n " +

                    "--Module Types--\n " +
                    "CORE\n " +
                    "GE (General modules)\n " +
                    "UE (Unrestricted Electives)\n\n " +

                    "3. List all modules: list all \n " +
                    "Shows a list of all modules in the module planner along with the module type.\n " +
                    "Example: list all\n\n " +

                    "4. List all modules: list /(Year) \n " +
                    "Shows a list of all modules in that year along with the module type.\n " +
                    "Example: list 1\n\n " +

                    "5. Find module: find /(Module Code)\n " +
                    "Find which year and semester I plan to take the module.\n " +
                    "Example: find /CS2113T\n\n " +

                    "6. Delete module: delete /(Module Code)\n " +
                    "Shows a list of all modules in the module planner.\n " +
                    "Example: delete /CS2113T\n\n " +

                    "7. Exit program: exit\n " +
                    "Exit module planner.\n " +
                    "Format: exit\n\n" +

                    "----------FAQ/ERRORS----------\n\n\n" );
    }

}
