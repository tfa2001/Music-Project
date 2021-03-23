package persistence;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.drawing.NoteShape;
import ui.drawing.SheetMusicDrawing;

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

    // EFFECTS: reads sheet music from file and returns it;
    // throws IOException if an error occurs reading data from file
    // Code based on JsonReader Demo
    public SheetMusicDrawing read() throws IOException {
        String jsonData = readFile(file);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSheetMusic(jsonObject);
    }

    // EFFECTS: parses sheet music from JSON object and returns it
    // Code based on JsonReader Demo
    private SheetMusicDrawing parseSheetMusic(JSONObject jsonObject) {
        String name = jsonObject.getString("title");
        SheetMusicDrawing sm = new SheetMusicDrawing(name);
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
    private void addNotes(SheetMusicDrawing sm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("notes");
        for (Object json : jsonArray) {
            JSONObject nextNote = (JSONObject) json;
            addNote(sm, nextNote);
        }
    }

    // MODIFIES: sm
    // EFFECTS: parses note from JSON object and adds it to sheet music
    // Code based on JsonReader Demo
    private void addNote(SheetMusicDrawing sm, JSONObject jsonObject) {
        int x1 = jsonObject.getInt("x-position");
        int y1 = jsonObject.getInt("y-position");
        NoteShape note = new NoteShape(x1, y1, NoteShape.NOTE_WIDTH, NoteShape.NOTE_HEIGHT);
        sm.addNote(note);
    }




}
