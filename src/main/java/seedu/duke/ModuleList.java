package seedu.duke;
import java.util.ArrayList;
import java.util.logging.Level;

import static seedu.duke.Duke.LOGGER;

public class ModuleList {
    private static final int MODULE_TYPE_INDEX = 0;
    private static final int MODULE_GRADE_INDEX = 1;
    private static final int MODULE_CODE_INDEX = 2;
    private static final int MODULAR_CREDITS_INDEX = 3;
    private static final int MODULE_YEAR_INDEX = 4;
    private static final int MODULE_SEMESTER_INDEX = 5;

    private ArrayList<Module> listOfModules;

    public ModuleList() {
        this.listOfModules = new ArrayList<>();
    }

    public ModuleList(ArrayList<String> savedModules) {
        this.listOfModules = new ArrayList<>();
        LOGGER.log(Level.INFO, "Starting process to load previously saved modules");
        for (String line : savedModules) {
            addExistingModule(line);
        }
        LOGGER.log(Level.INFO, "Finished loading previously saved modules");
    }

    public ArrayList<Module> getModuleList() {
        return listOfModules;
    }

    public int getModuleListSize() {
        return listOfModules.size();
    }

    public void addModule(String moduleCode, String modularCredits,
                          String moduleType, String year, String semester) {
        int oldSizeOfList = listOfModules.size();
        LOGGER.log(Level.INFO, "Starting addModule process");
        switch (moduleType.toUpperCase()) {
        case "CORE":
            Core newCore = new Core(moduleCode, modularCredits, year, semester);
            listOfModules.add(newCore);
            Print.printAddedModule(newCore, listOfModules.size());
            break;
        case "GE":
            GeneralElective newGeneralElective = new GeneralElective(moduleCode, modularCredits, year, semester);
            listOfModules.add(newGeneralElective);
            Print.printAddedModule(newGeneralElective, listOfModules.size());
            break;
        case "UE":
            UnrestrictedElective newUnrestrictedElective =
                    new UnrestrictedElective(moduleCode, modularCredits, year, semester);
            listOfModules.add(newUnrestrictedElective);
            Print.printAddedModule(newUnrestrictedElective, listOfModules.size());
            break;
        case "INTERNSHIP":
            Internship newinternship = new Internship(moduleCode, modularCredits, year, semester);
            listOfModules.add(newinternship);
            Print.printAddedModule(newinternship, listOfModules.size());
            break;
        default:
            break;
        }
        assert listOfModules.size() == oldSizeOfList + 1 : "Module not added correctly";
        LOGGER.log(Level.INFO, "Finished addModule process");
    }

    public void findModuleByName(String keyword) throws DukeException {
        if (listOfModules.size() == 0) {
            throw new DukeException("There are currently no modules in your list");
        }
        assert listOfModules.size() > 0 : "no items in list";
        LOGGER.log(Level.INFO, "Starting findModuleByName process");
        boolean isFound = false;
        ArrayList<Module> foundModules = new ArrayList<>();
        for (Module module : listOfModules) {
            if (module.getModuleCode().contains(keyword)) {
                isFound = true;
                foundModules.add(module);
            }
        }
        if (isFound) {
            LOGGER.log(Level.INFO, "Finished findModule process with matching module found");
            Print.printFoundModule(foundModules);
        } else {
            Print.printNoModuleFound(keyword);
            LOGGER.log(Level.INFO, "Finished findModule process with no matching module found");
        }
    }

    public void findModuleByType(String keyword) throws DukeException {
        if (listOfModules.size() == 0) {
            throw new DukeException("There are currently no modules in your list");
        }
        assert listOfModules.size() > 0 : "no items in list";
        LOGGER.log(Level.INFO, "Starting findModuleByType process");
        boolean isFound = false;
        ArrayList<Module> foundModules = new ArrayList<>();
        switch (keyword) {
        case "CORE":
            for (Module module : listOfModules) {
                if (module instanceof Core) {
                    isFound = true;
                    foundModules.add(module);
                }
            }
            break;
        case "GE":
            for (Module module : listOfModules) {
                if (module instanceof GeneralElective) {
                    isFound = true;
                    foundModules.add(module);
                }
            }
            break;
        case "UE":
            for (Module module : listOfModules) {
                if (module instanceof UnrestrictedElective) {
                    isFound = true;
                    foundModules.add(module);
                }
            }
            break;
        case "Internship":
            for (Module module : listOfModules) {
                if (module instanceof Internship) {
                    isFound = true;
                    foundModules.add(module);
                }
            }
            break;
        default:
            throw new DukeException("Make sure your types are CORE,GE,UE or Internship");
        }

        if (isFound) {
            LOGGER.log(Level.INFO, "Finished findModule process with matching module found");
            Print.printFoundModule(foundModules);
        } else {
            Print.printNoModuleFound(keyword);
            LOGGER.log(Level.INFO, "Finished findModule process with no matching module found");
        }
    }

