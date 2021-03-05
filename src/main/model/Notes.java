package model;

import org.json.JSONObject;
import persistence.Writable;

public class Notes implements Writable {

    private String letter;
    private Rhythm rhythm;


    /* REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G";
     * EFFECTS: letter note is set to noteName;
     */
    public Notes(String noteName, Rhythm rhythm) {
        this.letter = noteName;
        this.rhythm = rhythm;
    }

    // REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G"
    // getter
    public String getNoteName() {
        return letter;
    }

    // getter
    public Rhythm getRhythm() {
        return rhythm;
    }

    @Override
    // Code based on Json Demo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", letter);
        json.put("rhythm", rhythm);
        return json;
    }
}
