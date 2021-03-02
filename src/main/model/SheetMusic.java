package model;


import java.util.ArrayList;

public class SheetMusic {
    private Notes notes;
    private String letter;

    private ArrayList<Notes> sheet;

    // EFFECTS: Constructs a music sheet
    public SheetMusic() {
        this.sheet = new ArrayList<>();
        this.notes = new Notes(letter);
        letter = notes.getNoteName();

    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public Boolean addNote(Notes note) {
        this.notes = new Notes(letter);
        this.notes = note;
        System.out.println(note.getNoteName() + " is added!");
        return sheet.add(notes);
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public Boolean removeNote(String noteLetter) {
        this.letter = noteLetter;
        for (Notes note: sheet) {
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
    public Boolean viewMusicSheet() {
        if (getNoteListSize() != 0) {
            System.out.println("Here is your Music Sheet!");
            System.out.println(sheet.toString());
            return true;
        } else {
            System.out.println("Sorry, the Music Sheet is Empty.");
            return false;
        }
    }


    /* EFFECTS: Saves notes to music sheet
     */
    public String saveMusicSheet(String title) {
        System.out.println(title + " is saved!");
        return title + " is saved!";
    }

    // getter
    public Integer getNoteListSize() {
        return sheet.size();
    }


}
