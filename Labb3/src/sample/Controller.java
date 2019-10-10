package sample;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
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
import shapes.*;
import java.io.File;

public class Controller {

    @FXML
    Canvas canvas;
    @FXML
    ColorPicker strokePicker;
    @FXML
    ColorPicker fillPicker;
    @FXML
    TextField brushSize;
    @FXML
    Button rectangleButton;
    @FXML
    MenuItem saveMenuItem;
    @FXML
    MenuItem openMenuItem;
    @FXML
    Slider slider;
    @FXML
    ListView listView;

    GraphicsContext gc;
    Model model;
    Stage stage;

    private double x, y;

    public Controller (Model model){
        this.model = model;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(){
        gc = canvas.getGraphicsContext2D();
        strokePicker.setValue(Color.BLACK);
        canvas.widthProperty().addListener(observable -> Controller.this.drawShapes());
        canvas.heightProperty().addListener(observable -> drawShapes());
        model.getShapes().addListener(this::onChanged);
        listView.setItems(model.getShapes());
    }

    public void onChanged(ListChangeListener.Change<? extends Shapes> c){
        while (c.next()) {
            if (c.wasPermutated()) {
                for (int i = c.getFrom(); i < c.getTo(); ++i) {
                    System.out.println("Permuted: " + i + " " + model.getShapes().get(i));
                }
            } else if (c.wasUpdated()) {
                for (int i = c.getFrom(); i < c.getTo(); ++i) {
                    System.out.println("Updated: " + i + " " + model.getShapes().get(i));
                }
            } else {
                for (Shapes removedItem : c.getRemoved()) {
                    System.out.println("Removed: " + removedItem);
                }
                for (Shapes addedItem : c.getAddedSubList()) {
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
            Rectangle rect = new Rectangle(x,y,100,200, fillPicker.getValue(), "Rectangle");
            model.getShapes().add(rect);
            System.out.println(model.getShapes());
        });
    }

    public void cirkelButtonAction(ActionEvent actionEvent) {
        canvas.setOnMouseClicked(e-> {
           y = e.getY();
           x = e.getX();
            Circle circ = new Circle(x,y,10,fillPicker.getValue(), "Circle");
            model.getShapes().add(circ);
            System.out.println(model.getShapes());
        });
    }

    public void saveFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "*.*"),
                new FileChooser.ExtensionFilter(".svg", "*.svg"));
        File path = fileChooser.showSaveDialog(stage);
    }

    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "*.*"),
                new FileChooser.ExtensionFilter(".svg", "*.svg"));
        File path = fileChooser.showOpenDialog(stage);
    }

    public void init(Scene scene) {
        //Capture Ctrl-Z for undo
        scene.addEventFilter(KeyEvent.KEY_PRESSED,
                new EventHandler<KeyEvent>() {
                    final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z,
                            KeyCombination.CONTROL_DOWN);
                    final KeyCombination ctrlShiftZ = new KeyCodeCombination(KeyCode.Z,
                            KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);

                    public void handle(KeyEvent ke) {
                        if (ctrlZ.match(ke)) {
                            //Undo
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

    public void selectedShape(MouseEvent mouseEvent) {

    }
    public void drawShapes(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getHeight(), canvas.getWidth());
        for (Shapes shapes : model.getShapes()){
                shapes.draw(gc);
        }

    }
}
