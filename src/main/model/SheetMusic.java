package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import ui.drawing.NoteShape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheetMusic extends JPanel implements Writable {

    private Notes notes;
    private String letter;
    private String scoreName;

    private List<Notes> sheet;

    private Image img;
    private final int width = 1400;
    private final int height = 375;

    // EFFECTS: Constructs a music sheet
    public SheetMusic(String title) {
        super();
        this.scoreName = title;
        this.sheet = new ArrayList<>();
        try {
            img = ImageIO.read(new File("./data/newMusicStaff.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* MODIFIES: this
     * EFFECTS: Add note to music sheet.
     */
    public Boolean addNote(Notes note) {
        this.notes = note;
        this.letter = notes.getNoteName();
        repaint();
        return sheet.add(note);
    }

    /* MODIFIES: this
     * EFFECTS: If note is in music sheet, remove note from music sheet.
     *          Otherwise, do nothing
     */
    public void removeNote(Notes n) {
        sheet.remove(n);
        repaint();
    }

    /* MODIFIES: this
     * EFFECTS: Removes all the notes
     */
    public void removeAllNotes() {
        sheet.clear();
        repaint();
    }

    /* EFFECTS: View my music sheet
     */
    public List<Notes> viewMusicSheet() {
        return Collections.unmodifiableList(sheet);
    }


    /* EFFECTS: Saves notes to music sheet
     */
    public String saveMusicSheet(String title) {
        setMusicSheetName(title);
        System.out.println(title + " is saved!");
        return title + " is saved!";
    }

    // getter
    public Integer getNoteListSize() {
        return sheet.size();
    }

    // getter
    public String getSheetMusicName() {
        return scoreName;
    }

    // setter
    public void setMusicSheetName(String name) {
        this.scoreName = name;
    }

    // EFFECTS: paints grid, playback line, and all figures in drawing
    //          Note to students: calls to repaint gets here via the Java graphics framework
    //
    // Note: part of the code based from stackoverflow: https://stackoverflow.com/questions/4533526/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = (this.getWidth() - width) / 2;
        g.drawImage(img, x1, 0, width, height, this);
        for (Notes note : sheet) {
            note.draw(g);
        }
    }

    // EFFECTS: returns the Shape at a given Point in Drawing, if any
    public Notes getShapesAtPoint(Point point) {
        for (Notes note : sheet) {
            if (note.contains(point)) {
                return note;
            }

        }
        return null;
    }

    @Override
    // Code based on JsonReader Demo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", scoreName);
        json.put("notes", notesToJson());
        return json;
    }

    // Code based on JsonReader Demo
    private JSONArray notesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Notes note : sheet) {
            jsonArray.put(note.toJson());
        }
        return jsonArray;
    }




}
