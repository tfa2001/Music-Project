package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SheetMusicTest {
    private Notes note1;
    private Notes note2;

    private SheetMusic score; // score as in Musical Score

    @BeforeEach
    public void setup() {
        score = new SheetMusic();
    }


    @Test
    public void testAddNote() {
        note1 = new Notes("A");
        assertTrue(score.addNote(note1));
        assertEquals(1, score.getNoteListSize());
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note1));
        assertEquals(3, score.getNoteListSize());
    }

    @Test
    public void testRemoveNote() {
        note1 = new Notes("A");
        note2 = new Notes("C");
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
        note1 = new Notes("A");
        note2 = new Notes("B");
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertTrue(score.removeAllNotes());
        assertEquals(0, score.getNoteListSize());
    }

    @Test
    public void testViewMusicSheet() {
        note1 = new Notes("A");
        note2 = new Notes("B");
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertTrue(score.viewMusicSheet());
        assertTrue(score.removeAllNotes());
        assertFalse(score.viewMusicSheet());
    }

    @Test
    public void testSaveMusicSheet() {
        note1 = new Notes("A");
        note2 = new Notes("B");
        assertTrue(score.addNote(note1));
        assertTrue(score.addNote(note2));
        assertTrue(score.addNote(note1));
        assertEquals("Sheet 1 is saved!", score.saveMusicSheet("Sheet 1"));
    }
}