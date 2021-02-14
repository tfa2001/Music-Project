package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.MusicSheet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MusicSheetTest {
    private Notes note;
    private ArrayList<Notes> sheet;
    private MusicSheet score; // score as in Musical Score

    @BeforeEach
    public void setup() {
        score = new MusicSheet("Sheet 1");
        sheet = new ArrayList<>();
    }


    @Test
    public void testAddNote() {
        note = new Notes("A", "quarter");
        score.addNote(note);
        assertEquals(1, sheet.size());
    }

    @Test
    public void testRemoveNote() {
        note = new Notes("A", "quarter");
        score.addNote(note);
        score.removeNote(note);
        assertEquals(0, sheet.size());
    }

    @Test
    public void testSaveMusicSheet() {
        assertEquals("Sheet 1 is saved!", score.saveMusicSheet("Sheet 1"));
    }

    @Test
    public void testMusicSheetList() {

    }


}