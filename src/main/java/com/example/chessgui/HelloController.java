package com.example.chessgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML private ImageView wPawn4;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onPawnClick(){
        wPawn4.setY(wPawn4.getY()-50);
    }
}