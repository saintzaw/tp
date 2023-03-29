# Modganiser User Guide

## Table of Contents

---

1. [Acknowledgements](#1-acknowledgements)
2. [Introduction](#2-introduction)
   + 2.1 [What Is Modganiser](#21-what-is-modganiser)
   + 2.2 [Who Is This User Guide Meant For?](#22-who-is-this-user-guide-meant-for)
   + 2.3 [How To Use This User Guide](#23-how-to-use-this-user-guide)
3. [Command Line Interface Tutorial](#3-command-line-interface-tutorial)
4. [Set Up Guide](#4-set-up-guide)
5. [Features](#5-features)
   + 5.1 [Notes On The Command Format](#51-notes-on-the-command-format)
   + 5.2 [Summary Of Features](#52-summary-of-features)
   + 5.3 [Managing Modules](#53-managing-modules)
     - 5.3.1 [Adding Modules: add](#531-adding-modules-add)
     - 5.3.2 [Adding Grade Obtained for Module: grade](#532-adding-grade-obtained-for-module-grade)
     - 5.3.3 [Editing Module Details: edit](#533-editing-module-details-edit)
     - 5.3.4 [Deleting Module From Module Plan: delete](#534-deleting-module-from-module-plan-delete)
   + 5.4 [Managing Display of Module Plan](#54-managing-display-of-module-plan)
     - 5.4.1 [Viewing Module Plan: list](#541-viewing-module-plan-list)
     - 5.4.2 [Finding Modules In The Module Plan: find](#542-finding-modules-in-the-module-plan-find)
   + 5.5 [Tracking Graduation Progress](#55-tracking-graduation-progress)
     - 5.5.1 [Tracking the Completion of Each Module Type: track](#551-tracking-the-completion-of-each-module-type-track)
     - 5.5.2 [Calculating Your Current CAP: calculatecap](#552-calculating-your-current-cap-calculatecap)
   + 5.6 [Miscellaneous](#56-miscellaneous)
     - 5.6.1 [Viewing the Entire Manual: man](#561-viewing-the-entire-manual-man)
     - 5.6.2 [Viewing the Detailed Manual Page for A Single Feature: man /FEATURE](#562-viewing-the-detailed-manual-page-for-a-single-feature-man-feature)
     - 5.6.3 [Exiting Modganiser: bye](#563-exiting-modganiser-bye)
     - 5.6.4 [Saving Module Plan](#564-saving-module-plan)
6. [FAQ](#6-faq)
7. [Command Summary](#7-command-summary)
8. [Glossary](#8-glossary)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

## 1. Acknowledgements

---

We would like to thank you for choosing Modganiser to help you with your module planning.
Modganiser will be sure to make this arduous task a breeze while ensuring you meet all your graduation requirements,
so that you can focus on the other aspects of university that really matter.
Should you have any feedback or enquiries, please do not hesitate to [reach out to us](https://github.com/AY2223S2-CS2113T-T09-4/tp)!

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

## 2. Introduction

---

### 2.1 What is Modganiser?
Modganiser is effortless module planning, at your fingertips via the [Command Line Interface (CLI)](#8-glossary),
focused on helping Information Security Undergraduates graduate in 4 years. It does so by giving you a platform to
plan all 4 years of your modules to ensure that you meet your [graduation requirements](https://www.comp.nus.edu.sg/cugresource/per-cohort/isc/isc-21-22/).
If you can type fast, Modganiser can get your schedule up faster than traditional GUI apps.

### 2.2 Who Is This User Guide Meant For?
Are you a current information security undergraduate at NUS? Or are you a prospective student,
about to begin your journey into information security? Well, Modganiser is exactly what you are looking for!
This user guide will help you as you navigate through Modganiser and its features. If you are a new user, do go to the
[set-up section](#4-set-up-guide) to learn how to install and run Modganiser. To learn more about Modganiser’s features, do head over to
the [features section](#5-features)!

### 2.3 How To Use This User Guide
Modganiser uses a [Command Line Interface (CLI)](#8-glossary) which may be new to some users. We strongly recommend that you read this
User Guide from start to finish if you are new to Modganiser, although you may choose to skip to more relevant sections
if you are used to Java, CLI or Modganiser, which are described below:
* Refer to our [Table of Contents](#table-of-contents) to navigate between the different sections
* Refer to our [Command Line Interface (CLI) tutorial](#3-command-line-interface-tutorial) to learn how to use CLI
* Refer to our [Set-Up Guide](#4-set-up-guide) to learn how to install Modganiser
* Refer to our [Features](#5-features) to learn more about Modganiser’s functions
* Refer to our [FAQ](#6-faq) for answers to frequently asked questions
* Refer to our [Command Summary](#7-command-summary) to get an overview of the different commands available in Modganiser and their formats
* Refer to our [Glossary](#8-glossary) to learn more about the key terms in this User Guide

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

## 3. Command Line Interface Tutorial

---

To open up the [Command Line Interface (CLI)](#8-glossary)
* For Windows
    * Click on the Windows button and search for “Command Prompt”.
* For macOS
    * Press on the command and spacebar button together and search for “Terminal”
* The window that comes up is the CLI on your computer. We will be using this interface to run Modganiser.
* To run commands in the CLI, just type the command out, press enter and the command will run

![WindowsCLI](UG_Screenshots/Windows_cmd_prompt.PNG)
<p style = "text-align:center"><small>Windows version of CLI with a command typed out</small></p>

![macOSCLI](UG_Screenshots/Terminal.png)

<p style = "text-align:center"><small>macOS version of CLI with a command typed out</small></p>

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

## 4. Set-Up Guide

---

To set up Modganiser, please follow the steps below:
1. Download Java from the Java Developer Webpage
    * For Windows, please click [here](https://www.oracle.com/java/technologies/downloads/#jdk20-windows) and choose the x64 installer.
    * For macOS, Please click [here](https://www.oracle.com/java/technologies/downloads/#jdk20-mac) and choose the Arm 64 DMG Installer.
2. Please click [here](https://github.com/AY2223S2-CS2113T-T09-4/tp/releases) and download the tp.jar file, which contains Modganiser.
3. Save the file into a new folder on your Desktop and title the folder “Modganiser”
4. Open the CLI interface on your device. If you are unsure of how to do so, please refer to our [CLI tutorial](#3-command-line-interface-tutorial).
    * Type “cd Desktop” and press enter
    * Type “cd Modganiser” and press enter
    * Type “java -jar tp.jar” and press enter
5. If successful, you should see the following displayed on your screen:

    ![Modganiser Starting](UG_Screenshots/Modganiser_Start_Up.png)
    
6. Type your name in and press enter. If successful, you should see the following:
    
    ![Modganiser accepts Name](UG_Screenshots/Name_Entered.png)
    
7. Modganiser is now ready to run. You can type commands at the bottom after the horizontal line

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

## 5. Features

---

Before we begin with the features, here are some special notations that we will be using. Please familiarize yourself with these notations as it will enhance your experience with the user guide.

**Tips**

Tips are useful suggestions that will help you have a better experience with Modganiser

> 💡 **Tip**: Tips are useful

**Notes**

Notes are important information that you should pay attention to when using Modganiser

> 📓 **Note**: Notes are important, take them down

**Warnings**

Warnings are to warn you of potential pitfalls that new users may encounter. For example: commands like `delete /MODULE_CODE`  deletes the module from your plan and the action is irreversible.

> ❗ **Warning**: Read this section carefully when you see it

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.1 Notes on the Command Format

> 📓 **Note**  
> 1. Markdown Texts
>   - Markdown texts are texts that look like `this`, which indicates that these are user inputs
> 2. Command Words
>   - Command words are used to invoke the various features of Modganiser. 
>   You may refer to the [summary of features](#52-summary-of-features) here. 
>   - Command words are not case-sensitive
>   - Example: `BYE` will be accepted as the `bye` command
> 3. Parameters
>   - Words in UPPER_CASE refers to the [parameters](#8-glossary) of the command.
>   - All inputs for the [parameters](#8-glossary) should come with a slash “/” before it to indicate 
>    that it is a user input and not the Command Word.
>   - Inputs from you are not case-sensitive. All inputs will be converted to uppercase before 
    they are executed. Therefore, inputs to [parameters](#8-glossary) like `/cs2113t` will be treated as `/CS2113T` by 
    default. For example, `find /CODE /Cs2113t` will be treated as `FIND /CODE /CS2113T` by Modganiser
>   - You should provide as many inputs as there are [parameter](#8-glossary) fields for the command. 
    Missing or Additional Inputs will trigger an error by Modganiser
> 4. Errors and Warnings
>    - If you are receiving an error or warning, do check that you do not have missing or 
    additional inputs and that your inputs are in the list of accepted input
> 
> ![ErrorMissingFields](UG_Screenshots/Error_Missing_Fields.png)
> 
> ![ErrorTooManyFields](UG_Screenshots/Error_Too_Many_Fields.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.2 Summary Of Features
Below is a summary of features that Modganiser has. Type the corresponding command in the [Command Line Interface](#8-glossary) and press Enter to execute it.
* [Adding a module:](#531-adding-modules-add)  `add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE /YEAR /SEM`
* [Input grade for module:](#532-adding-grade-obtained-for-module-grade) `grade /MODULE_CODE /GRADE`
* [Editing a module:](#533-editing-module-details-edit) `edit /MODULE_CODE /FIELD_TO_EDIT /NEW_INFO`
* [Deleting a module from the list:](#534-deleting-module-from-module-plan-delete) `delete /MODULE_CODE`
* [Listing modules by year:](#541-viewing-module-plan-list) `list /YEAR`
* [Locating module by code or type:](#542-finding-modules-in-the-module-plan-find) `find /TYPE_OF_SEARCH /KEYWORD`
* [Track Module Type Completion:](#551-tracking-the-completion-of-each-module-type-track) `track /MODULE_TYPE`
* [Grade Calculator:](#552-calculating-your-current-cap-calculatecap) `calculatecap`
* [Viewing manual:](#561-viewing-the-entire-manual-man) `man`
* [Viewing a specific manual for a feature:](#562-viewing-the-detailed-manual-page-for-a-single-feature-man-feature) `man /FEATURE`
* [Exiting the program:](#563-exiting-modganiser-bye) `bye`
<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.3 Managing Modules

#### 5.3.1 Adding Modules: `add`

**Function**

Adds a module to the module plan with the following [parameters](#8-glossary).

| [Parameter](#8-glossary) | Description                                                           | Accepted Inputs                         |
|--------------------------|-----------------------------------------------------------------------|-----------------------------------------|
| MODULE_CODE              | Please refer to [NUSMods](https://nusmods.com) for the Module's Code  | All inputs will be accepted             |
| MODULAR_CREDITS          | The number of modular credits the module is worth                     | 1, 2, 3, 4, 5, 6, 8, 12                 |
| MODULE_TYPE              | Which category the module falls under                                 | [CORE, GE, UE, INTERNSHIP](#8-glossary) |
| YEAR                     | Which year you plan to take the module                                | 1, 2, 3, 4                              |
| SEMESTER                 | Which semester you plan to take the module                            | 1, 1.5, 2, 2.5                          |

> 📓 **Note**
> 
> [CORE](#8-glossary) refers to modules that do not fall under the other 3 categories.

> 📓 **Note**
>
> 1.5 and 2.5 in SEMESTER refer to winter and summer break respectively.

>❗ **Warning**
>
> We do not check for the validity of the module code as we cannot maintain a database of modules. Please double-check the module code on NUSMods before entering it into Modganiser. If you have entered the wrong MODULE_CODE, you may edit it using the [edit command](#533-editing-module-details-edit).

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

**Command Format**

`add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE /YEAR /SEMESTER`

Example: `add /CS2113T /4 /CORE /1 /1`. Adds CS2113T that is worth 4 Modular Credits(MCs) and is a [Core module](#8-glossary) into Year 1 Semester 1.

![AddCommand](UG_Screenshots/AddingAModule.png)

> 📓 **Note**
> 
> The C represents [Core Module](#8-glossary). [GE](#8-glossary), [UE](#8-glossary) and [Internship](#8-glossary) Modules are represented with “GE”, “UE” and “I” respectively.

>❗ **Warning**
> 
> Missing inputs for the various [parameters](#8-glossary) or having too many inputs for the [parameters](#8-glossary) will cause Modganiser to throw you a warning.
> 
> e.g. `add /CS2113T /4 /1 /1` or `add /CS2113T /4 /CORE /1 /1 /1`

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

> 💡 **Tip**
> 
> Multiple modules can be added in a single line. 
> 
> For example: `add /CS2113T IS4231 CS3235 /4 /CORE /2 /2` will add CS2113T, IS4231 and CS3235 into the module plan. All 3 modules will be reflected as [Core](#8-glossary) modules worth 4 MCs, and will be taken in Year 2 Semester 2.
> ![AddCommand](UG_Screenshots/AddingMultipleModules.png)

>❗ **Warning**
> 
> Adding multiple modules should only be used if all the modules have the same inputs for the other [parameters](#8-glossary). Example, SIP3200 and CS2113T should not be added together in a single line as SIP3200 is worth 6 modular credits while CS2113T is worth 4 modular credits.

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

#### 5.3.2 Adding Grade Obtained for Module: `grade`
**Function**

Input the grade you got for the module once you have taken it in the planned semester.  
This grade will then be used to [calculate your CAP](#552-calculating-your-current-cap-calculatecap) with the `calculatecap` command.

|   [Parameter](#8-glossary)    |                          Description                           |                                                                Accepted Inputs                                                                |
|:--------------:|:--------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:|
| MODULE_CODE |    The module's code    |                                                                  All inputs will be accepted                                                                   |
|    GRADE     |                   The grade you obtained for the module                    | A+, A, B+, B, B-, C+, C, C-, D+, D, F, S, U, CS, CU |

**Command Format**

`grade /MODULE_CODE /GRADE`

Example: `grade /CS2113T /A` adds grade “A” to CS2113T

![GradeCommand](UG_Screenshots/InputGrade.png)


> 📓 **Note** 
>
> The grades for modules will be empty initially and will have a blank 2nd square bracket [“ ”] which needs to be updated via this command.


>❗ **Warning** 
> 
> Modganiser will show an error if you add grades to a module that doesn't exist.
![GradeCommand](UG_Screenshots/Grade_Module_Not_In_List.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

#### 5.3.3 Editing Module Details: `edit`

### Edit command: `edit`

**Function**

Edits the various details of an existing module

|   [Parameter](#8-glossary) |                                              Description                                               |                                                                         Accepted Inputs                                                                         |
|:--------------------------:|:------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|        MODULE_CODE         |                                           The module's code                                            |                                                                   All inputs will be accepted                                                                   |
|       FIELD_TO_EDIT        |                    The [parameter](#8-glossary) of the module that you wish to edit                    |                                                              CODE, MC, TYPE, YEAR, SEMESTER, GRADE                                                              |
|          NEW_INFO          | The new information to replace the incorrect or outdated information for that [parameter](#8-glossary) | Accepted inputs will be based on the field to edit. Please refer to the accepted inputs for the respective fields in the [add command](#531-adding-module-add). |

> 📓 Note 
> 
> * CODE represents MODULE_CODE 
> * MC represents MODULAR_CREDITS
> * TYPE represents MODULE_TYPE

**Command Format** 

`edit /MODULE_CODE /FIELD_TO_EDIT /NEW_INFO`

Example: `edit /CS2113T /TYPE /UE` edits the [Module Type](#8-glossary) of CS2113T to [UE](#8-glossary)

Expected Output: 

![EditExistingModule_ByType.png](UG_Screenshots/EditExistingModule_ByType.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

Example: `edit /CS2113T /MC /8` edits the current Modular Credits that CS2113T is worth to 8.

Expected Output:

![EditExistingModule_ByMC.png](UG_Screenshots/EditExistingModule_ByMC.png)

> ❗ **Warning**
>
> Modganiser will show an error if you edit a module that doesn't exist.
>
>![EditError](UG_Screenshots/Edit_Module_Not_In_List.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

#### 5.3.4 Deleting Module From Module Plan: `delete`
**Function**

Deletes an existing module that corresponds to the module code inputted.

|  [Parameter](#8-glossary)  |        Description        |                                                               Accepted Inputs                                                                |
|:-----------:|:-------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------:|
| MODULE_CODE |     The module's code     |                                                         All inputs will be accepted                                                          |


**Command Format**

`delete /MODULE_CODE`

Example: `delete /CS2113T` deletes CS2113T module from the module plan

![DeleteCommand](UG_Screenshots/DeleteExistingModule.png)

> ❗ **Warning** 
> 
> Modganiser will show an error if you delete a module that doesn't exist.
> 
>![DeleteError](UG_Screenshots/Delete_Error_Module_Not_In_List.png) 

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.4 Managing Display of Module Plan

#### 5.4.1 Viewing Module Plan: `list`

### List command: `list`

**Function**

Displays your 4 year module plan, separated by year. You can also choose to only show a specific year of your module plan


| [Parameter](#8-glossary) |                      Description                       | Accepted Inputs |
|:------------------------:|:------------------------------------------------------:|:---------------:|
|           YEAR           | The specific year of your module plan you wish to view | ALL, 1, 2, 3, 4 |

**Command Format** 

`list /YEAR`

Example: `list /all` lists the entire module plan.

![ListingAllModules.png](UG_Screenshots/ListingAllModules.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

Example: `list /1` lists Year 1's module plan.

![ListAllModulesByYear.png](UG_Screenshots/ListAllModulesByYear.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

#### 5.4.2 Finding Modules in the Module Plan: `find`
**Function**

Searches for the module whose module code contains the keyword inputted by the user, or the modules whose [module type](#8-glossary) corresponds to the user's input.

|   [Parameter](#8-glossary)    |                          Description                           |                                                                Accepted Inputs                                                                |
|:--------------:|:--------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:|
| TYPE_OF_SEARCH |    Specifies to search using the module code or [module type](#8-glossary)    |                                                                  CODE, TYPE                                                                   |
|    KEYWORD     |                   The keyword to search for                    | If TYPE_OF_SEARCH is CODE, all inputs will be accepted. However, if TYPE_OF_SEARCH is TYPE, only [CORE, GE, UE and INTERNSHIP](#8-glossary) will be accepted |

**Command Format**

`find /TYPE_OF_SEARCH /KEYWORD`

Example: `find /TYPE /CS2113T` finds all modules that contains CS2113T.

![FindOneModule](UG_Screenshots/FindModulesByName_Full.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

Example: `find /CODE /CS` finds all modules whose module code contains the keyword “CS”.

![Findallthatcontains](UG_Screenshots/FindModulesByName_Substring.png)

Example: `find /TYPE /CORE` finds all modules whose [module type](#8-glossary) is [Core](#8-glossary).

![FindModuleType](UG_Screenshots/FindModulesByType.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.5 Tracking Graduation Progress
#### 5.5.1 Tracking the Completion of Each Module Type: `track`
**Function**
Tracks how many modular credits of a [module type](#8-glossary) you have completed and Modganiser will list out all the modules that you have completed under that [module type](#8-glossary) and how many more modular credits you need before you meet the requirements for it.

|  [Parameter](#8-glossary)  |                   Description                    |        Accepted Inputs        |
|:-----------:|:------------------------------------------------:|:-----------------------------:|
| MODULE_TYPE | The [module type](#8-glossary) whose status you want to look up | ALL, [CORE, GE, UE, INTERNSHIP](#8-glossary) |

**Command Format**
`track /MODULE_TYPE`
Example: `track/CORE` tracks the completion status of your [core modules](#8-glossary).

![trackCore](UG_Screenshots/TrackCommand.png)

> 📓 **Note** 
> 
>Completed modules are modules which have a grade. Modules which do not have a grade 
will not be considered as completed and hence counted.

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.5.2 Calculating Your Current CAP: `calculatecap`
**Function**

Calculate your current CAP based on the grades you obtained. Grades obtained correspond to a number that is used to calculate your CAP.  
To find out more about how your CAP is calculated, do visit the official [NUS website](https://www.nus.edu.sg/registrar/academic-information-policies/modular-system) :)
  
|  [Parameter](#8-glossary)  |                   Description                    |        Accepted Inputs        |
|:-----------:|:------------------------------------------------:|:-----------------------------:|
| NIL | NIL | NIL |

**Command Format**

`calculatecap`

Example: `calculatecap` calculates your current CAP

![CalculateCAPCommand](UG_Screenshots/GradeCalculator.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

### 5.6 Miscellaneous
#### 5.6.1 Viewing the Entire Manual: `man`

**Function**

Shows a summary of all the available commands

| [Parameter](#8-glossary) | Description | Accepted Inputs |
|:---------:|:-----------:|:---------------:|
|    NIL    |     NIL     |       NIL       |


**Command format**

`man`

Example : `man` displays the manual page

Expected Output:

![ViewManPage](UG_Screenshots/ViewEntireManual.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

#### 5.6.2 Viewing the Detailed Manual Page for A Single Feature: `man /FEATURE`

**Function**

Shows a detailed instruction page for the specific command requested

| [Parameter](#8-glossary) |                    Description                     |                    Accepted Inputs                    |
|:---------:|:--------------------------------------------------:|:-----------------------------------------------------:|
|  FEATURE  | The command that you would like to know more about | add, list, edit, find, delete, calculator, grade, bye |

**Command format**

`man /FEATURE`

Example: `man /add` displays the manual page for the add feature

![Viewspecificmanual](UG_Screenshots/ViewManualofSpecificFeature.png)

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

#### 5.6.3 Exiting Modganiser: `bye`
**Function**

Exits Modganiser

**Command Format**

`bye`
Example: `bye` exits the program
![ByeCommand](UG_Screenshots/ExitCommand.png)

> 📓 **Note** 
> 
>Typing bye during any time when the Modganiser is running will exit the program. 
When Modganiser asks for your name during its first start up, typing bye will also exit the 
program. If your name is “bye”, please do consider using an alias.
Thank you and sorry for the inconvenience caused.

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

#### 5.6.4 Saving Module Plan

Modganiser automatically saves your module plan into your [local storage](#8-glossary) onto your device after every command you input

To find your save file:
1. Go to your Desktop and find the folder titled “Modganiser” or find the folder where tp.jar is saved.
2. Double-click on the folder and find the folder titled “data”
3. Double-click on the folder and the file titled “modules.txt” is the save file

> ❗ **Warning** 
> 
> Please do not edit this save file to prevent corrupting your saved data.

Your saved module plan will be automatically loaded when you run Modganiser.

> 📓 **Note**
> 
> If you switch devices, and want to import your module plan from your old device to 
the new one, firstly locate your save file on the old device, which is just a normal text 
file. You can then use any form of messaging applications like [Telegram](https://telegram.org/), email applications 
like [Gmail](https://mail.google.com/) or online cloud storage like [Google Drive](https://drive.google.com/) to send this save file to yourself or 
store this save file. You can then retrieve this save file from your new device.

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>


## 6. FAQ

---

| Questions                                                                                                                     | Answers                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
|-------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| I am unable to install java?                                                                                                  | Please click [here](https://www.oracle.com/sg/java/technologies/downloads/) to install the correct version of java for your device (Windows or MacOS) or contact the developers for help.                                                                                                                                                                                                                                                                                                                               |
| Why is Modganiser not running?                                                                                                | Please follow our [Command Line Interface Tutorial](#3-command-line-interface-tutorial) and our [Set-Up Guide](#4-set-up-guide) closely. If Modganiser still fails to run, please [contact us](https://github.com/AY2223S2-CS2113T-T09-4/tp).                                                                                                                                                                                                                                                                                                                       |
| Where is my save file?                                                                                                        | Please go to your desktop and locate the folder titled “Modganiser” or the folder where you stored tp.jar. Inside that folder, you will find another folder titled “data” which has a text file titled “modules”. This text file is the save file which has information on your module plan.                                                                                                                                                                                                                            |
| What if I change my device? How do I transfer the save data to my new device?                                                     | You can locate your save file, which is just a normal text file. You can then use any form of messaging applications like [Telegram](https://telegram.org/), email applications like [Gmail](https://mail.google.com/) or online cloud storage like [Google Drive](https://drive.google.com/) to send this save file to yourself or store this save file. You can then retrieve this save file with your new device.                                                                                                    |
| Why am I able to add CS0000 even though it is not a valid module?                                                             | We are unable to keep a database of modules in our ChatBot and hence cannot check if the module code you inputted is being offered. Please go onto [NUSMods](https://nusmods.com) to check the modules you want to take before carefully inputting the module code and the number of MCs of that module. Furthermore, please double check against the [Information Security Student requirements](https://www.comp.nus.edu.sg/cugresource/per-cohort/isc/isc-21-22/) before deciding on the [module type](#8-glossary). |
| Why is it that when the Modganiser ask for my name and I type bye, the Modganiser will quit instead of saving my name as bye? | `bye` is a command that will quit Modganiser, regardless of where it is used. If your name is “bye”, please consider using an alias. We are very sorry for the inconvenience caused.                                                                                                                                                                                                                                                                                                                                    |

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

## 7. Command Summary

---

|             Feature             |                           Format                            |                                   Example                                    |
|:-------------------------------:|:-----------------------------------------------------------:|:----------------------------------------------------------------------------:|
|           Add modules           | `add /MODULE_CODE /MODULAR_CREDITS /MODULE_TYPE /YEAR /SEM` | `add /CS2113T /4 /CORE /1 /1` or `add /CS2113T CS2101 IS4231 /4 /CORE /1 /1` |
|       Add grade obtained        |                 `grade /MODULE_CODE /GRADE`                 |                             `grade /CS2113T /A+`                             |
| Edit details of existing module |       `edit /MODULE_CODE /FIELD_TO_EDIT /NEW_INFO  `        |                          `edit /CS2113T /TYPE /UE`                           |
|     Delete existing module      |                    `delete /MODULE_CODE`                    |                              `delete /CS2113T`                               |
|        List module plan         |                        `list /YEAR`                         |                                  `list /2`                                   |
|   Find module in module plan    |               `find /TYPE_OF_SEARCH /KEYWORD`               |                      `find /CODE /CS or find /TYPE /GE`                      |
|  Track progress of [module type](#8-glossary)  |                    `track /MODULE_TYPE`                     |                             `track /INTERNSHIP`                              |
|      Calculate current CAP      |                       `calculatecap`                        |                                `calculatecap`                                |
|        View Manual Page         |                   `man` or `man /FEATURE`                   |                             `man` or `man /add`                              |
|         Exit Modganiser         |                            `bye`                            |                                    `bye`                                     |

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>

## 8. Glossary

---

| Technical Term         | Explanation                                                                                                                                                                                                                                                                   |
|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Command Line Interface | Text based user interface to run programs                                                                                                                                                                                                                                     |
| Parameter              | Additional input fields that require user inputs for the [command word](#51-notes-on-the-command-format)                                                                                                                                                                      |
| Module Type            | Refers to one of Core, GE, UE, INTERNSHIP or all of them.                                                                                                                                                                                                                     | 
| Core Module Type       | Any module that does not fall under UE, GE or Internship module type                                                                                                                                                                                                          |
| GE Module Type         | Stands for General Elective Module Type. Please refer to the [NUS Website](https://www.nus.edu.sg/registrar/academic-information-policies/undergraduate-students/general-education/for-students-admitted-from-ay2021-22) for more information on the General Elective Modules |
| UE Module Type         | Stands for Unrestricted Elective Module Type. Please refer to the [NUS Website](https://www.nus.edu.sg/registrar/academic-information-policies/undergraduate-students/curriculum-structure) for more information on the UE Module                                             |
| Internship Module Type | Please refer to the [NUS Website](https://www.comp.nus.edu.sg/industry/intern/student/) for more information on Internships                                                                                                                                                   |
| Local storage          | Data that is stored on your device and can be accessed without an internet connection                                                                                                                                                                                         |

<p style = "text-align:right"><small>Click <a href="#top">here</a> to return to the top</small></p>

---

<div style="page-break-after: always;"></div>
