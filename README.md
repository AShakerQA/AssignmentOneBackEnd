# AssignmentOneBackEnd

## Contents
* [Brief](#brief)
  * [Additional Requirement](#additonal-requirements)
  * [My Approach](#my-approach)
* [Architecture](#architecture)
* [Risk Assessment](#risk-assessment)
* [Project Tracking](#project-tracking)
* [Testing](#testing)
* [Front End Design](#front-end-design)
* [Known Issues](#known-issues)
* [Future Improvements](#future-improvements)
  

### Brief
The objective states to create a **CRUD** application with the utilisation of supporting tools,methodologies and technologies that encapsulates all core modules covered during training.

In Layman's terms this means to create an application which can create, read, update and delete information in order to display my current understanding of all the technologies 
I have been introduced to.

### Additonal Requirements
The task must utilise the following technologies that I have learnt.

* A Kanban Board created within Jira
* A Database utilising GCP and MySQL (H2 used)
* Clear documentation of the design phase and a risk assessment
* A functional application created using an OOP language, in this case Java
* Front end design using HTML, CSS and JavaScript
* Test suites for the application using JUnit and Mockito
* Utilise Git as a version control system throughout the application development process
* Backend test coverage should be over 80%

### My Approach
To achieve this I have decided to create a game library within a shop.

* Create a new game that stores: 
  * The Name of the game
  * the genre of the game
  * The current price of the game
* Reading the information will be diplayed as an object within the front end (visually)
* Updating the price
  * Price can be ammended, for instance during a sale
* Deleting the game would remove the game from the database

All this information will be stored on a H2 Database.

### Architecture
The project currently has one table therefore this is no relationship in terms of multiple tables, however this is the Game table.

![ERD](https://user-images.githubusercontent.com/71396007/96352841-8704c700-10be-11eb-95a9-34becdc26fe3.png)

If an Order was to be introduced as a new table, then the relationship would be many-to-many as many different games can be in many different orders.

### Risk Assessment
![RiskAssessment](https://user-images.githubusercontent.com/71396007/96352828-72283380-10be-11eb-9be6-a7a267096d85.png)

### Project Tracking
Jira was used in order to track progress of the project using the sprint features to detect how much functionality was being completed in a set time.

Link to the Jira board:
https://recipeofdisaster.atlassian.net/jira/software/projects/RFD/boards/1/backlog

The Board utilises User stories in perspective of the staff whom are the users of the library in their store, the customers who will interact with the database online and the developers they would hire to make things run more smoothly for customers.

* To Do Would be the latest features that would need to be implemented in that particular sprint
* In progress would mean not only is someone assigned to the task, but they are looking into implementing this feature
* Done represents all features that have been added and have been tested, notes will be added if they have been implemented with hiccups

An example of a Sprint:
![jiraSShot](https://user-images.githubusercontent.com/71396007/96352848-9be15a80-10be-11eb-8dd1-ad50a3678c8f.png)

### Testing
Testing was done within the STS framework using JUnit 5 and Mockito, they were designed using the assert equals, which means a value was set and later expected in order to test
if the method is working. EclEmma was used in order to test the coverage of the entire project.
A Test Coverage of 95.7% was attained.
![testCoverage](https://user-images.githubusercontent.com/71396007/96352941-92a4bd80-10bf-11eb-96dc-9dff192f1ba6.png)

### Front End Design
Although all the CRUD functionality has been created, there is a basic appearance of the website at this point. The user has the ability to create a new entry into the Game Library using the 3 input fields. The user is also able to delete the entry or update the price.

![FEexample](https://user-images.githubusercontent.com/71396007/96386955-c4d51e80-1196-11eb-8eb2-e7fdf07bf8b1.png)

### Known Issues
Currently the only issue I have discovered is that when the user inputs data for the update field, which only intakes the price, this updates all the fields of the database entry, because it is a put method rather than a patch. 

### Future Improvements
There are a number of improvements that I would like to make:
* If a user attempts to add another game with the same title I would prefer it to reject the entry.
* Introduce a few more fields tables which interact with the game table to allow users to place orders and save them with unique order ids.
* Aesthetic design of the entire web page would be better if more time was available to experiment with CSS. (Bootstrap would be the easy way out!)

### Authors
Abdul Shaker
