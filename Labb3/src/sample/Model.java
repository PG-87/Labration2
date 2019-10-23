package sample;



import StackOperations.Change;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import sample.shapes.Shape;

import java.util.Stack;


public class Model {

    public static Stack<Change> undoStack = new Stack();

    private StringProperty text = new SimpleStringProperty();

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    private ObservableList<Shape> shapeList = FXCollections.observableArrayList(new Callback<Shape, Observable[]>() {
        @Override
        public Observable[] call(sample.shapes.Shape param) {
            return new Observable[]{
                    param.idProperty(),
                    param.paintProperty(),
                    param.sizeProperty()
            };
        }
    });

    public void setShapeList(ObservableList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public ObservableList<Shape> getShapeList() {
        return shapeList;
    }

    public void addShapes(Shape shape) {
        shapeList.add(shape);
    }

    private Stack<Shape> stackShapes = new Stack<>();

    private StringProperty selectedItem = new SimpleStringProperty();

    public String getSelectedItem() {
        return selectedItem.get();
    }

    public StringProperty selectedItemProperty() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem.set(selectedItem);
    }

    private IntegerProperty size = new SimpleIntegerProperty();

    public int getSize() {
        return size.get();
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public void setSize(int size) {
        this.size.set(size);
    }
}
