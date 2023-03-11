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

    }

    public void findModule(String moduleCode) {
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                Module foundModule = listOfModules.get(i);
                Print.printFoundModule(foundModule);
                break;
            }
        }
        Print.printNoModuleFound();
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

    public void viewModuleList() {
        Print.printModuleList(listOfModules);
    }
}
