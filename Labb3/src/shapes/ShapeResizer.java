package shapes;

import javafx.scene.paint.Paint;

public abstract class ShapeResizer extends Shapes {

private double resizeX;
private double resizeY;

    public ShapeResizer(Shapes shapes, double resizeX, double resizeY) {
        super(shapes);
        this.resizeX = resizeX;
        this.resizeY = resizeY;
    }
}
