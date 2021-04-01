package ui.tools;

import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearTool extends Tool {

    // EFFECTS: creates a button that allows user to clear NoteShapes from SheetMusic
    public ClearTool(MusicSheetEditor editor, JComponent parent) {
        super(editor, parent);
    }

    // MODIFIES: this
    // EFFECTS:  constructs a clear button which is then added to the JComponent (parent)
    //           which is passed in as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Clear Notes");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS:  constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(new ClearTool.ClearToolClickHandler());
    }

    private class ClearToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the delete tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            beforeClearingMessage();
        }
    }

    // EFFECTS: creates a pop-up message that asks if user would like to save project
    private void beforeClearingMessage() {
        int answer = JOptionPane.showConfirmDialog(null,
                "Are you sure that you will clear Music Sheet? This action cannot be undone.",
                "Confirm", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            editor.clearNotesFromDrawing();
        }
    }
}
