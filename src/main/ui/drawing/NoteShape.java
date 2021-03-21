package ui.drawing;


import com.sun.javafx.geom.Shape;
import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;

//TODO: Some code based on Simple Drawing Player
public class NoteShape implements Writable {

    private int x1;
    private int y1;
    private int width;
    private int height;

    public NoteShape(Point center, int w, int h) {
        this((int) center.getX(), (int) center.getY(), w, h);
        this.height = h;
        this.width = w;
    }

    public NoteShape(int x, int y, int w, int h) {
        this.x1 = x;
        this.y1 = y;
        width = w;
        height = h;
    }

    // EFFECTS: draws this Shape on the SimpleDrawingPlayer, if the shape is selected, Shape is filled in
    //          else, Shape is unfilled (white)
    public void draw(Graphics g) {
        Color save = g.getColor();

        fillGraphics(g);
        g.setColor(save);
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

    // EFFECTS: return true iff the given x value is within the bounds of the Shape
    public boolean containsX(int x) {
        return (this.x1 <= x) && (x <= this.x1 + width);
    }

    // EFFECTS: return true iff the given y value is within the bounds of the Shape
    public boolean containsY(int y) {
        return (this.y1 <= y) && (y <= this.y1 + height);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    public boolean contains(Point point) {
        int pointx = point.x;
        int pointy = point.y;

        return containsX(pointx) && containsY(pointy);
    }

    // MODIFIES: this
    // EFFECTS:  adds dx to the shapes x coordinate, and dy to the shapes y coordinate.
    public void move(int dx, int dy) {
        x1 += dx;
        y1 += dy;
    }

    // getters

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("x-position", x1);
        json.put("y-position", y1);
        json.put("width", width);
        json.put("height", height);
        return json;
    }
}

