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

    public void addModule(String moduleCode, String modularCredits, String moduleType) {
        int oldSizeOfList = listOfModules.size();
        switch(moduleType) {
        case "CORE":
            Core newCore = new Core(moduleCode, modularCredits);
            listOfModules.add(newCore);
            Print.printAddedModule(newCore, listOfModules.size());
            break;
        case "GE":
            GeneralElective newGeneralElective = new GeneralElective(moduleCode, modularCredits);
            listOfModules.add(newGeneralElective);
            Print.printAddedModule(newGeneralElective, listOfModules.size());
            break;
        case "UE":
            UnrestrictedElective newUnrestrictedElective = new UnrestrictedElective(moduleCode, modularCredits);
            listOfModules.add(newUnrestrictedElective);
            Print.printAddedModule(newUnrestrictedElective, listOfModules.size());
            break;
        default:
            break;
        }
        assert listOfModules.size() == oldSizeOfList + 1 : "Module not added correctly";
    }

    public void findModule(String moduleCode) {
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                assert listOfModules.size() > 0 : "no items in list";
                Module foundModule = listOfModules.get(i);
                Print.printFoundModule(foundModule);
                return;
            }
        }
        Print.printNoModuleFound();
    }

    public void deleteModule(String moduleCode) {
        assert listOfModules.size() > 0 : "no items in list";
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                Module deletedModule = listOfModules.get(i);
                listOfModules.remove(i);
                Print.printDeletedModule(deletedModule, listOfModules.size());
                break;
            }
        }
    }

    public void viewModuleList() {
        Print.printModuleList(listOfModules);
    }
}
