package ui.drawing;


import com.sun.javafx.geom.Shape;

import java.awt.*;

//TODO: Some code based on Simple Drawing Player
public class NoteShape {

    private int x1;
    private int y1;
    private int width;
    private int height;

    private int playLineCoord;

    public NoteShape(Point center, int w, int h) {
        this((int) center.getX(), (int) center.getY(), w, h);
        this.height = h;
        this.width = w;
        playLineCoord = 0;
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

        if (playLineCoord > 0 && playLineCoord < width) {
            g.setColor(Color.red);
            g.drawLine(x1 + playLineCoord, y1, x1 + playLineCoord, y1 + height);
            g.setColor(save);
        }
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

}

