package ui;

import model.Notes;
import model.SheetMusic;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.drawing.NoteShape;
import ui.drawing.SheetMusicDrawing;
import ui.tools.AddNoteTool;
import ui.tools.ClearTool;
import ui.tools.RemoveTool;
import ui.tools.Tool;
import ui.tools.menu.LoadToolClickHandler;
import ui.tools.menu.QuitToolClickHandler;
import ui.tools.menu.SaveToolClickHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicSheetEditor extends JFrame {
    //TODO: Some code based on SimpleDrawingPlayer

    private static final String JSON_STORE = "./data/sheetMusic.json";
    public static final int WIDTH = 1450;
    public static final int HEIGHT = 700;

    private List<Tool> tools;
    private Tool tool;
    private SheetMusicDrawing currDrawing;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static void main(String[] args) {
        new MusicSheetEditor();
    }

    // EFFECTS: Initializes MusicSheetEditor
    public MusicSheetEditor() {
        super("My Music Sheet");
        initializeFields();
        initializeInteraction();
        initializeFrame();

    }

    // MODIFIES: this
    // EFFECTS:  initializes a DrawingMouseListener to be used in the JFrame
    private void initializeInteraction() {
        DrawingMouseListener dml = new DrawingMouseListener();
        addMouseListener(dml);
        addMouseMotionListener(dml);
    }

    private void initializeFields() {
        tools = new ArrayList<>();
        tool = null;
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    private void initializeFrame() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        addNewDrawing();
        createTools();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addNewDrawing() {
        SheetMusicDrawing newDrawing = new SheetMusicDrawing("Music Sheet");
        currDrawing = newDrawing;
        add(newDrawing, BorderLayout.CENTER);
        validate();
    }


    // MODIFIES: this
    // EFFECTS:  sets the given tool as the activeTool
    public void setActiveTool(Tool activeTool) {
        if (tool != null) {
            tool.deactivate();
        }
        activeTool.activate();
        tool = activeTool;
    }

    // Code based on JSON demo
    // EFFECTS: loads sheet music from file
    public void loadMusicSheet() {
        try {
            currDrawing = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read file from: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: allows us to save music sheet
    public void saveMusicSheet() {
        try {
            jsonWriter.open();
            jsonWriter.write(currDrawing);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS:  a helper method which declares and instantiates all tools
    // Based on SimpleDrawingPlayer
    private void createTools() {
        JPanel toolArea = new JPanel();
        initializeMenuBar();

        toolArea.setLayout(new GridLayout(0, 1));
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BorderLayout.SOUTH);

        AddNoteTool addTool = new AddNoteTool(this, toolArea);
        tools.add(addTool);

        RemoveTool removeTool = new RemoveTool(this, toolArea);
        tools.add(removeTool);

        ClearTool clearTool = new ClearTool(this, toolArea);
        tools.add(clearTool);

        setActiveTool(addTool);
    }

    // MODIFIES: this
    // EFFECTS:  adds given Shape to currentDrawing
    public void addToDrawing(NoteShape f) {
        currDrawing.addShape(f);
    }

    // EFFECTS: Makes a MenuBar where you can save, open, and quit program
    private void initializeMenuBar() {
        JMenuBar jmb = new JMenuBar();
        super.setJMenuBar(jmb);
        JMenu file = new JMenu("File");
        jmb.add(file);

        JMenuItem open = new JMenuItem("Open Previous File");
        open.addActionListener(new LoadToolClickHandler(this));

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new SaveToolClickHandler(this));

        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new QuitToolClickHandler());

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(quit);
    }

    // EFFECTS: return notes at given point at the currentDrawing
    public NoteShape getShapeInDrawing(Point point) {
        return currDrawing.getShapesAtPoint(point);
    }

    // MODIFIES: this
    // EFFECTS:  removes note from currentDrawing
    public void removeFromDrawing(NoteShape f) {
        currDrawing.removeShape(f);
    }

    // MODIFIES: this
    // EFFECTS:  removes given Shape from currentDrawing
    public void clearNotesFromDrawing() {
        currDrawing.clearShapes();
    }


    // Code from SimpleDrawingEditor
    private class DrawingMouseListener extends MouseAdapter {

        // EFFECTS: Forward mouse pressed event to the active tool
        public void mousePressed(MouseEvent e) {
            handleMousePressed(translateEvent(e));
        }

        // EFFECTS: Forward mouse released event to the active tool
        public void mouseReleased(MouseEvent e) {
            handleMouseReleased(translateEvent(e));
        }

        // EFFECTS:Forward mouse clicked event to the active tool
        public void mouseClicked(MouseEvent e) {
            handleMouseClicked(translateEvent(e));
        }

        // EFFECTS: translates the mouse event to current drawing's coordinate system
        private MouseEvent translateEvent(MouseEvent e) {
            return SwingUtilities.convertMouseEvent(e.getComponent(), e, currDrawing);
        }
    }

    // EFFECTS: if activeTool != null, then mouseReleasedInDrawingArea is invoked on activeTool, depends on the
    //          type of the tool which is currently activeTool
    private void handleMouseReleased(MouseEvent e) {
        if (tool != null) {
            tool.mouseReleasedOnNote(e);
        }
        repaint();
    }

    // EFFECTS: if activeTool != null, then mouseClickedInDrawingArea is invoked on activeTool, depends on the
    //          type of the tool which is currently activeTool
    private void handleMouseClicked(MouseEvent e) {
        if (tool != null) {
            tool.mouseClickedOnNote(e);
        }
        repaint();
    }

    // EFFECTS: if activeTool != null, then mousePressedInDrawingArea is invoked on activeTool, depends on the
    //          type of the tool which is currently activeTool
    private void handleMousePressed(MouseEvent e) {
        if (tool != null) {
            tool.mousePressedOnNote(e);
        }
        repaint();
    }
}