package ui;

import model.Notes;
import model.SheetMusic;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.Scanner;

public class MusicSheetApp {

    private static final String JSON_STORE = "./data/sheetMusic.json";
    private Notes note;
    private SheetMusic score;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    private Scanner input; //Teller App

    // EFFECTS: Constructs a music sheet and runs the application
    public MusicSheetApp() {
        score = new SheetMusic("My music sheet");
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runMusicSheet();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // Note: code inspired by Teller App
    private void runMusicSheet() {
        boolean willContinue = true;
        String command = null;

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

    // EFFECTS: displays menu of options to user
    // Note: code inspired by Teller App
    private void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("\ta -> Add Note");
        System.out.println("\tr -> Remove Note");
        System.out.println("\tc -> Clear all the Notes");
        System.out.println("\tv -> View Music Sheet");
        System.out.println("\ts -> Save Music Sheet");
        System.out.println("\tl -> Load Music Sheet");
        System.out.println("\tq -> Quit App");
    }

    // MODIFIES: this
    // EFFECTS: asks user about what they would like to do
    // Note: code inspired by Teller App
    private void continueOperation(String command) {
        switch (command) {
            case "a":
                doAddNote();
                break;
            case "r":
                doRemoveNote();
                break;
            case "c":
                doClearMusicSheet();
                break;
            case "v":
                doViewMusicSheet();
                break;
            case "s":
                doSaveMusicSheet();
                break;
            case "l":
                doLoadMusicSheet();
                break;
            default:
                System.out.println("Selection not valid");
                break;
        }
    }

    // Code based on JSON demo
    // EFFECTS: loads sheet music from file
    private void doLoadMusicSheet() {
        System.out.println("Loaded " + score.getSheetMusicName() + " from " + JSON_STORE);
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
        note = new Notes(noteName);
        if (noteName.equalsIgnoreCase("A")
                || noteName.equalsIgnoreCase("B")
                || noteName.equalsIgnoreCase("C")
                || noteName.equalsIgnoreCase("D")
                || noteName.equalsIgnoreCase("E")
                || noteName.equalsIgnoreCase("F")
                || noteName.equalsIgnoreCase("G")) {
            score.removeNote(note);
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
    // EFFECTS: allows us to view music sheet and loads it from file
    private void doViewMusicSheet() {
        score.viewMusicSheet();
    }

    // MODIFIES: this
    // EFFECTS: allows us to save music sheet
    private void doSaveMusicSheet() {
        System.out.println("What would you like to name your Music Sheet?");
        String title = input.next();
        score.saveMusicSheet(title);
        /*try {
            jsonWriter.open();
            jsonWriter.write(score);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }*/
    }

}
