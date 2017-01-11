package pkgfinal.project;

import DLibX.DConsole;
import java.awt.Color;

public class Structure {

    private double height;
    private double width;
    private double x;
    private double y;

    public Structure(double x, double y, double width, double height) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setX(double i) {
        x = i;
    }

    public void setY(double i) {
        y = i;
    }

    public void setWidth(double i) {
        width = i;
    }

    public void setHeight(double i) {
        height = i;
    }

    public void draw(DConsole dc) {
        dc.setPaint(Color.BLACK);
        dc.fillRect(this.x, this.y, this.width, this.height);
    }
}
