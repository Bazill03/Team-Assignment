





# Overview
Create a D&D Character builder using Swing.

# Tasks
- [ ] Get GUI configured
	- [x] Make room for portrait
- [x] Cycle class via drop-down box
- [x] Cycle race via drop-down box
- [x] Portraits
	- [x] Drawn
	- [x] Implemented
- [x] randomizeCharacter.java
- [x] Info buttons
	- [x] Text Written
	- [x] Opens in a new window
	- [ ] Descriptions moved to file
	- [x] Read from file
- [x] Gender buttons
- [ ] Stats
	- [ ] unsure on implementation
- [ ] displayInformation.java
	- [x] Basic Implementation
	- [x] Fill out race descriptions
	- [x] Fill out class descriptions
	- [ ] Clean up and remove code duplication
- [ ] User can enter a character name
	- [ ] GUI
	- [ ] Character.java implemented
	- [ ] Reads and writes character names from file
- [x] Write out a file containing character information
- [ ] Classes should have default starting stats
- [ ] Legendary Characters
# General Summary

- This is an application that creates a DnD character with a combination of race and classes (GUI requirement),
- The user would be able to select the race/class through either cycling them with a button or using a drop-down box. 
- Changing race or class will change the portrait displayed on the left of the window
- The GUI should include a random option for users to randomize the race and class. This should be implemented as a class (randomizeCharacter.java). 
- The GUI should include a button next to the class and race to let the user read information about the according to class and race if they wish to do so.
- This should be implemented as a class (displayInformation.java). 
- The GUI should include a button that reset the character and return it to the default creation (Human, Warrior?). 
- This should be implemented as a class (resetCharacter.java). The GUI should include a button that lets the user choose the character’s gender. 
- This should be implemented as a class? (changeCharacterGender.java).
- Let the app have text files that store all the information about the class and race about the creation of the character. 
- Maybe include this also for the stats? Use generic collections to store the starting item(s) of Legendary Character and the amount of it.
