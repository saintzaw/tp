package seedu.duke;
import java.util.ArrayList;

public class ModuleList {
    private ArrayList<Module> listOfModules;
    public ModuleList (ArrayList<Module> listOfModules) {
        this.listOfModules = listOfModules;
    }
    public ArrayList<Module> getModuleList () {
        return listOfModules;
    }
}
