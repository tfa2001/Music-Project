package ui.tools.menu;


import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitToolClickHandler implements ActionListener {

    private MusicSheetEditor editor;

    public QuitToolClickHandler(MusicSheetEditor editor) {
        this.editor = editor;
    }

    private void beforeQuittingMessage() {
        int answer = JOptionPane.showConfirmDialog(null,
                "Would you like to save your project?",
                "Confirm", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            editor.saveMusicSheet();
        }
    }

    // EFFECTS: quits music sheet when it is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        beforeQuittingMessage();
        System.exit(0);
    }
}
