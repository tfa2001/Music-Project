package ui.tools;

import model.NoteShape;
import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class RemoveTool extends Tool {

    private NoteShape shapeToDelete;

    public RemoveTool(MusicSheetEditor editor, JComponent parent) {
        super(editor, parent);
        shapeToDelete = null;
    }

    // MODIFIES: this
    // EFFECTS:  constructs a delete button which is then added to the JComponent (parent)
    //           which is passed in as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Remove Note");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS:  constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(new RemoveToolClickHandler());
    }

    // MODIFIES: this
    // EFFECTS:  Sets the shape at the current mouse position as the shape to delete,
    //           selects the shape and plays it
    @Override
    public void mousePressedOnNote(MouseEvent e) {
        shapeToDelete = editor.getShapeInDrawing(e.getPoint());
    }

    // MODIFIES: this
    // EFFECTS:  unselects the shape being deleted, and removes it from the drawing
    @Override
    public void mouseReleasedOnNote(MouseEvent e) {
        if (shapeToDelete != null) {
            editor.removeFromDrawing(shapeToDelete);
        }
        shapeToDelete = null;
    }

    private class RemoveToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the delete tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            editor.setActiveTool(RemoveTool.this);
        }
    }
}
