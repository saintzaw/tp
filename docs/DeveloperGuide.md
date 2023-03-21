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




## Product scope
### Target user profile

Our target user profile is Information Security students in NUS.

### Value proposition

Modganiser is effortless module planning, at your fingertips via the
Command Line Interface (CLI). It helps Information security 
students graduate in time by giving you a platform to plan all 4 years
of your modules to ensure that you meet graduation requirements (UE/GEs).
If you can type fast, Modganiser can get your schedule up  faster than
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
