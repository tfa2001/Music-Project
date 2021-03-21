package model;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheetMusic {

    private Notes notes;
    private String letter;
    private String scoreName;

    private List<Notes> sheet;

    private Image img;

    // EFFECTS: Constructs a music sheet
    public SheetMusic(String title) {
        super();
        this.scoreName = title;
        this.sheet = new ArrayList<>();
    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public Boolean addNote(Notes note) {
        this.notes = note;
        this.letter = notes.getNoteName();
        return sheet.add(note);
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public void removeNote(Notes n) {
        sheet.remove(n);
    }

    /* MODIFIES: this
     * EFFECTS: Removes all the notes
     */
    public void removeAllNotes() {
        sheet.clear();
    }

    /* EFFECTS: View my music sheet
     */
    public List<Notes> viewMusicSheet() {
        return Collections.unmodifiableList(sheet);
    }


    /* EFFECTS: Saves notes to music sheet
     */
    public String saveMusicSheet(String title) {
        setMusicSheetName(title);
        System.out.println(title + " is saved!");
        return title + " is saved!";
    }

    // getter
    public Integer getNoteListSize() {
        return sheet.size();
    }

    // setter
    public void setMusicSheetName(String name) {
        this.scoreName = name;
    }






}
