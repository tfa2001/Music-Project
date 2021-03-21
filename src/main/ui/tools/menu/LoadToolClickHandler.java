package ui.tools.menu;

import ui.MusicSheetEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadToolClickHandler implements ActionListener {
    private MusicSheetEditor editor;

    public LoadToolClickHandler(MusicSheetEditor editor) {
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        editor.loadMusicSheet();
    }
}
