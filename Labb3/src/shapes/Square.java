package shapes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Square extends Shape {

    private DoubleProperty width = new SimpleDoubleProperty();
    private DoubleProperty height = new SimpleDoubleProperty();

    public Square(double xpos, double ypos, Paint paint, String id, double width, double height, double size) {
        super(xpos, ypos, paint, id, size);
        setHeight(height*getSize());
        setWidth(width*getSize());
    }

    @Override
    public void shapeResize(double size) {
        setHeight(getHeight()*size);
        setWidth(getWidth()*size);
    }

    public double getWidth() {
        return width.get();
    }
    public DoubleProperty widthProperty() {
        return width;
    }
    public void setWidth(double width) {
        this.width.set(width);
    }

    public double getHeight() {
        return height.get();
    }
    public DoubleProperty heightProperty() {
        return height;
    }
    public void setHeight(double height) {
        this.height.set(height);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(getPaint());
        gc.fillRect(getXpos() - getHeight()*0.5*getSize(),
                    getYpos() - getWidth()*0.5*getSize(),
                    getHeight()*getSize(),
                    getWidth()*getSize());
    }
    @Override
    public String saveToSvg() {
        return "<rect x=" + "\"" + (getXpos()-getHeight()*0.5) + "\"" + " " +
                "y=" + "\"" + (getYpos()-getWidth()*0.5) + "\"" + " " +
                "width=" + "\"" + getWidth()+ "\"" + " " +
                "height=" + "\"" +getHeight()+ "\"" + " " +
                "fill=" + "\"" + "#" + getPaint().toString().substring(2, 8) + "\"" + "/>";
    }
}
