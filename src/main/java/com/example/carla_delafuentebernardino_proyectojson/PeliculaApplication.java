package com.example.carla_delafuentebernardino_proyectojson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PeliculaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PeliculaApplication.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PELÍCULAS");
        stage.setScene(scene);
        stage.show();
    }
    static ArrayList<Pelicula> peliculas;
    public static void main(String[] args) {


        launch();
    }
}