package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ModuleListTest {

    @Test
    public void deleteModuleTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        assertEquals(1, moduleList.getModuleList().size());
        try {
            moduleList.deleteModule("CS2113T");
        } catch (DukeException e) {
            return;
        }
        assertEquals(0, moduleList.getModuleList().size());
    }

    @Test
    public void addDifferentModuleTypeTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        assertEquals(1, moduleList.getModuleListSize());
        moduleList.addModule("GEA1000", "4", "GE", "1", "1");
        assertEquals(2, moduleList.getModuleListSize());
        moduleList.addModule("PC1201", "4", "UE", "1", "1");
        assertEquals(3, moduleList.getModuleListSize());
        moduleList.addModule("ATAP", "8", "INTERNSHIP", "1", "1");
        assertEquals(4,moduleList.getModuleListSize());
    }

    @Test
    public void addDifferentModuleCodeTest() {
        ModuleList moduleList = new ModuleList();
        Parser parser = new Parser();
        ArrayList<String> userInputs = new ArrayList<>();
        // expected
        userInputs.add("add /CS2113T /4 /CORE /1 /1");
        // case insensitive
        userInputs.add("add /iS4231 /4 /CorE /1 /1");
        // Space insensitive
        userInputs.add("add /     CS1010     / 4 /   CORE     /   1  /1              ");
        for (int i = 0; i < 3; i++) {
            try {
                parser.checkUserInput(userInputs.get(i), moduleList);
            } catch (DukeException e) {
                System.out.println(e);
            }
            assertEquals(i + 1, moduleList.getModuleListSize());
        }
    }

    @Test
    public void foundModuleByNameTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        ArrayList<Module> foundModules = new ArrayList<>();
        try {
            foundModules = moduleList.findModuleByName("CS2113T");
        } catch (DukeException e) {
            System.out.println(e);
        }
        assertEquals(1, foundModules.size());
    }

    @Test
    public void foundMultipleModuleByNameTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        moduleList.addModule("CS2101", "4", "CORE", "1", "1");
        ArrayList<Module> foundModules = new ArrayList<>();
        try {
            foundModules = moduleList.findModuleByName("CS");
        } catch (DukeException e) {
            System.out.println(e);
        }
        assertEquals(2, foundModules.size());
    }

    @Test
    public void foundNoModuleByNameTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("IS4231", "4", "CORE", "1", "1");
        ArrayList<Module> foundModules = new ArrayList<>();
        try {
            foundModules = moduleList.findModuleByName("CS");
        } catch (DukeException e) {
            System.out.println(e);
        }
        assertEquals(0, foundModules.size());
    }

    @Test
    public void foundModuleByTypeTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        ArrayList<Module> foundModules = new ArrayList<>();
        try {
            foundModules = moduleList.findModuleByType("CORE");
        } catch (DukeException e) {
            System.out.println(e);
        }
        assertEquals(1, foundModules.size());
    }

    @Test
    public void foundMultipleModuleByTypeTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        moduleList.addModule("CS2101", "4", "CORE", "1", "1");
        ArrayList<Module> foundModules = new ArrayList<>();
        try {
            foundModules = moduleList.findModuleByType("CORE");
        } catch (DukeException e) {
            System.out.println(e);
        }
        assertEquals(2, foundModules.size());
    }

    @Test
    public void foundNoModuleByTypeTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "4", "CORE", "1", "1");
        ArrayList<Module> foundModules = new ArrayList<>();
        try {
            foundModules = moduleList.findModuleByType("GE");
        } catch (DukeException e) {
            System.out.println(e);
        }
        assertEquals(0, foundModules.size());
    }
}
