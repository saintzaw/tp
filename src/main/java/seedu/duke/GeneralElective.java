package seedu.duke;

public class GeneralElective extends Module {

    public GeneralElective (String moduleCode) {
        super(moduleCode);
    }

    @Override
    public String toString() {
        return "[GE] " + super.toString();
    }
}
