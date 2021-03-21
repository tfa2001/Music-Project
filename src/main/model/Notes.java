package model;

import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;

public class Notes implements Writable {

    private String letter;
    private int x1;
    private int y1;
    private int width;
    private int height;
    private Point center;

    /* REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G";
     * EFFECTS: letter note is set to noteName;
     */
    public Notes(Point center, int w, int h) {
        this((int) center.getX(), (int) center.getY(), w, h);
        this.height = h;
        this.width = w;
        this.center = center;
    }

    public Notes(int x, int y, int w, int h) {
        this.x1 = x;
        this.y1 = y;
        width = w;
        height = h;
    }

    public Notes(String noteName, int w, int h) {
        this.letter = noteName;
        this.height = h;
        this.width = w;
    }

    // REQUIRES: letter must be one of "A", "B", "C", "D", "E", "F", or "G"
    // getter
    public String getNoteName() {
        return letter;
    }

    public Point getPoint() {
        return center;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    @Override
    // Code based on Json Demo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("noteName", letter);
        json.put("width", width);
        json.put("height", height);
        return json;
    }

}
