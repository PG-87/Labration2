package sample.shapes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Square extends Shape {

    private DoubleProperty width = new SimpleDoubleProperty();
    private DoubleProperty height = new SimpleDoubleProperty();

    public Square(double xpos, double ypos, Color paint, String id, double width, double height, double size) {
        super(xpos, ypos, paint, id, size);
        this.height.setValue(height);
        this.width.setValue(width);
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
        gc.fillRect(getXpos() - getWidth()*0.5,
                    getYpos() - getHeight()*0.5,
                    getWidth()*getSize(),
                    getHeight()*getSize());
    }
    @Override
    public String saveToSvg() {
        return "<rect x=" + "\"" + (getXpos()-getWidth()*0.5) + "\"" + " " +
                "y=" + "\"" + (getYpos()-getHeight()*0.5) + "\"" + " " +
                "width=" + "\"" + getWidth()*getSize()+ "\"" + " " +
                "height=" + "\"" +getHeight()*getSize()+ "\"" + " " +
                "fill=" + "\"" + "#" + getPaint().toString().substring(2, 8) + "\"" + "/>";
    }
    @Override
    public String toString(){
        return getId() + " W: "+ String.format("%.1f",getWidth()*getSize()) + " H: " + String.format("%.1f",getHeight()*getSize());
    }
}
