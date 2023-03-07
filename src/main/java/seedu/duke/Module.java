package seedu.duke;

public class Module {
    private String moduleCode;
    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    @Override
    public String toString() {
        return this.moduleCode;
    }
}
