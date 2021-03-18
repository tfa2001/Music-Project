package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheetMusic implements Writable {

    private Notes notes;
    private String letter;
    private String scoreName;

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
        this.notes = note;
        this.letter = notes.getNoteName();
        notes = new Notes(letter);
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
            Boolean isNoteThere = noteLetter.equalsIgnoreCase(letterOfNote);
            if (isNoteThere) {
                System.out.println(note.getNoteName() + " is removed.");
                return sheet.remove(note);
            }
        }
        System.out.println("There is no note " + noteLetter + " in Music Sheet.");
        return false;
    }

    //EFFECTS: Gets all the notes in the note list
    public List<Notes> getNotes() {
        return Collections.unmodifiableList(sheet);
    }

    /* MODIFIES: this
     * EFFECTS: Removes all the notes
     */
    public void removeAllNotes() {
        System.out.println("All notes have been removed.");
        System.out.println("Music Sheet is now Empty!");
        sheet.clear();
    }

    /* EFFECTS: View my music sheet
     */
    public List<Notes> viewMusicSheet() {
        System.out.println("Here is your Music Sheet!");
        for (Notes n : sheet) {
            String name = n.getNoteName();
            System.out.println(name);
        }
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
