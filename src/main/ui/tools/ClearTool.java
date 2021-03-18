package ui.tools;

import model.SheetMusicDrawing;
import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ClearTool extends Tool {

    private SheetMusicDrawing drawing;

    public ClearTool(MusicSheetEditor editor, JComponent parent) {
        super(editor, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Clear Notes");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new ClearTool.ClearToolClickHandler());
    }



    private class ClearToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the delete tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            editor.clearNotesFromDrawing();
        }
    }
}
