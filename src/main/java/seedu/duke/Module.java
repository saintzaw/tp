package seedu.duke;

public class Module {
    private String moduleCode;
    private String modularCredits;
    private String year;
    private String semester;

    public Module(String moduleCode, String modularCredits) {
        this.moduleCode = moduleCode;
        this.modularCredits = modularCredits;
    }
    public Module (String moduleCode, String modularCredits, String year, String semester) {
        this.moduleCode = moduleCode;
        this.modularCredits = modularCredits;
        this.year = year;
        this.semester = semester;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return this.moduleCode + " " + this.modularCredits + " MCs";
    }
}
