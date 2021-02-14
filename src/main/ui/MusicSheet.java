package ui;


import model.Notes;

import java.util.ArrayList;

public class MusicSheet {
    private Notes note;
    private MusicSheet score;
    private ArrayList<Notes> sheet;
    private String scoreTitle;

    // EFFECTS: Constructs a music sheet
    public MusicSheet(String title) {
        this.sheet = new ArrayList<Notes>();
        this.scoreTitle = title;
    }

    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public void addNote(Notes note) {

    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public void removeNote(Notes note) {


    }


    /* EFFECTS: Creates a list of all the music sheet titles in our application
     */
    public void musicSheetList() {

    }

    /* EFFECTS: Saves a music sheet
     */
    public String saveMusicSheet(String title) {
        this.scoreTitle = title;
        System.out.println(scoreTitle + " is saved!");
        return scoreTitle + " is saved!";
    }

    public String getTitle() {
        return scoreTitle;
    }

}
