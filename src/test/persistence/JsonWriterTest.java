package persistence;

import model.SheetMusic;
import org.junit.jupiter.api.Test;
import ui.drawing.NoteShape;
import ui.drawing.SheetMusicDrawing;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    private static final int width = 50;
    private static final int height = 30;

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
            SheetMusicDrawing sm = new SheetMusicDrawing("My sheet music");
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
            SheetMusicDrawing sm = new SheetMusicDrawing("My sheet music");
            sm.addNote(new NoteShape(50, 20, width, height));
            sm.addNote(new NoteShape(10, 20, width, height));
            sm.addNote(new NoteShape(50, 10, width, height));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSheetMusic.json");
            writer.open();
            writer.write(sm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSheetMusic.json");
            sm = reader.read();
            assertEquals("My sheet music", sm.getSheetMusicName());
            List<NoteShape> notes = sm.viewMusicSheet();
            assertEquals(3, notes.size());
            checkNote(50, 20, notes.get(0));
            checkNote(10, 20,notes.get(1));
            checkNote(50, 10, notes.get(2));

        } catch (IOException e) {
            fail("Not expecting to fail");
        } 
    }


}
