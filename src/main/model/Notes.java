package model;

import org.json.JSONObject;
import persistence.Writable;

public class Notes implements Writable {

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


    @Override
    // Code based on Json Demo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", letter);
        return json;
    }
}
