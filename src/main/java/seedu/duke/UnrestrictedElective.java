package seedu.duke;

public class UnrestrictedElective extends Module {

    public UnrestrictedElective (String moduleCode) {
        super(moduleCode);
    }

    @Override
    public String toString() {
        return "[UE] " + super.toString();
    }
}
