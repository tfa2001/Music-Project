package ui.drawing;

import ui.drawing.NoteShape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO: Some code based on SimpleDrawingPlayer
public class SheetMusicDrawing extends JPanel {

    private List<NoteShape> notes;
    private Image img;
    private final int width = 1400;
    private final int height = 375;

    public SheetMusicDrawing() {
        super();
        notes = new ArrayList<>();
        try {
            img = ImageIO.read(new File("./data/newMusicStaff.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        for (NoteShape note : notes) {
            note.draw(g);
        }
    }

    // EFFECTS: returns the Shape at a given Point in Drawing, if any
    public NoteShape getShapesAtPoint(Point point) {
        for (NoteShape note : notes) {
            if (note.contains(point)) {
                return note;
            }

        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS:  adds the given shape to the drawing
    public void addShape(NoteShape n) {
        notes.add(n);
    }

    // MODIFIES: this
    // EFFECTS:  removes shape from the drawing
    public void removeShape(NoteShape n) {
        notes.remove(n);
        repaint();
    }

    // MODIFIES: this
    // EFFECTS:  removes all shapes from drawing
    public void clearShapes() {
        notes.clear();
        repaint();
    }



}
