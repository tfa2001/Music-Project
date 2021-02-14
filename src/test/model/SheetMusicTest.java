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
        score.addNote(note1);
        assertEquals(1, score.getNoteListSize());
        score.addNote(note1);
        score.addNote(note1);
        assertEquals(3, score.getNoteListSize());
    }

    @Test
    public void testRemoveNote() {
        note1 = new Notes("A");
        note2 = new Notes("C");
        score.addNote(note1);
        score.removeNote(note1);
        assertEquals(0, score.getNoteListSize());
        score.addNote(note1);
        score.addNote(note1);
        score.removeNote(note1);
        assertEquals(1, score.getNoteListSize());
        score.removeNote(note2);
        assertEquals(1, score.getNoteListSize());
    }

    @Test
    public void testRemoveAllNotes() {
        note1 = new Notes("A");
        note2 = new Notes("B");
        score.addNote(note1);
        score.addNote(note2);
        score.addNote(note1);
        score.removeAllNotes();
        assertEquals(0, score.getNoteListSize());
    }

    @Test
    public void testViewMusicSheet() {
        note1 = new Notes("A");
        note2 = new Notes("B");
        score.addNote(note1);
        score.addNote(note2);
        score.addNote(note1);
        assertTrue(score.viewMusicSheet());
        score.removeAllNotes();
        assertFalse(score.viewMusicSheet());
    }

    @Test
    public void testSaveMusicSheet() {
        note1 = new Notes("A");
        note2 = new Notes("B");
        score.addNote(note1);
        score.addNote(note2);
        score.addNote(note1);
        assertEquals("Sheet 1 is saved!", score.saveMusicSheet("Sheet 1"));
    }
}