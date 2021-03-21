package model;

public class Notes {

    private String letter;

    /* REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G";
     * EFFECTS: letter note is set to noteName;
     */

    public Notes(String noteName) {
        this.letter = noteName;
    }

    // REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G"
    // getter
    public String getNoteName() {
        return letter;
    }

}
