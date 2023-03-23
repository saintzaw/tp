package seedu.duke;

public class GeneralElective extends Module {

    /**
     * Constructs a GeneralElective object that inherits from Module object.
     *
     * @param moduleCode the string containing the name of the module code.
     * @param modularCredits the string containing the number of modular credits given upon completion of the module.
     * @param year the string containing the year that the user plans to take this module.
     * @param semester the string containing the semester that the user plans to take this module.
     */
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
