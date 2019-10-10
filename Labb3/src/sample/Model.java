package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shapes.Shapes;


public class Model {

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

    private ObservableList<Shapes> shapes = FXCollections.observableArrayList();
        public void setShapes(ObservableList<Shapes> shapes) {
            this.shapes = shapes;
        }
        public ObservableList<Shapes> getShapes() {
            return shapes;
        }
        public void addShapes (Shapes shape) {
        shapes.add(shape);
    }

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
