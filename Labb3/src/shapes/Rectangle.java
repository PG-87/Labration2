package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Rectangle extends Shapes {

    private final double width;
    private final double height;

    public Rectangle(double xpos, double ypos, double height, double width, Paint paint, String id) {
        super(xpos, ypos, paint, id);
        this.height = height;
        this.width = width;

    }
    public void draw(GraphicsContext gc){
        gc.setFill(getPaint());
        gc.fillRect(getXpos() - height*0.5,getYpos() - width*0.5, height, width);
    }
}
