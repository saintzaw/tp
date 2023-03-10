package seedu.duke;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintTest {
    @Test
    public void printAddedModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        moduleList.addModule("CS2113T", "CORE");
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Got it. I've added this module:" + System.lineSeparator()
                + "       [C] CS2113T" + System.lineSeparator() + "     Now you have 1 modules in the list."
                + System.lineSeparator() + "    ____________________________________________________________"
                + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printFoundModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        moduleList.addModule("CS2113T", "CORE");
        System.setOut(new PrintStream(outContent));
        moduleList.findModule("CS2113T");
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Here are the matching modules in your list:" + System.lineSeparator()
                + "       [C] CS2113T" + System.lineSeparator()
                + "    ____________________________________________________________" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printDeletedModuleTest() {
        ModuleList moduleList = new ModuleList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        moduleList.addModule("CS2113T", "CORE");
        System.setOut(new PrintStream(outContent));
        moduleList.deleteModule("CS2113T");
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Noted. I've removed this module:" + System.lineSeparator()
                + "       [C] CS2113T" + System.lineSeparator() + "     Now you have 0 modules in the list."
                + System.lineSeparator() + "    ____________________________________________________________"
                + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printModuleListTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "CORE");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        moduleList.viewModuleList();
        String expectedOutput = "    ____________________________________________________________"
                + System.lineSeparator() + "     Here are the modules in your list:" + System.lineSeparator()
                + "     1.[C] CS2113T" + System.lineSeparator() + "    ____________________________________________________________"
                + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
