package model;

public class Notes {

    private String letter;
    private String duration;


    /* REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G";
     *           note duration must be "whole", "half", "quarter", or "eighth"
     * EFFECTS: letter note is set to noteName;
     *          number is set to NoteNumber;
     *
     */
    public Notes(String noteName, String rhythm) {
        this.letter = noteName;
        this.duration = rhythm;
    }

    // REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G"
    public String getNoteName() {
        return letter;
    }

    // REQUIRES: note duration must be "whole", "half", "quarter", or "eighth"
    public String getNoteRhythm() {
        return duration;
    }


}
