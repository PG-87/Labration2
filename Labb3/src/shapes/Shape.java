package shapes;

import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Shape implements ShapeResize {

    private DoubleProperty xpos = new SimpleDoubleProperty();
    private DoubleProperty ypos = new SimpleDoubleProperty();
    private ObjectProperty<Paint> paint = new SimpleObjectProperty<>();
    private StringProperty id = new SimpleStringProperty();
    private DoubleProperty size = new SimpleDoubleProperty();

    public Shape(double xpos, double ypos, Paint paint, String id, double size) {
        setXpos(xpos);
        setYpos(ypos);
        setPaint(paint);
        setId(id);
        setSize(size);
    }

    public double getSize() {
        return size.get();
    }
    public DoubleProperty sizeProperty() {
        return size;
    }
    public void setSize(double size) {
        this.size.set(size);
    }

    public double getXpos() {
        return xpos.get();
    }
    public DoubleProperty xposProperty() {
        return xpos;
    }
    public void setXpos(double xpos) {
        this.xpos.set(xpos);
    }

    public double getYpos() {
        return ypos.get();
    }
    public DoubleProperty yposProperty() {
        return ypos;
    }
    public void setYpos(double ypos) {
        this.ypos.set(ypos);
    }

    public Paint getPaint() {
        return paint.get();
    }
    public ObjectProperty<Paint> paintProperty() {
        return paint;
    }
    public void setPaint(Paint paint) {
        this.paint.set(paint);
    }

    public String getId() {
        return id.get();
    }
    public StringProperty idProperty() {
        return id;
    }
    public void setId(String id) {
        this.id.set(id);
    }

    public void draw(GraphicsContext gc){}

    public String toString() {
        return getId() +" Size: "+ getSize();
    }
    public String saveToSvg() {
        return null;
    }
}
