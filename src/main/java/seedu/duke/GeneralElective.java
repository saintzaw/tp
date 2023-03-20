package seedu.duke;

public class GeneralElective extends Module {

    public GeneralElective(String moduleCode, String modularCredits) {
        super(moduleCode, modularCredits);
    }

    public GeneralElective(String moduleCode, String modularCredits, String year, String semester) {
        super(moduleCode, modularCredits, year, semester);
    }

    @Override
    public String getModuleType() {
        return "GE";
    }

    @Override
    public String toString() {
        return "[GE]" + super.toString();
    }
}
