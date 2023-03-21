# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Proposed Implementation : **Manpage**

The Manpage is a class that is used to display parts of the manpage that is requested by the user.
It has multiple methods for separate features.

`Manpage#printManPage()` - Prints the Command Summary.

`Manpage#printManPageAdd()` - Prints description of how to use the add feature.

`Manpage#printManPageList()` - Prints description of how to use the list feature.

`Manpage#printManPageEdit()` - Prints description of how to use the edit feature.

`Manpage#printManPageFind()` - Prints description of how to use the find feature.

`Manpage#printManPageDelete()` - Prints description of how to use the delete feature.

`Manpage#printManPageCalculator()` - Prints description of how to use the grade calculator.

`Manpage#printManPageCalculatorInput()` - Prints description of how to input grades.

`Manpage#printManPageExit()` - Prints description of how to use the exit feature.

### Design Considerations : **Manpage**

**Alternative 1** : Prints the manual page individually as features. 
Pros: Avoids wordy and long manual page when command is man, ability to have more description
for specific features. Avoids long methods. 
Cons: Extra step of typing another command to understand a feature well.

**Alternative 2**: Combining all feature descriptions in a single manual page. 
Pros: Avoid extra step of typing another command to understand a feature well.
Cons: Wordy and long manual page when command is man, user has to scroll through
a long manual page to find what they need. Long method.

### Implementation: **Parser**

The `Parser` is a class that handles the commands keyed in by the user.  
It has multiple checks to ensure that the user keys in valid commands. 

<!---elaborate more on the class, still unsure of the format...--->
<!---insert other commands here, still unsure of the format...(should it all be under Parser class or separate?)--->


`grade` command:

The `grade` command is used by the user to update the grade of modules that have already been completed.  

The sequence by which the Parser class handles the `grade` command is as follows:  
1) The `Parser` class extracts the other fields of the user input, and calls upon the `updateModuleGrade()` method
in the `ModuleList` class.  
2) The method then loops through the moduleList array to find the moduleCode that requires a grade update. 
3) If the module is found, it calls the `Module` object method `setGrade()` to update the grade field
and prints a success message by calling the `printUpdatedModuleGrade()` method of the `Print` class.
4) Else, it prints an error message by calling the `printInvalidModule()` method of the `Print` class.  

The sequence of events above can be represented with the following sequence diagram:

![gradeCommand](diagrams/GradeCommand.png)

<small><i>Figure ???</i></small>

`calculateCAP` command:

The `calculateCAP` command is used by the user to calculate the Cumulative Average Point (CAP) of graded modules.

The sequence by which the Parser class handles the `calculateCAP` command is as follows:
1) The `Parser` class extracts the other fields of the user input, and calls upon the `calculateCAP()` method
   in the `ModuleList` class.
2) The method then loops through the moduleList array to find modules that have been graded.
3) It checks if the module grade should be counted by self-invocation of the `shouldCountModule()` method
4) If it is, proceeds to obtain the grade value by self-invocation of the `getGradeValue()` method.
5) Calculates the required grade values, and finally calls the `printCalculatedCAP()` of the `Print` class to display
the result to the user

The sequence of events above can be represented with the following sequence diagram:

![calculateCAP](diagrams/calculateCAP.png)

<small><i>Figure ???</i></small>

`add` command:

The `add` command is used by the user to add a module or multiple modules at once.

The sequence by which the Parser class handles the `add` command is as follows:
1) The `Parser` class extracts the necessary fields from the user input, and calls upon the `addModule`
   method in the `ModuleList` class in a loop.
2) The method then checks the type of module that is being added, then calls the relevant 
   constructor (`Core`, `UE`, `GE`, `Internship`).
3) The `addModule` method returns the module that is added to the `Parser` class.
4) The `getModuleListSize` method is called from `ModuleList` class.
5) The `printAddedModule` method is called from the `Print` class to display the result to the user.

The sequence of events above can be represented with the following sequence diagram:

![addInputCommand](diagrams/AddInputCommand.png)

<small><i>Figure ???</i></small>

`edit` command:

The `edit` command is used by the user to make changes to fields in the module description.

The sequence in which the `Parser` class handles the `edit` command is as follows:
1) The `Parser` class extracts the other fields of the user input, and calls upon the `editModuleField()` method
   by self-invocation. 
2) The method then uses a `switch` statement to evaluate the module field that the user wants to update.
3) After checking the field to be updated, the appropriate method within the `ModuleList` class is called upon to
   make the changes specified by the user.
4) If the user wants to update Modular Credits, the `editModularCredits()` method is called. 
   This method directly modifies the `modularCredits` attribute of the `Module` object.
5) If the user wants to update Module Type, the `editModuleType()` method is called.
   This method removes the existing `Module` object and adds a new `Module` object of the new type specified
   by the user. The `getModuleCode()`, `getModularCredits()`, `getYear()`, `getSemester()` and `getGrade()`
   methods in the `Module` class are also called upon to obtain the respective fields required to create the new
   `Module` object. 
6) If the user wants to update the Year, the `editYear()` method is called.
   This method directly modifies the `year` attribute of the `Module` object.
7) If the user wants to update the Semester, the `editSemester()` method is called.
   This method directly modifies the `semester` attribute of the `Module` object.

![editCommand](diagrams/editCommand.png)

## Product scope
### Target user profile

Our target user profile is Information Security students in NUS.

### Value proposition

Modganiser is effortless module planning, at your fingertips via the
Command Line Interface (CLI). It helps Information security 
students graduate in time by giving you a platform to plan all 4 years
of your modules to ensure that you meet graduation requirements (UE/GEs).
If you can type fast, Modganiser can get your schedule up faster than
traditional GUI apps.


## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java 11 or above installed.
2. Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands)
should be able to accomplish most of the tasks faster using commands than using the mouse.

## Glossary

Mainstream OS: Windows, Linux, Unix, OS-X

## Instructions for manual testing
