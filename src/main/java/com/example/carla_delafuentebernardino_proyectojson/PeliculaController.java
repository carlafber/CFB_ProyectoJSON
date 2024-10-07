package com.example.carla_delafuentebernardino_proyectojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.ArrayList;

public class PeliculaController {

    @FXML
    private Button importar;

    @FXML
    private ListView<Pelicula> lst_peliculas;

    @FXML
    private TextField txt_director;

    @FXML
    private TextField txt_fecha;

    @FXML
    private TextField txt_genero;

    @FXML
    private TextField txt_titulo;

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();


    @FXML
    void onImportarClick(ActionEvent event) {
        try {
            ArrayList<Pelicula> peliculas =
                    JSON_MAPPER.readValue(new File("src/main/resources/Pelicula.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Pelicula.class));

            ObservableList<Pelicula> observablePeliculas = FXCollections.observableArrayList(peliculas);
            lst_peliculas.setItems(observablePeliculas);

            //lista.modeloseleccion().elementoseleccionado().reaccionacambios(observando, valoranterior, nuevovalor)->{});
            lst_peliculas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if(newValue != null) {
                    txt_titulo.setText(newValue.getTitulo());
                    txt_fecha.setText(newValue.getFecha());
                    txt_genero.setText(newValue.getGenero());
                    txt_director.setText(newValue.getDirector());
                }
            });

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
