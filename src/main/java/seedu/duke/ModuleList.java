package seedu.duke;
import java.util.ArrayList;

public class ModuleList {
    private ArrayList<Module> listOfModules;
    public ModuleList() {
        this.listOfModules = new ArrayList<>();
    }
    public ArrayList<Module> getModuleList() {
        return listOfModules;
    }

    public void findModule(String moduleCode) {
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                Module foundModule = listOfModules.get(i);
                Print.printFoundModule(foundModule);
                break;
            }
        }
    }

    public void deleteModule(String moduleCode) {
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                Module deletedModule = listOfModules.get(i);
                listOfModules.remove(i);
                Print.printDeletedModule(deletedModule, listOfModules.size());
                break;
            }
        }
    }


}
