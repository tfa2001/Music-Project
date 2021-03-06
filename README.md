# Music Sheet Application 

## *Tiffanie Ang*

This application will allow users to place notes on a music sheet. 
The intended audience is for people who would like to create music 
digitally. 

**Paper vs. Digital Composition**

*Paper*
- It is faster to write music on paper
- However, erasing notes is quite difficult.

*Digital*
- Storing and sharing music becomes easier. 
- You can easily edit mistakes 
- However, these applications are often expensive or are tedious to use. 
  
For this project, I hope to create a music sheet application that will be easier to use. 


## User Stories: 

- As a user, I would like to *add notes* to my music sheet
- As a user, I would like to *remove a note* from my music sheet
- As a user, I would like to have the option to *remove all notes* 
  in the music sheet
- As a user, I would like to view all the notes in my music sheet
- As a user, I would like to save all the notes in my music sheet
  

- As a user, if I quit my program, I would like to be asked if I 
  would like to save my changes. 
- As a user, when I start my program, I would like to be asked if 
  I would like to open my recent project.

## Phase 4: Task 2
I chose to implement the type hierarchy. 
My abstract Tool class is my superclass, and my subclasses are the 
AddNoteTool, ClearTool, MoveTool, and RemoveTool classes. 


## Phase 4: Task 3
- As of right now, my Notes and SheetMusic classes are not being used. 
I would have liked to be able to extend Notes and SheetMusic or 
  associate them with NoteShape and SheetMusicDrawing.
    
- In order to make it even more robust, I would have made my AddNoteTool
throw an exception if a note was added in the blank space in between the 
  music staff
  



