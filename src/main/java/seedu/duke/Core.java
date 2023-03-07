package seedu.duke;

public class Core extends Module{

    public Core (String moduleCode) {
        super(moduleCode);
    }

    @Override
    public String toString() {
        return "[C] " + super.toString();
    }
}
