package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Circle extends Shapes {

    private double radius;

    public Circle(double xpos, double ypos, double radius, Paint paint, String id) {
        super(xpos, ypos, paint, id);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getPaint());
        gc.fillOval(getXpos() - getRadius(), getYpos() - getRadius(), getRadius() * 2.0, getRadius() * 2.0);
    }
}
