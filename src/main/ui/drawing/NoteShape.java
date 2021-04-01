package ui.drawing;

import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;

//TODO: Some code based on Simple Drawing Player
public class NoteShape implements Writable {
    public static final int NOTE_WIDTH = 40;
    public static final int NOTE_HEIGHT = 25;

    private int x1;
    private int y1;
    private int width;
    private int height;

    // EFFECTS: creates a note
    public NoteShape(Point center, int w, int h) {
        this((int) center.getX(), (int) center.getY(), w, h);
        this.height = h;
        this.width = w;
    }

    // EFFECTS: creates a note
    public NoteShape(int x, int y, int w, int h) {
        this.x1 = x;
        this.y1 = y;
        width = w;
        height = h;
    }

    // EFFECTS: draws this Shape on the SimpleDrawingPlayer, if the shape is selected, Shape is filled in
    //          else, Shape is unfilled (white)
    public void draw(Graphics g) {
        Color c = g.getColor();
        fillGraphics(g);
        g.setColor(c);
        drawGraphics(g);
    }

    //EFFECTS: draws the shape
    private void drawGraphics(Graphics g) {
        g.drawOval(x1, y1, width, height);
    }

    //EFFECTS: fills the shape
    private void fillGraphics(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(x1, y1, width, height);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    public boolean contains(Point point) {
        int x = point.x;
        int y = point.y;
        return (this.x1 <= x) && (x <= this.x1 + width) && (this.y1 <= y) && (y <= this.y1 + height);
    }

    // MODIFIES: this
    // EFFECTS:  adds dx to the shapes x coordinate, and dy to the shapes y coordinate.
    public void move(int dx, int dy) {
        x1 = x1 + dx;
        y1 = y1 + dy;
    }

    // getter
    public int getX1() {
        return x1;
    }

    // getter
    public int getY1() {
        return y1;
    }

    @Override
    // EFFECTS: returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("x-position", x1);
        json.put("y-position", y1);
        json.put("width", width);
        json.put("height", height);
        return json;
    }
}

