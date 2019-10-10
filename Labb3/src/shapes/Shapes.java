package shapes;

import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Shapes {

    private DoubleProperty xpos = new SimpleDoubleProperty();
    private DoubleProperty ypos = new SimpleDoubleProperty();
    private ObjectProperty<Paint> paint = new SimpleObjectProperty<>();
    private StringProperty id = new SimpleStringProperty();

    public Shapes(double xpos, double ypos, Paint paint, String id) {
        setXpos(xpos);
        setYpos(ypos);
        setPaint(paint);
        setId(id);
    }

    public Shapes(Shapes shapes) {
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
    public abstract void draw(GraphicsContext gc);

    @Override
    public String toString() {
        return getId();
    }
}
