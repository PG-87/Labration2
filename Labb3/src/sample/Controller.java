package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    Canvas canvas;
    @FXML
    Button lineButton;

    Model model = new Model();
}
