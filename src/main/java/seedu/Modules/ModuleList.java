package seedu.modules;
import java.util.ArrayList;

public class ModuleList {
    private ArrayList<Module> listOfModules;
    public ModuleList(ArrayList<Module> listOfModules) {
        this.listOfModules = listOfModules;
    }
    public ArrayList<Module> getModuleList () {
        return listOfModules;
    }

    public void findModule(String moduleCode) {
        for (int i = 0; i < listOfModules.size(); i ++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                //Print.printFoundModuleMessage();
                break;
            }
        }
    }
}
