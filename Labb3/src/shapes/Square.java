package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Square extends Shape {

    private final double width;
    private final double height;

    public Square(double xpos, double ypos, Paint paint, String id, double height, double width, double size) {
        super(xpos, ypos, paint, id, size);
        this.width = width;
        this.height = height;

    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(getPaint());
        gc.fillRect(getXpos() - height*0.5*getSize(),getYpos() - width*0.5*getSize(), height*getSize(), width*getSize());
    }
}
