package seedu.duke;

public class Internship extends Module {

    public Internship(String moduleCode, String modularCredits, String year, String semester) {
        super(moduleCode, modularCredits, year, semester);
    }

    @Override
    public String getModuleType() {
        return "I";
    }

    @Override
    public String toString() {
        return "[I]" + super.toString();
    }
}
