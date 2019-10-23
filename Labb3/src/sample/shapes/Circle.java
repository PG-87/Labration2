package sample.shapes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    private DoubleProperty radius = new SimpleDoubleProperty();

    public Circle(double xpos, double ypos, Color paint, String id, double radius, double size) {
        super(xpos, ypos, paint, id, size);
        this.radius.setValue(radius);
    }

    public double getRadius() {
        return radius.get();
    }
    public DoubleProperty radiusProperty() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius.set(radius);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getPaint());
        gc.fillOval(getXpos() - getRadius() * getSize(),
                getYpos() - getRadius() * getSize(),
                getRadius() * 2.0 * getSize(),
                getRadius() * 2.0 * getSize());
    }

    @Override
    public String saveToSvg() {
        return "<circle cx=" + "\"" + getXpos() + "\"" + " " +
                "cy=" + "\"" + getYpos() + "\"" + " " +
                "r=" + "\"" + getRadius()*getSize() + "\"" + " " +
                "fill=" + "\"" + "#" + getPaint().toString().substring(2, 8) + "\"" + "/>";
    }
    @Override
        public String toString(){
            return getId() + " " + String.format("%.1f",getRadius()*getSize());
}
}
