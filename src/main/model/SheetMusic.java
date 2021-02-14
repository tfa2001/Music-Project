package model;


import java.util.ArrayList;

public class SheetMusic {
    private Notes note;
    private SheetMusic score;
    private ArrayList<Notes> sheet;
    private String scoreTitle;

    // EFFECTS: Constructs a music sheet
    public SheetMusic(String title) {
        this.sheet = new ArrayList<>();
        this.scoreTitle = title;
    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public void addNote(Notes note, ArrayList<Notes> list) {
        this.sheet = list;
        sheet.add(note);
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public void removeNote(Notes note) {
        sheet.remove(note);
    }

    public String getScoreTitle() {
        return scoreTitle;
    }


}
