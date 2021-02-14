package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SheetMusicTest {
    private Notes note;
    private ArrayList<Notes> sheet;

    private SheetMusic score; // score as in Musical Score
    private SheetMusic score1;
    private SheetMusic score2;

    @BeforeEach
    public void setup() {
        score = new SheetMusic("Sheet 1");
        sheet = new ArrayList<>();
    }


    @Test
    public void testAddNote() {
        note = new Notes("A", "quarter");
        score.addNote(note, sheet);
        assertEquals(1, sheet.size());
    }

    @Test
    public void testRemoveNote() {
        note = new Notes("A", "quarter");
        score.addNote(note, sheet);
        score.removeNote(note);
        assertEquals(0, sheet.size());
    }


}