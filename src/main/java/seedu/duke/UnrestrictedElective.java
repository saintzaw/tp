package seedu.duke;

public class UnrestrictedElective extends Module {

    public UnrestrictedElective(String moduleCode, String modularCredits) {
        super(moduleCode, modularCredits);
    }

    public UnrestrictedElective(String moduleCode, String modularCredits, String year, String semester) {
        super(moduleCode, modularCredits, year, semester);
    }

    @Override
    public String toString() {
        return "[UE] " + super.toString();
    }
}
