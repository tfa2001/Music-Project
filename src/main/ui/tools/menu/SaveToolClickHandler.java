package ui.tools.menu;

import ui.MusicSheetEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveToolClickHandler implements ActionListener {
    private MusicSheetEditor editor;

    public SaveToolClickHandler(MusicSheetEditor editor) {
        this.editor = editor;
    }

    // EFFECTS: saves music sheet when it is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        editor.saveMusicSheet();
    }
}
