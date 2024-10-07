package com.example.carla_delafuentebernardino_proyectojson;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PeliculaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}