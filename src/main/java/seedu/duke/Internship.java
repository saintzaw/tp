package seedu.duke;

public class Internship extends Module {
    public Internship(String moduleCode, String modularCredits) {
        super(moduleCode, modularCredits);
    }

    public Internship(String moduleCode, String modularCredits, String year, String semester) {
        super(moduleCode, modularCredits, year, semester);
    }

    @Override
    public String toString() {
        return "[I] " + super.toString();
    }
}
