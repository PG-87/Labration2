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
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    @FXML
    Canvas canvas;
    @FXML
    TextField textField1;
    @FXML
    ColorPicker strokePicker;
    @FXML
    ColorPicker fillPicker;
    @FXML
    TextField brushSize;
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
        model.getShapes().addListener(this::onChanged);;
        listView.setItems(model.getShapes());
        listView.getItems().addListener(this::onChanged);
    }

    public void onChanged(ListChangeListener.Change<? extends Shape> c){
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
            System.out.println(model.getShapes());
        });
    }
    public void squareButtonAction(ActionEvent actionEvent) {
        canvas.setOnMouseClicked(e-> {
            y = e.getY();
            x = e.getX();
            Square square = new Square(x,y, fillPicker.getValue(), "Square", 10, 10, slider.getValue());
            model.addShapes(square);
            System.out.println(model.getShapes());
        });
    }
    public void cirkelButtonAction(ActionEvent actionEvent) {
        canvas.setOnMouseClicked(e-> {
           y = e.getY();
           x = e.getX();
            Circle circ = new Circle(x,y,fillPicker.getValue(), "Circle", 10, slider.getValue());
            model.addShapes(circ);
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
        try (FileWriter out = new FileWriter(path)){
            out.write("<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                    "<svg width=\"410\" height=\"640\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">" +"\n");
            for (Shape shape : model.getShapes()) {
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
//        try (FileReader in = new FileReader(path)){
//            in.read()
//        }
    }

    //ToDo implentera undo och redo
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
                            model.getShapes().remove(model.getShapes().size()-1);
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
        listView.setOnMouseClicked(e-> {
        Shape selectedShape = ((Shape)listView.getSelectionModel().getSelectedItem());
        selectedShape.shapeResize(slider.getValue());
        new ShapeRecoloring((Shape)listView.getSelectionModel().getSelectedItem(),fillPicker.getValue());
        drawShapes();
        });
    }
    public void drawShapes(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        for (Shape shape : model.getShapes()){
                shape.draw(gc);
        }
    }

    public void newFile(ActionEvent actionEvent) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        model.getShapes().removeAll(model.getShapes());
        }
}

