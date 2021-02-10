package model;

public class Notes {

    private String letter;
    private Integer noteNumber;


    /* REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G";
     *           number of the note must be between A0 and C8
     * EFFECTS: letter note is set to noteName;
     *          number is set to NoteNumber;
     *
     */
    public Notes(String noteName, Integer number) {
        letter = noteName;
        noteNumber = number;
    }

    // REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G"
    public String getLetterName() {
        return letter;
    }

    // REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G"
    //           number of the note must be between A0 and C8

    public Integer getNoteNumber() {
        return null;
    }



}
