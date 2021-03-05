package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    // Based on JSON Demo
    JSONObject toJson();
}
