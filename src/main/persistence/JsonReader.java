package persistence;

import model.Notes;
import model.SheetMusic;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class JsonReader {
    private String file;

    // EFFECTS: constructs reader from source file
    // Code based on JsonReader Demo
    public JsonReader(String file) {
        this.file = file;
    }

    public SheetMusic read() throws IOException {
        String jsonData = readFile(file);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSheetMusic(jsonObject);
    }

    // EFFECTS: parses workroom from JSON object and returns it
    // Code based on JsonReader Demo
    private SheetMusic parseSheetMusic(JSONObject jsonObject) {
        String name = jsonObject.getString("title");
        SheetMusic sm = new SheetMusic(name);
        addNotes(sm, jsonObject);
        return sm;
    }


    // EFFECTS: reads source file as string and returns it
    // Code based on JsonReader Demo
    private String readFile(String file) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();

    }

    // MODIFIES: sm
    // EFFECTS: parses notes from JSON object and adds them to sheet music
    // Code based on JsonReader Demo
    private void addNotes(SheetMusic sm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("notes");
        for (Object json : jsonArray) {
            JSONObject nextNote = (JSONObject) json;
            addNote(sm, nextNote);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses note from JSON object and adds it to sheet music
    // Code based on JsonReader Demo
    private void addNote(SheetMusic sm, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Notes note = new Notes(name);
        sm.addNote(note);
    }


}
