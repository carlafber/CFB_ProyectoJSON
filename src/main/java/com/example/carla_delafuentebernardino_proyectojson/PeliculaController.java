package com.example.carla_delafuentebernardino_proyectojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void onPeliculaClick(MouseEvent mouseEvent) {
        Pelicula peli_selccionada = lst_peliculas.getSelectionModel().getSelectedItem();
        if (peli_selccionada == null) {
            Alerta.mensaje("Seleccione una película");
        } else {
            txt_titulo.setText(peli_selccionada.getTitulo());
            txt_fecha.setText(peli_selccionada.getFecha());
            txt_genero.setText(peli_selccionada.getGenero());
            txt_director.setText(peli_selccionada.getDirector());
        }
    }
}