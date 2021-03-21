package persistence;

import model.Notes;
import ui.drawing.NoteShape;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkNote(int x, int y, NoteShape note) {
        assertEquals(x, note.getX1());
        assertEquals(y, note.getY1());
    }
}
