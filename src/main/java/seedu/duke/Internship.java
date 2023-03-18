package seedu.duke;

public class Internship extends Module{
    public Internship (String moduleCode, String modularCredits) {
        super(moduleCode, modularCredits);
    }

    @Override
    public String toString() {
        return "[I] " + super.toString();
    }
}
