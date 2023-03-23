package seedu.duke;

public class Internship extends Module {

    /**
     * A module type called Internship
     * @param moduleCode The module code
     * @param modularCredits The module credits of the module stated
     * @param year The year the user wants the module to be placed in
     * @param semester The semester the user wants the module to be placed in
     */

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
