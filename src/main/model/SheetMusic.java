package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheetMusic {

    private String scoreName;
    private String letter;

    private final List<Notes> sheet;


    // EFFECTS: Constructs a music sheet
    public SheetMusic(String title) {
        this.scoreName = title;
        this.sheet = new ArrayList<>();
    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public Boolean addNote(Notes note) {
        letter = note.getNoteName();
        return sheet.add(new Notes(letter));
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

    // getter
    public String getSheetMusicName() {
        return scoreName;
    }


}
