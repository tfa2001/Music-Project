package ui;

import model.Notes;
import model.SheetMusic;

import java.util.Scanner;

public class MusicSheetApp {
    private Notes note;
    private SheetMusic score;
    private Scanner input; //Teller App

    public MusicSheetApp() {
        runMusicSheet();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Note: code inspired by Teller App
    private void runMusicSheet() {
        boolean willContinue = true;
        String command = null;

        initialize();

        while (willContinue) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                willContinue = false;
            } else {
                continueOperation(command);
            }
        }
    }

    // EFFECTS: initializes the program
    private void initialize() {
        score = new SheetMusic();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    // Note: code inspired by Teller App
    private void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("\ta -> Add Note");
        System.out.println("\tr -> Remove Note");
        System.out.println("\tc -> Clear all the Notes");
        System.out.println("\tv -> View Music Sheet");
        System.out.println("\ts -> Save Music Sheet");
        System.out.println("\tq -> Quit App");
    }

    // MODIFIES: this
    // EFFECTS: asks user about what they would like to do
    // Note: code inspired by Teller App
    private void continueOperation(String command) {
        if (command.equals("a")) {
            doAddNote();
        } else if (command.equals("r")) {
            doRemoveNote();
        } else if (command.equals("c")) {
            doClearMusicSheet();
        } else if (command.equals("v")) {
            doViewMusicSheet();
        } else if (command.equals("s")) {
            doSaveMusicSheet();
        }  else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new note
    private void doAddNote() {
        System.out.print("Enter the letter of the note that you would like to add: ");
        System.out.print("\n(Select from A, B, C, D, E, F, or G)");
        String noteName = input.next();
        note = new Notes(noteName);
        if (noteName.equalsIgnoreCase("A")
                || noteName.equalsIgnoreCase("B")
                || noteName.equalsIgnoreCase("C")
                || noteName.equalsIgnoreCase("D")
                || noteName.equalsIgnoreCase("E")
                || noteName.equalsIgnoreCase("F")
                || noteName.equalsIgnoreCase("G")) {
            score.addNote(note);
        } else {
            System.out.println(noteName + " is not a note.");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a note
    private void doRemoveNote() {
        System.out.print("Enter the letter of the note that you would like to remove:");
        System.out.print("\n(Select from A, B, C, D, E, F, or G)");
        String noteName = input.next();
        if (noteName.equalsIgnoreCase("A")
                || noteName.equalsIgnoreCase("B")
                || noteName.equalsIgnoreCase("C")
                || noteName.equalsIgnoreCase("D")
                || noteName.equalsIgnoreCase("E")
                || noteName.equalsIgnoreCase("F")
                || noteName.equalsIgnoreCase("G")) {
            score.removeNote(noteName);
        } else {
            System.out.println(noteName + " is not a note.");
        }
    }

    // MODIFIES: this
    // EFFECTS: clears the music sheet
    private void doClearMusicSheet() {
        score.removeAllNotes();
    }

    // MODIFIES: this
    // EFFECTS: allows us to view music sheet
    private void doViewMusicSheet() {
        score.viewMusicSheet();
    }

    // MODIFIES: this
    // EFFECTS: allows us to save music sheet
    private void doSaveMusicSheet() {
        System.out.println("What would you like to name your Music Sheet?");
        String title = input.next();
        score.saveMusicSheet(title);
    }

}
