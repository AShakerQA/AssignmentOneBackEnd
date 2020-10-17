# AssignmentOneBackEnd
### Brief
The objective states to create a **CRUD** application with the utilisation of supporting
tools,methodologies and technologies that encapsulates all core modules covered during 
training.

In Layman's terms this means to create an application which can create, read, update and 
delete information in order to display my current understanding of all the technologies 
I have been introduced to.


### Additonal requirements
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

![ERD](https://user-images.githubusercontent.com/71396007/96352422-ebbe2280-10ba-11eb-8b29-0b22342aa794.png)

If an Order was to be introduced as a new table, then the relationship would be many-to-many as many different games can be in many different orders.

### Risk Assessment
![RiskAssessment](https://user-images.githubusercontent.com/71396007/96352598-499f3a00-10bc-11eb-89f9-760810838ad2.png)
