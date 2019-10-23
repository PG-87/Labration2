package sample;

import StackOperations.Change;
import StackOperations.UndoOperation;
import StackOperations.UndoShape;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.shapes.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Controller {

    @FXML
    Canvas canvas;
    @FXML
    ColorPicker fillPicker;
    @FXML
    Button rectangleButton;
    @FXML
    Button squareButton;
    @FXML
    Button circleButton;
    @FXML
    MenuItem newItem;
    @FXML
    MenuItem saveMenuItem;
    @FXML
    MenuItem openMenuItem;
    @FXML
    Slider slider;
    @FXML
    ListView listView;

    private GraphicsContext gc;
    private Model model;
    private Stage stage;
    private Shape shape;
    private double x, y;

    public Controller (Model model){
        this.model = model;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(){
        gc = canvas.getGraphicsContext2D();
        fillPicker.setValue(Color.BLACK);
        model.getShapeList().addListener(this::onChanged);;
        listView.setItems(model.getShapeList());
        listView.getItems().addListener(this::onChanged);
        model.sizeProperty().bind(slider.valueProperty());
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Shape>() {
            @Override
            public void changed(ObservableValue<? extends Shape> observable, Shape oldValue, Shape newValue) {
                if (oldValue != null){
                    (oldValue).sizeProperty().unbindBidirectional(slider.valueProperty());
                    (oldValue).paintProperty().unbindBidirectional(fillPicker.valueProperty());
                }
                if (newValue != null) {
                    slider.setValue(newValue.getSize());
                    slider.valueProperty().bindBidirectional((newValue).sizeProperty());
                    fillPicker.setValue(newValue.getPaint());
                    fillPicker.valueProperty().bindBidirectional((newValue).paintProperty());
                    shape = (newValue);
                }
            }});
    }

    public void onChanged(ListChangeListener.Change<? extends Shape> c){
        while (c.next()) {
            if (c.wasPermutated()) {
                for (int i = c.getFrom(); i < c.getTo(); ++i) {
                    System.out.println("Permuted: " + i + " " + model.getShapeList().get(i));
                }
            } else if (c.wasUpdated()) {
                for (int i = c.getFrom(); i < c.getTo(); ++i) {
                    System.out.println("Updated: " + i + " " + model.getShapeList().get(i));
                }
            } else {
                for (Shape removedItem : c.getRemoved()) {
                    System.out.println("Removed: " + removedItem);
                }
                for (Shape addedItem : c.getAddedSubList()) {
                    System.out.println("Added: " + addedItem);
                }
            }
        }
        drawShapes();
    }

    public void rectangleButtonAction(ActionEvent actionEvent) {
        canvas.setOnMouseClicked(e-> {
            y = e.getY();
            x = e.getX();
            Square rect = new Square(x,y, fillPicker.getValue(), "Rectangle", 20, 10, slider.getValue());
            model.addShapes(rect);
            Model.undoStack.push(new UndoShape(model.getShapeList(), rect));
        });
    }
    public void squareButtonAction(ActionEvent actionEvent) {
        canvas.setOnMouseClicked(e-> {
            y = e.getY();
            x = e.getX();
            Square square = new Square(x,y, fillPicker.getValue(), "Square", 10, 10, slider.getValue());
            model.addShapes(square);
            Model.undoStack.push(new UndoShape(model.getShapeList(), square));

        });
    }
    public void circleButtonAction(ActionEvent actionEvent) {
        canvas.setOnMouseClicked(e-> {
           y = e.getY();
           x = e.getX();
            Circle circ = new Circle(x,y,fillPicker.getValue(), "Circle", 10, slider.getValue());
            model.addShapes(circ);
            Model.undoStack.push(new UndoShape(model.getShapeList(), circ));
        });
    }

    public void newFile(ActionEvent actionEvent) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        model.getShapeList().removeAll(model.getShapeList());
        Model.undoStack.clear();
    }
    public void saveFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+File.separator + "Documents"));
        fileChooser.setTitle("Save File");
        fileChooser.setInitialFileName("Svg Labration3");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".svg", "*.svg"),
                new FileChooser.ExtensionFilter("All files", "*.*"));
        File path = fileChooser.showSaveDialog(stage);
        try (FileWriter out = new FileWriter(path)){
            out.write("<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                    "<svg width=\""+canvas.getWidth()+"\" height=\""+canvas.getHeight()+"\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">" +"\n");
            for (Shape shape : model.getShapeList()) {
                out.write(shape.saveToSvg() +"\n");
            }
            out.write("\n"+"</svg>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "*.*"),
                new FileChooser.ExtensionFilter(".svg", "*.svg"));
        File path = fileChooser.showOpenDialog(stage);
    }

    public void undoCmd(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED,
                new EventHandler<KeyEvent>() {
                    final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z,
                            KeyCombination.CONTROL_DOWN);
                    final KeyCombination ctrlShiftZ = new KeyCodeCombination(KeyCode.Z,
                            KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);

                    public void handle(KeyEvent ke) {
                        if (ctrlZ.match(ke)) {
                            if(!Model.undoStack.empty())
                            Model.undoStack.pop().undo();
                            System.out.println("Undo");
                            ke.consume(); // <-- stops passing the event to next node
                        } else if (ctrlShiftZ.match(ke)) {
                            //Redo
                            System.out.println("Redo");
                            ke.consume();
                        }
                    }
                });
    }
    public void sliderChange(MouseEvent contextMenuEvent) {
        if (shape != null)
        Model.undoStack.push(new UndoOperation(shape, shape.getSize(), shape.getPaint() ));
    }
    public void colorChange(Event event) {
        Model.undoStack.push(new UndoOperation(shape, shape.getSize(), shape.getPaint() ));
    }

    public void drawShapes(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        for (Shape shape : model.getShapeList()){
            shape.draw(gc);
        }
    }
}

