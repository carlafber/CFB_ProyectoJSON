package com.example.carla_delafuentebernardino_proyectojson;

import javafx.scene.control.Alert;

public class Alerta {
    public static void mensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
