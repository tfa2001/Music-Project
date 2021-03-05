package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class SheetMusic implements Writable {
    private Notes notes;
    private String letter;
    private String scoreName;
    private Rhythm rhythm;

    private ArrayList<Notes> sheet;

    // EFFECTS: Constructs a music sheet
    public SheetMusic(String title) {
        this.scoreName = title;
        this.sheet = new ArrayList<>();
    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public Boolean addNote(Notes note) {
        this.notes = note;
        this.rhythm = note.getRhythm();
        this.notes = new Notes(letter, rhythm);
        System.out.println(note.getNoteName() + " is added!");
        return sheet.add(notes);
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public Boolean removeNote(String noteLetter) {
        this.letter = noteLetter;
        for (Notes note : sheet) {
            String letterOfNote = note.getNoteName();
            Boolean isNoteThere = letterOfNote.equalsIgnoreCase(noteLetter);
            if (isNoteThere) {
                System.out.println(note.getNoteName() + " is removed.");
                return sheet.remove(note);
            }
        }
        System.out.println("There is no note " + noteLetter + " in Music Sheet.");
        return false;
    }

    /* MODIFIES: this
     * EFFECTS: Removes all the notes
     */
    public Boolean removeAllNotes() {
        System.out.println("All notes have been removed.");
        System.out.println("Music Sheet is now Empty!");
        return sheet.removeAll(sheet);
    }

    /* EFFECTS: View my music sheet
     */
    public ArrayList<Notes> viewMusicSheet() {
        if (getNoteListSize() != 0) {
            System.out.println("Here is your Music Sheet!");
            for (Notes n: sheet) {
                String name = n.getNoteName();
                System.out.println(name);
            }
        } else {
            System.out.println("Sorry, the Music Sheet is Empty.");
        }
        return sheet;
    }

    /* EFFECTS: Saves notes to music sheet
     */
    public String saveMusicSheet(String title) {
        System.out.println(title + " is saved!");
        setMusicSheetName(title);
        return title + " is saved!";
    }

    // getter
    public Integer getNoteListSize() {
        return sheet.size();
    }

    // getter
    public String getSheetMusicName() {
        return scoreName;
    }

    // setter
    public void setMusicSheetName(String name) {
        this.scoreName = name;
    }

    @Override
    // Code based on JsonReader Demo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", scoreName);
        json.put("notes", notesToJson());
        return json;
    }

    // Code based on JsonReader Demo
    private JSONArray notesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Notes note : sheet) {
            jsonArray.put(note.toJson());
        }
        return jsonArray;
    }



}
