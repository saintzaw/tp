# Saint - Project Portfolio Page

## Project: Modganiser

Modganiser is a module planner that is focused on helping Information Security Undergraduates graduate in 4 years. 
It does so by giving them a platform to plan all 4 years of their modules to aid in meeting their graduation 
requirements on time. Modganiser works via the Command Line Interface (CLI), which is much more efficient for fast 
typists.

The following sections include the contributions that I have made to the project.

#### Code Contributed
Please refer to the following links to view my contributions:
* [Code Dashboard](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=saintzaw&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17)
* [Pull Requests](https://github.com/AY2223S2-CS2113T-T09-4/tp/pulls?q=is%3Apr+author%3Asaintzaw)

#### Enhancements Implemented
* These are my contributions to the [List Command](https://github.com/AY2223S2-CS2113T-T09-4/tp/blob/master/src/main/java/seedu/main/ModuleList.java). Please refer to the lines 183-247.
    * Implemented a command to `list` the modules in the user's module plan.
    * In v2.0, implemented the function to edit the Type, Modular Credits, Year and Semester fields in a module's description.
    * In v2.1, enhanced the function by adding more input validity checks to fix functionality bugs.

* These are my contributions to the [Edit Command](https://github.com/AY2223S2-CS2113T-T09-4/tp/blob/master/src/main/java/seedu/main/ModuleList.java). Please refer to the lines 249-292.
    * Implemented a command to `edit` various fields in a module's description.
    * In v1.0, implemented the function to list all the modules in the user's module plan.
    * In v2.0, enhanced the function to list modules based on the year that they were taken or are to be taken in.

* Helped to implement the `track` graduation requirement command.
    * The `track` command allows the user to track their graduation requirements for CORE, UE, GE and INTERNSHIP-type modules.
    * Did the initial implementation of the track command for tracking UE, GE and INTERNSHIP-type modules. 
    * Please refer to [PR#119](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/119) and [PR#120](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/120) to see my contributions.
  
* Added JUnit Tests, Assertions and Logging
    * Added JUnit tests to `Print` tests for `edit` and `list` commands. Please refer to [PR#96](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/96)
    * Added assertions for `delete` command. Please refer to [PR#50](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/50)
    * Added logging to `list` commands. 

<div style="page-break-after: always;"></div>

#### Contributions to the User Guide
* [Edit Command](https://github.com/AY2223S2-CS2113T-T09-4/tp/blob/master/docs/UserGuide.md#523-editing-module-details-edit)
    * Created a draft of the edit command for UG
    * Please refer to [PR#164](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/164)
* [List Command](https://github.com/AY2223S2-CS2113T-T09-4/tp/blob/master/docs/UserGuide.md#531-viewing-module-plan-list)
    * Created a draft of the list command for UG
    * Please refer to [PR#164](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/164)

#### Contributions to the Developer Guide
* [Parser Component](https://github.com/AY2223S2-CS2113T-T09-4/tp/blob/master/docs/DeveloperGuide.md#2-parser-component)
    * Added descriptions of the Parser component for the DG
    * The following is the UML diagram I added. It is a component diagram to illustrate how the `Parser` component works.
      ![Parser Diagram](ppp_diagrams/Parser.png)
      * Please refer to [PR#235](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/235)
* [Edit Command](https://github.com/AY2223S2-CS2113T-T09-4/tp/blob/master/docs/DeveloperGuide.md#34-find-modules)
    * Added descriptions of the edit command for the DG
    * The following is the UML diagram I added. It is a sequence diagram to illustrate how the `edit` command works.
      ![EditCommand Diagram](ppp_diagrams/EditCommand.png)
    * Please refer to [PR#104](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/104)

#### Reviewing/Mentoring contributions
* Reviewed my team members' PRs. Please refer to: [PR#273](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/273) 
, [PR#181](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/181) , [PR#275](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/275)
, [PR#263](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/263) , [PR#278](https://github.com/AY2223S2-CS2113T-T09-4/tp/pull/278)

#### Contributions beyond the project team
* Reported [PE-D bugs](https://github.com/saintzaw/ped/issues) for team [EveNtUS](https://github.com/AY2223S2-CS2113-W12-2/tp)
* Reviewed User Guides and Developer Guides of other teams in my tutorial group.
