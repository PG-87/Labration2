package StackOperations;

import javafx.scene.paint.Color;
import sample.shapes.Shape;

public class UndoOperation implements Change {

    private Shape shape;
    private final Color paint;
    private double size;

    public UndoOperation(Shape oldShape, double oldSize, Color oldPaint) {
        this.shape = oldShape;
        this.paint = oldPaint;
        this.size = oldSize;
    }

    @Override
    public void undo() {
    shape.setSize(size);
    shape.setPaint(paint);
    }
}