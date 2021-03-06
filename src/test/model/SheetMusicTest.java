package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SheetMusicTest {
    private Notes note1;
    private Notes note2;
    private Notes note3;

    private SheetMusic score; // score as in Musical Score

    @BeforeEach
    public void setup() {
        score = new SheetMusic("Sheet 1");
        note1 = new Notes("A");
        note2 = new Notes("C");
        note3 = new Notes("B");
    }


    @Test
    public void testAddNote() {
        assertTrue(score.addNote(note1));
        assertEquals(1, score.getNoteListSize());
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertEquals(3, score.getNoteListSize());


    }

    @Test
    public void testRemoveNote() {
        assertTrue(score.addNote(note1));
        assertTrue(score.removeNote("A"));
        assertEquals(0, score.getNoteListSize());

        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note1));
        assertTrue(score.removeNote("A"));
        assertEquals(1, score.getNoteListSize());

        assertFalse(score.removeNote("B"));
        assertEquals(1, score.getNoteListSize());
    }

    @Test
    public void testRemoveAllNotes() {
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertTrue(score.removeAllNotes());
        assertEquals(0, score.getNoteListSize());
    }

    @Test
    public void testViewMusicSheet() {
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note3));
        List<Notes> sheetMusic = score.viewMusicSheet();

        List<Notes> expected = new ArrayList<>();
        expected.add(0, new Notes("B"));
        expected.add(0, new Notes("C"));
        expected.add(0, new Notes("A"));
//      assertEquals(expected, sheetMusic);

        assertTrue(score.removeAllNotes());
        expected.clear();
        assertEquals(expected, sheetMusic);
    }


    @Test
    public void testSaveMusicSheet() {
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertEquals("Sheet 1 is saved!", score.saveMusicSheet("Sheet 1"));
    }
}