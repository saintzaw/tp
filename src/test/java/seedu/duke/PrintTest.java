package seedu.duke;
/*
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
*/
public class PrintTest {
/*

    @Test
    public void printAddedModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        moduleList.addModule("CS2113T", "4", "CORE");
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Got it. I've added this module:" + System.lineSeparator()
                + "       [C][\" \"] CS2113T 4 MCs" + System.lineSeparator()
                + "     Now you have 1 modules in the list."
                + System.lineSeparator() + "    ____________________________________________________________"
                + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printFoundModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        moduleList.addModule("CS2113T", "4", "CORE");
        System.setOut(new PrintStream(outContent));
        try {
            moduleList.findModuleByName("CS2113T");
        } catch (DukeException e) {
            return;
        }
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Here are the matching modules in your list:" + System.lineSeparator()
                + "    ____________________________________________________________" + System.lineSeparator()
                + "     1. [C][\" \"] CS2113T 4 MCs" + System.lineSeparator()
                + "    ____________________________________________________________" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printNotFoundModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        moduleList.addModule("CS2113T", "4", "CORE");
        System.setOut(new PrintStream(outContent));
        try {
            moduleList.findModuleByType("GE");
        } catch (DukeException e) {
            return;
        }
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator()
                + "     There are no modules that match the keyword: GE in your list" + System.lineSeparator()
                + "    ____________________________________________________________" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printDeletedModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        moduleList.addModule("CS2113T", "4", "CORE");
        System.setOut(new PrintStream(outContent));
        try {
            moduleList.deleteModule("CS2113T");
        } catch (DukeException e) {
            return;
        }
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Noted. I've removed this module:" + System.lineSeparator()
                + "       [C][\" \"] CS2113T 4 MCs" + System.lineSeparator()
                + "     Now you have 0 modules in the list."
                + System.lineSeparator() + "    ____________________________________________________________"
                + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printModuleListTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        moduleList.listModules();
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Here are the modules in your list:" + System.lineSeparator()
                + "     1.[C][\" \"] CS2113T 4 MCs" + System.lineSeparator()
                + "    ____________________________________________________________"
                + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printManPageTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPage();
        String expectedOutput = System.lineSeparator() + System.lineSeparator() +

                "--------------------USER GUIDE--------------------" +
                System.lineSeparator() + System.lineSeparator() +
                "Modganiser is effortless module planning, at your fingertips via the " +
                "Command Line Interface (CLI)." + System.lineSeparator() +
                "It helps Information security students graduate in time by " +
                "giving you a platform to plan all 4 years" + System.lineSeparator() +
                "of your modules to ensure that you meet graduation requirements (UE/GEs)." +
                System.lineSeparator() + "If you can type fast," +
                "Modganiser can get your schedule up  faster than traditional GUI apps." +
                System.lineSeparator() + System.lineSeparator() +

                "----------COMMAND SUMMARY----------" + System.lineSeparator() + System.lineSeparator()
                + " " +
                "1. Man" + System.lineSeparator() + " " +
                "Command: man" + System.lineSeparator() + System.lineSeparator() + " " +

                "2. Add" + System.lineSeparator() + " " +
                "Command: add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE /YEAR /SEM"
                + System.lineSeparator() + " " +
                "Example for year 1 semester 1 : add /CS2113T /4 /CORE /1 /1" +
                System.lineSeparator() + " " +
                "Example for year 3 semester 2 : add /ATAP /12 /INTERNSHIP /3 /2" +
                System.lineSeparator() + " " +
                "To find out more, use the command: man /add"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "3. List" + System.lineSeparator() + " " +
                "Command: list all or list /Year" + System.lineSeparator()
                + " " +
                "To find out more, use the command: man /list"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "4. Edit" + System.lineSeparator() + " " +
                "Command: edit /MODULE_CODE /fieldToEdit /newInfo" +
                System.lineSeparator() + " " +
                "To find out more, use the command: man /edit"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "5. Find" + System.lineSeparator() + " " +
                "Command: find /MODULE_CODE or MODULE_TYPE /keyword" + System.lineSeparator()
                + " " +
                "To find out more, use the command: man /find"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "6. Delete" + System.lineSeparator() + " " +
                "Command: delete /MODULE_CODE" + System.lineSeparator()
                + " " + "To find out more, use the command: man /delete"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "7. Grade Calculator" + System.lineSeparator() + " " +
                "Command: calculatecap" + System.lineSeparator()
                + " " + "To find out more, use the command: man /calculator"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "8. Input/Update Grades" + System.lineSeparator() + " " +
                "Command: grade /MODULE_CODE /GRADE" + System.lineSeparator()
                + " " + "To find out more, use the command: man /grade"
                + System.lineSeparator() + System.lineSeparator() + " " +

                "9. Exit" + System.lineSeparator() + " " +
                "Command: bye" + System.lineSeparator() + " "+
                "To find out more, use the command: man /bye"
                + System.lineSeparator() + System.lineSeparator() + " "
                +"-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));

    }
    @Test
    public void printManPageAddTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageAdd();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                + "-----------------------------------------------------\n"+

                "Adding a module: add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE /YEAR /SEM"
                + System.lineSeparator() + " " +
                "Adds a module to the list of modules."
                + System.lineSeparator() + " " +
                "Year includes {1, 2, 3, 4, 5, 6}"
                + System.lineSeparator() + " " +
                "Semester includes  {1, 1.5(semester 1 break), 2, 2.5(semester 2 break)}"+
                System.lineSeparator() + " " +
                "Multiple modules could be added at the same time, like: "+
                "add /CS2113T IS4231 CS1010 /4 /CORE /1 /1 for year 1 semester 1"
                + System.lineSeparator() + " " +
                "Example for year 1 semester 1: add /CS2113T /4 /CORE /1 /1" + System.lineSeparator() + " " +
                "Example for year 3 semester 2 : add /ATAP /12 /INTERNSHIP /3 /2" +
                System.lineSeparator()+System.lineSeparator() + " " +

                "--Module Types--" + System.lineSeparator() + " " +
                "CORE" + System.lineSeparator() + " " +
                "GE (General modules)" + System.lineSeparator() + " " +
                "UE (Unrestricted Electives)" + System.lineSeparator() +" "+
                "INTERNSHIP (Module Code : ATAP, SIP1, SIP2, IIP, NOC, CVWO1, CVWO2)"+ System.lineSeparator()
                +System.lineSeparator()
                + " " +"-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));

    }

    @Test
    public void printManPageListTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageList();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                +"-----------------------------------------------------\n"+
                "List all modules: list all " + System.lineSeparator() + " " +
                "Shows a list of all modules in the module planner along with the module type." +
                System.lineSeparator() + " " +
                "Example: list all" + System.lineSeparator() + System.lineSeparator() + " " +

                "List all modules: list /(Year) "+System.lineSeparator()+" " +
                "Shows a list of all modules in that year along with the module type."
                + System.lineSeparator() + " " +
                "Example: list 1" + System.lineSeparator() + System.lineSeparator() + " " +
                "-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }

    @Test
    public void printManPageEditTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageEdit();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                + "-----------------------------------------------------"+System.lineSeparator() +" "+
                "Edit modules: edit /MODULE_CODE /fieldToEdit /newInfo" +System.lineSeparator() +" "+
                "Shows a list of all modules in that year along with the module type." +System.lineSeparator() +" "+
                "Example: To change CS1010 modular credits field from 6 to 4, the command" +
                "will be : edit /CS1010 /MC /4" +System.lineSeparator() +System.lineSeparator() +" "+

                "fieldToEdit includes:"+System.lineSeparator() +" "+
                "1. modular credits will be /MC"+System.lineSeparator() +" "+
                "2. MODULE_TYPE will be /TYPE" +System.lineSeparator() +" "+
                "3. Year will be /YEAR"+ System.lineSeparator() +" "+
                "4. Semester will be /SEMESTER" +System.lineSeparator() +System.lineSeparator() +" "+

                "-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }

    @Test
    public void printManPageFindTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageFind();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                + "-----------------------------------------------------\n"+

                "Find module: find /MODULE_CODE or MODULE_TYPE /keyword" + System.lineSeparator() + " " +
                "Find which year and semester I plan to take the module." + System.lineSeparator() + " " +
                "Example: In a list with CS2113T and CS2101 as both core modules."+ System.lineSeparator() + " " +
                "1.  find /name /CS2113 will show the CS2113T module only" + System.lineSeparator() + " " +
                "2.  find /type /CORE  will show both CS2113T and CS2101 modules" +
                System.lineSeparator() + System.lineSeparator() + " "
                +"-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }

    @Test
    public void printManPageDeleteTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageDelete();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                + "-----------------------------------------------------\n"+

                "Delete module: delete /(Module Code)" + System.lineSeparator() + " " +
                "Shows a list of all modules in the module planner." + System.lineSeparator() + " " +
                "Example: delete /CS2113T" + System.lineSeparator() + System.lineSeparator() + " "
                +"-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }
    @Test
    public void printManPageCalculatorTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageCalculator();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                + "-----------------------------------------------------"+ System.lineSeparator() + " " +
                "Grade calculator: calculatecap" + System.lineSeparator() + " " +
                "Calculates your cap" +System.lineSeparator()+  System.lineSeparator() + " " +
                "-----------------------------------------------------"+System.lineSeparator() + " " ;

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }
    @Test
    public void printManPageCalculatorInputTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageCalculatorInput();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                + "-----------------------------------------------------"+ System.lineSeparator() + " " +
                "Input/Update Grades: grade /MODULE_CODE /GRADE"+  System.lineSeparator() + " " +
                "Updates your cap"+  System.lineSeparator() + " " +
                "Example: grade /CS2101 /A+"
                +  System.lineSeparator()+  System.lineSeparator() + " " +
                "Grades:" +System.lineSeparator() + " " +
                "A+ [5.0]" +System.lineSeparator() + " " +
                "A [5.0]" +System.lineSeparator() + " " +
                "A- [4.5]"+System.lineSeparator() + " " +
                "B+ [4.0]"+System.lineSeparator() + " " +
                "B [3.5]" +System.lineSeparator() + " " +
                "B- [3.0]" +System.lineSeparator() + " " +
                "C+ [2.5]" +System.lineSeparator() + " " +
                "C [2.0]" +System.lineSeparator() + " " +
                "D+ [1.5]" +System.lineSeparator() + " " +
                "D [1.0]" +System.lineSeparator() + " " +
                "F [0]" +System.lineSeparator()+System.lineSeparator() + " " +
                "-----------------------------------------------------"+System.lineSeparator() + " " ;

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }
    @Test
    public void printManPageExitTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Manpage.printManPageExit();
        String expectedOutput = System.lineSeparator() + System.lineSeparator()
                +"-----------------------------------------------------\n"+

                "Exit program: bye" + System.lineSeparator() + " " +
                "Exit module planner." + System.lineSeparator() + " " +
                "Format: bye" + System.lineSeparator() + System.lineSeparator()
                +"-----------------------------------------------------\n";

        assertEquals(expectedOutput.replaceAll("\\s+",""),
                outContent.toString().replaceAll("\\s+",""));
    }
*/
}
