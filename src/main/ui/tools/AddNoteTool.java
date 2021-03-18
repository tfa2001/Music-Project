package ui.tools;

import ui.drawing.NoteShape;
import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

//TODO: Code based on SimpleDrawingPlayer
public class AddNoteTool extends Tool {
    private final int width = 50;
    private final int height = 30;
    private NoteShape note;

    public AddNoteTool(MusicSheetEditor editor, JComponent parent) {
        super(editor, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add Note");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new AddToolClickHandler());
    }

    // MODIFIES: this
    // EFFECTS:  a shape is instantiate MouseEvent occurs, and played and
    //           added to the editor's drawing
    @Override
    public void mousePressedOnNote(MouseEvent e) {
        makeShape(e);
        editor.addToDrawing(note);
    }

    // MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
    @Override
    public void mouseReleasedOnNote(MouseEvent e) {
        note = null;
    }

    //EFFECTS: Constructs and returns the new shape
    private void makeShape(MouseEvent e) {
        note = new NoteShape(e.getPoint(), width, height);
    }

    private class AddToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            editor.setActiveTool(AddNoteTool.this);
        }
    }
}