    public void deleteModule(String moduleCode) throws DukeException {
        if (listOfModules.size() == 0) {
            throw new DukeException("There are currently no modules in your list");
        }
        assert listOfModules.size() > 0 : "no items in list";
        LOGGER.log(Level.INFO, "Starting deleteModule process");
        boolean isFound = false;
        int oldSizeOfList = listOfModules.size();
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                Module deletedModule = listOfModules.get(i);
                listOfModules.remove(i);
                Print.printDeletedModule(deletedModule, listOfModules.size());
                isFound = true;
                break;
            }
        }

        if (!isFound) { // When no module matches the given module code
            Print.printNoDeletedModuleFound(moduleCode);
            assert listOfModules.size() == oldSizeOfList : "Wrong module was deleted";
            LOGGER.log(Level.INFO, "Finished deleteModule process with no module deleted");
        } else { // When a matching module is found and successfully deleted
            assert listOfModules.size() == oldSizeOfList - 1 : "Module not deleted correctly";
            LOGGER.log(Level.INFO, "Finished deleteModule process with module successfully deleted");
        }
    }

    public void listModules() {
        LOGGER.log(Level.INFO, "Starting listModules process");
        if (getModuleListSize() > 0) {
            Print.printModuleList(listOfModules);
        } else {
            Print.printEmptyModuleList();
        }
        LOGGER.log(Level.INFO, "Finished listModules process");
    }



    public void editModularCredits(String moduleCode, String newModularCredits) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.editModularCredits(newModularCredits);
                Print.printEditedModule(module, listOfModules.size());
            }
        }
    }

    public void editYear(String moduleCode, String newYear) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.editYear(newYear);
                Print.printEditedModule(module, listOfModules.size());
            }
        }
    }

    public void editSemester(String moduleCode, String newSemester) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.editSemester(newSemester);
                Print.printEditedModule(module, listOfModules.size());
            }
        }
    }

    public void editModuleType(String moduleCode, String modularCredits,
                               String moduleType, String year, String semester, String grade) {
        //delete module with old moduleType
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                listOfModules.remove(i);
                break;
            }
        }
        //add module with new moduleType
        switch (moduleType.toUpperCase()) {
        case "CORE":
            Core newCore = new Core(moduleCode, modularCredits, year, semester);
            newCore.setGrade(grade);
            listOfModules.add(newCore);
            Print.printEditedModule(newCore, listOfModules.size());
            break;
        case "GE":
            GeneralElective newGeneralElective = new GeneralElective(moduleCode, modularCredits, year, semester);
            newGeneralElective.setGrade(grade);
            listOfModules.add(newGeneralElective);
            Print.printEditedModule(newGeneralElective, listOfModules.size());
            break;
        case "UE":
            UnrestrictedElective newUnrestrictedElective =
                    new UnrestrictedElective(moduleCode, modularCredits, year, semester);
            newUnrestrictedElective.setGrade(grade);
            listOfModules.add(newUnrestrictedElective);
            Print.printEditedModule(newUnrestrictedElective, listOfModules.size());
            break;
        case "INTERNSHIP":
            Internship newinternship = new Internship(moduleCode, modularCredits, year, semester);
            newinternship.setGrade(grade);
            listOfModules.add(newinternship);
            Print.printEditedModule(newinternship, listOfModules.size());
            break;
        default:
            break;
        }
    }

    public String getModularCredits(String moduleCode) {
        String modularCredits = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                modularCredits = module.getModularCredits();
            }
        }
        return modularCredits;
    }

    public String getModuleYear(String moduleCode) {
        String moduleYear = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                moduleYear = module.getYear();
            }
        }
        return moduleYear;
    }

    public String getModuleSemester(String moduleCode) {
        String moduleSemester = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                moduleSemester = module.getSemester();
            }
        }
        return moduleSemester;
    }

    public String getModuleGrade(String moduleCode) {
        String moduleGrade = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                moduleGrade = module.getGrade();
            }
        }
        return moduleGrade;
    }

    /**
     * Based on the existing saved modules, add these modules to listOfModules
     * @param line A string representation of a module, containing all its relevant information
     */
    public void addExistingModule(String line) {
        String[] moduleData = line.split("\\|");

        String moduleGrade = moduleData[MODULE_GRADE_INDEX];
        String moduleCode = moduleData[MODULE_CODE_INDEX];
        String modularCredits = moduleData[MODULAR_CREDITS_INDEX];
        String moduleYear = moduleData[MODULE_YEAR_INDEX];
        String moduleSemester = moduleData[MODULE_SEMESTER_INDEX];

        switch (moduleData[MODULE_TYPE_INDEX]) {
        case "C":
            Core coreModule = new Core(moduleCode, modularCredits, moduleYear, moduleSemester);
            coreModule.setGrade(moduleGrade);
            listOfModules.add(coreModule);
            break;
        case "GE":
            GeneralElective generalElectiveModule = new GeneralElective(moduleCode,
                    modularCredits, moduleYear, moduleSemester);
            generalElectiveModule.setGrade(moduleGrade);
            listOfModules.add(generalElectiveModule);
            break;
        case "UE":
            UnrestrictedElective unrestrictedElectiveModule =
                    new UnrestrictedElective(moduleCode, modularCredits, moduleYear, moduleSemester);
            unrestrictedElectiveModule.setGrade(moduleGrade);
            listOfModules.add(unrestrictedElectiveModule);
            break;
        case "I":
            Internship internshipModule = new Internship(moduleCode, modularCredits, moduleYear, moduleSemester);
            internshipModule.setGrade(moduleGrade);
            listOfModules.add(internshipModule);
            break;
        default:
            break;
        }

    }

    public void updateModuleGrade(String moduleCode, String moduleGrade) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.setGrade(moduleGrade);
                Print.printUpdatedModuleGrade(module);
                return;
            }
        }
        Print.printInvalidModule(moduleCode);
    }

    public void calculateCAP () {
        double calculatedCAP;
        double sumOfWeightage = 0;
        int totalModularCredits = 0;
        for (Module module : listOfModules) {
            if(shouldCountModuleGrade(module.getGrade())) {
                sumOfWeightage += getGradeValue(module.getGrade()) * Integer.parseInt(module.getModularCredits());
                totalModularCredits += Integer.parseInt(module.getModularCredits());
            }
        }
        calculatedCAP = sumOfWeightage/(double)totalModularCredits;
        double roundedOffCAP = Math.round(calculatedCAP*100.0)/100.0;
        Print.printCalculatedCAP(roundedOffCAP);
    }

    public boolean shouldCountModuleGrade(String moduleGrade) {
        boolean shouldCount;
        switch(moduleGrade) {
        case "A+":
        case "A":
        case "A-":
        case "B+":
        case "B":
        case "B-":
        case "C+":
        case "C":
        case "D+":
        case "D":
        case "F":
            shouldCount = true;
            break;
        default:
            shouldCount = false;
            break;
        }
        return shouldCount;
    }

    public double getGradeValue(String moduleGrade) {
        double gradeValue;
        switch(moduleGrade) {
        case "A+":
        case "A":
            gradeValue = 5.0;
            break;
        case "A-":
            gradeValue = 4.5;
            break;
        case "B+":
            gradeValue = 4.0;
            break;
        case "B":
            gradeValue = 3.5;
            break;
        case "B-":
            gradeValue = 3.0;
            break;
        case "C+":
            gradeValue = 2.5;
            break;
        case "C":
            gradeValue = 2.0;
            break;
        case "D+":
            gradeValue = 1.5;
            break;
        case "D":
            gradeValue = 1.0;
            break;
        case "F":
            gradeValue = 0.0;
            break;
        default:
            gradeValue = 0;
            break;
        }
        return gradeValue;
    }
}
