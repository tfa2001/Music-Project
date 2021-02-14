package model;


import java.util.ArrayList;
import java.util.Scanner;

public class SheetMusic {
    private Notes note;
    private String letter;
    private ArrayList<String> letters;

    private SheetMusic score;
    private ArrayList<Notes> sheet;
    private Scanner input; //Teller App

    // EFFECTS: Constructs a music sheet
    public SheetMusic() {
        this.sheet = new ArrayList<>();
        this.note = new Notes(letter);

    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public void addNote(Notes note) {
        this.note = note;
        sheet.add(note);
        letter = note.getNoteName();
        System.out.println(letter + " is added!");
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public void removeNote(Notes note) {
        if (sheet.contains(note)) {
            sheet.remove(note);
            letter = note.getNoteName();
            System.out.println(letter + " is removed.");
        } else {
            System.out.println(letter + "does not exist in the Music Sheet.");
        }
    }

    /* EFFECTS: View my music sheet
     */
    public ArrayList<String> viewMusicSheet() {
        letters = new ArrayList<>();
        for (Notes note: sheet) {
            letter = note.getNoteName();
            letters.add(letter);
        }
        return letters;
    }

    /* EFFECTS: Saves notes to music sheet
     */
    public String saveMusicSheet(String title) {
        System.out.println(title + " is saved!");
        return title + " is saved!";
    }


    public Integer getNoteListSize() {
        return sheet.size();
    }


}
