package persistence;

import model.Notes;
import model.SheetMusic;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    // Based on Json Demo
    public void testWriterInvalidFile() {
        try {
            SheetMusic sm = new SheetMusic("My sheetMusic");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Expecting to fail");
        } catch (IOException e) {
            // pass
        }

    }

    @Test
    // Based on Json Demo
    public void testWriterEmptySheetMusic() {
        try {
            SheetMusic sm = new SheetMusic("My sheet music");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySheetMusic.json");
            writer.open();
            writer.write(sm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySheetMusic.json");
            sm = reader.read();
            assertEquals("My sheet music", sm.getSheetMusicName());
            assertEquals(0, sm.getNoteListSize());
        } catch (IOException e) {
            fail("Not expecting to fail");
        }
    }

    @Test
    public void testWriterGeneralSheetMusic() {
        try {
            SheetMusic sm = new SheetMusic("My sheet music");
            sm.addNote(new Notes("a"));
            sm.addNote(new Notes("b"));
            sm.addNote(new Notes("a"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSheetMusic.json");
            writer.open();
            writer.write(sm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSheetMusic.json");
            sm = reader.read();
            assertEquals("My sheet music", sm.getSheetMusicName());
            List<Notes> notes = sm.viewMusicSheet();
            assertEquals(3, notes.size());
            checkNote("a", notes.get(0));
            checkNote("b", notes.get(1));
            checkNote("a", notes.get(2));

        } catch (IOException e) {
            fail("Not expecting to fail");
        } 
    }


}
