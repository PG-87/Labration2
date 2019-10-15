package shapes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Circle extends Shape {

    private DoubleProperty radius = new SimpleDoubleProperty();

    public Circle(double xpos, double ypos, Paint paint, String id, double radius, double size) {
        super(xpos, ypos, paint, id, size);
        setRadius(radius);
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
        gc.fillOval(getXpos() - getRadius() * getSize(), getYpos() - getRadius() * getSize(), getRadius() * 2.0 * getSize(), getRadius() * 2.0 * getSize());
    }

    @Override
    public String toString() {
        return "<circle cx=" + "\"" + getXpos() + "\"" + " " + "cy=" + "\"" + getYpos() + "\"" + " " + "r=" + "\"" + getRadius() + "\"" + " " + "fill=" + "\"" + "#" + getPaint().toString().substring(2, 8) + "\"" + "/>";

    }
}
