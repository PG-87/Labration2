package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Circle extends Shape {

    private double radius;

    public Circle(double xpos, double ypos, Paint paint, String id, double radius, double size) {
        super(xpos, ypos, paint, id, size);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getPaint());
        gc.fillOval(getXpos() - getRadius()*getSize(), getYpos() - getRadius()*getSize(), getRadius() * 2.0*getSize(), getRadius() * 2.0*getSize());
    }
}
