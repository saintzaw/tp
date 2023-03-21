package seedu.duke;

public class Module {
    private String moduleCode;
    private String modularCredits;
    private String year;
    private String semester;
    private String grade;

    public Module(String moduleCode, String modularCredits) {
        this.moduleCode = moduleCode;
        this.modularCredits = modularCredits;
        this.grade = " ";
    }
    public Module (String moduleCode, String modularCredits, String year, String semester) {
        this.moduleCode = moduleCode;
        this.modularCredits = modularCredits;
        this.year = year;
        this.semester = semester;
        this.grade = " ";
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModularCredits() {
        return modularCredits;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getModuleType() {
        return "";
    }

    public void editModularCredits(String newModularCredits) {
        this.modularCredits = newModularCredits;
    }

    public void editSemester(String newSemester) {
        this.semester = newSemester;
    }

    public void editYear(String newYear) {
        this.year = newYear;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[\"" + this.grade + "\"] " + this.moduleCode + " " + this.modularCredits + " MCs"
                + " (Year: " + this.year + ", Sem: " + this.semester + ")";
    }
}
