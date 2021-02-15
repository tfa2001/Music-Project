package model;


import java.util.ArrayList;

public class SheetMusic {
    private Notes note;
    private String letter;

    private ArrayList<Notes> sheet;

    // EFFECTS: Constructs a music sheet
    public SheetMusic() {
        this.sheet = new ArrayList<>();
        this.note = new Notes(letter);
        letter = note.getNoteName();

    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public void addNote(Notes note) {
        this.note = note;
        sheet.add(note);
        System.out.println(note.getNoteName() + " is added!");
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public void removeNote(Notes note, String noteLetter) {
        String letterOfNote = note.getNoteName();
        Boolean isNoteThere = noteLetter.equals(letterOfNote);
        if (isNoteThere) {
            this.note = note;
            sheet.remove(note);
            System.out.println(note.getNoteName() + " is removed.");
        } else {
            System.out.println("There is no note " + note.getNoteName() + " in Music Sheet.");
        }
    }

    /* MODIFIES: this
     * EFFECTS: Removes all the notes
     */
    public void removeAllNotes() {
        sheet.removeAll(sheet);
        System.out.println("All notes have been removed.");
        System.out.println("Music Sheet is now Empty!");
    }

    /* EFFECTS: View my music sheet
     */
    public Boolean viewMusicSheet() {
        if (getNoteListSize() != 0) {
            System.out.println("Here is your Music Sheet!");
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
