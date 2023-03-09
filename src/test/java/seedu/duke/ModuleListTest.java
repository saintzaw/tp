package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ModuleListTest {
    @Test
    public void deleteModuleTest() {
        ModuleList moduleList = new ModuleList();
        moduleList.addModule("CS2113T", "CORE");
        assertEquals(1, moduleList.getModuleList().size());
        moduleList.deleteModule("CS2113T");
        assertEquals(0, moduleList.getModuleList().size());
    }

}
