package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class SheetMusicTest {
    private Notes note1;
    private Notes note2;

    private SheetMusic score; // score as in Musical Score

    @BeforeEach
    public void setup() {
        score = new SheetMusic("Sheet 1");
        note1 = new Notes("A", Rhythm.EIGHTH);
        note2 = new Notes("C", Rhythm.QUARTER);
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
        assertTrue(score.addNote(note1));

        assertTrue(score.removeAllNotes());
        assertEquals(score.viewMusicSheet(), score.viewMusicSheet());
    }

    @Test
    public void testSaveMusicSheet() {
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertEquals("Sheet 1 is saved!", score.saveMusicSheet("Sheet 1"));
    }
}