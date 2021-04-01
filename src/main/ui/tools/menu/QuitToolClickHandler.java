package ui.tools.menu;


import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitToolClickHandler implements ActionListener {

    private MusicSheetEditor editor;

    // EFFECTS: creates a MenuBar that allows user to quit program
    public QuitToolClickHandler(MusicSheetEditor editor) {
        this.editor = editor;
    }

    // EFFECTS: creates a pop-up message that asks if user would like to save project
    private void beforeQuittingMessage() {
        int answer = JOptionPane.showConfirmDialog(null,
                "Would you like to save your project?",
                "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            editor.saveMusicSheet();
            System.exit(0);
        } else if (answer == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }

    // EFFECTS: quits music sheet when it is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        beforeQuittingMessage();
    }
}
