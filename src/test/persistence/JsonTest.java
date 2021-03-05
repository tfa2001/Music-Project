package persistence;

import model.Notes;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkNote(String noteName, Notes note) {
        assertEquals(noteName, note.getNoteName());
    }
}
