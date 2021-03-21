package persistence;

import model.Notes;
import model.SheetMusic;
import org.junit.jupiter.api.Test;
import ui.drawing.NoteShape;
import ui.drawing.SheetMusicDrawing;

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
            SheetMusicDrawing sm = reader.read();
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
            SheetMusicDrawing sm = reader.read();
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
            SheetMusicDrawing sm = reader.read();
            List<NoteShape> notes = sm.viewMusicSheet();
            assertEquals("My sheet music", sm.getSheetMusicName());
            assertEquals(3, notes.size());
            checkNote(50, 20, notes.get(0));
            checkNote(10, 20, notes.get(1));
            checkNote(50, 10, notes.get(2));

        } catch (IOException e) {
            fail("Could not read file");
        }
    }
}
