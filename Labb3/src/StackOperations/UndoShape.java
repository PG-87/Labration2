package StackOperations;

import javafx.collections.ObservableList;
import sample.shapes.Shape;

public class UndoShape implements Change {

    private final ObservableList<Shape> undoShape;
    private Shape shape;

    public UndoShape(ObservableList<Shape> undoShape, Shape shape) {
        this.undoShape = undoShape;
        this.shape = shape;
    }

    @Override
    public void undo() {
        undoShape.remove(shape);
    }
}
