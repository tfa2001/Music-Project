package ui.drawing;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO: Some code based on SimpleDrawingPlayer
public class SheetMusicDrawing extends JPanel implements Writable {

    private List<NoteShape> notes;
    private Image img;
    private final int width = 1400;
    private final int height = 500;
    private String scoreName;

    // EFFECTS: creates a music sheet
    public SheetMusicDrawing(String title) {
        super();
        notes = new ArrayList<>();
        this.scoreName = title;
        try {
            //image screenshot from https://www.blanksheetmusic.net/#g
            img = ImageIO.read(new File("./data/officialMusicStaff.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: paints grid, playback line, and all figures in drawing
    // Note: part of the code based from stackoverflow: https://stackoverflow.com/questions/4533526/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = (this.getWidth() - width) / 2;
        g.drawImage(img, x1, 0, width, height, this);
        for (NoteShape note : notes) {
            note.draw(g);
        }
    }

    // EFFECTS: returns the notes at a given Point in editor, if any
    public NoteShape getNotesAtPoint(Point point) {
        for (NoteShape note : notes) {
            if (note.contains(point)) {
                return note;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS:  adds the given shape to the editor
    public void addNote(NoteShape n) {
        notes.add(n);
    }

    // MODIFIES: this
    // EFFECTS:  removes shape from the editor
    public void removeNote(NoteShape n) {
        notes.remove(n);
        repaint();
    }

    // MODIFIES: this
    // EFFECTS:  removes all shapes from editor
    public void clearNotes() {
        notes.clear();
        repaint();
    }

    // getter
    public Integer getNoteListSize() {
        return notes.size();
    }

    // getter
    public String getSheetMusicName() {
        return scoreName;
    }

    /* EFFECTS: View my music sheet
     */
    public List<NoteShape> viewMusicSheet() {
        return Collections.unmodifiableList(notes);
    }

    @Override
    // Code based on JsonReader Demo
    // EFFECTS: returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", scoreName);
        json.put("notes", notesToJson());
        return json;
    }

    // EFFECTS: returns NoteShape in this SheetMusicDrawing as a JSON array
    // Code based on JsonReader Demo
    private JSONArray notesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (NoteShape note : notes) {
            jsonArray.put(note.toJson());
        }
        return jsonArray;
    }



}
