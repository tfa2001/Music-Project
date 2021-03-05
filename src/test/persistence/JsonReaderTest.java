package persistence;

import model.Notes;
import model.SheetMusic;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{
    @Test
    // Tests made based on JSON Demo
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            SheetMusic sm = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    // Tests made based on JSON Demo
    public void testReaderEmptySheetMusic() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySheetMusic.json");
        try {
            SheetMusic sm = reader.read();
            assertEquals("My sheet music", sm.getSheetMusicName());
            assertEquals(0, sm.getNoteListSize());
        } catch (IOException e) {
            fail("Could not read from file");
        }
    }

    @Test
    // Tests made based on JSON Demo
    public void testReaderGeneralSheetMusic() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralSheetMusic.json");
        try {
            SheetMusic sm = reader.read();
            ArrayList<Notes> notes = sm.viewMusicSheet();
            assertEquals("My sheet music", sm.getSheetMusicName());
            assertEquals(3, notes.size());
            checkNote("a", notes.get(0));
            checkNote("b", notes.get(1));
            checkNote("a", notes.get(2));

        } catch (IOException e) {
            fail("Could not read file");
        }
    }
}
