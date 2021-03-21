package ui.tools.menu;

import ui.MusicSheetEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitToolClickHandler implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
