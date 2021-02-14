package ui;

import model.Notes;
import model.SheetMusic;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicSheetApp {
    private SheetMusic score;
    private ArrayList<Notes> sheet;
    private Scanner input; //Teller App

    public MusicSheetApp() {
        runMusicSheet();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMusicSheet() {
        displayMenu();

        score = new SheetMusic();
        input = new Scanner(System.in);



    }

    // EFFECTS: displays menu of options to user
    // Note: code inspired from Teller App
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add Note");
        System.out.println("\tr -> Remove Note");
        System.out.println("\tv -> View Music Sheet");
        System.out.println("\ts -> Save Music Sheet");
        System.out.println("\tq -> Quit App");
    }

    //EFFECTS: asks if user would like to a note or remove a note
    private Boolean continueOperation() {
        System.out.println("Would you like to continue adding or removing a note? Yes or No.");

        return false;

    }
}
