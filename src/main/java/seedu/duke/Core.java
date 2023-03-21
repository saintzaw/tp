package seedu.duke;

public class Core extends Module {

    public Core(String moduleCode, String modularCredits, String year, String semester) {
        super(moduleCode, modularCredits, year, semester);
    }

    @Override
    public String getModuleType() {
        return "C";
    }

    @Override
    public String toString() {
        return "[C]" + super.toString();
    }
}
