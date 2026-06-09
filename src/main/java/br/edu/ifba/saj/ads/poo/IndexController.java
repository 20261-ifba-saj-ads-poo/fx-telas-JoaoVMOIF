package br.edu.ifba.saj.ads.poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class IndexController {

    @FXML private BorderPane pane;

    @FXML
    public void abrirCadastrarMedico(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Medico.fxml")));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    public void abrirAgendarConsulta(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Consulta.fxml")));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    public void abrirVisualizarConsultas(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Visualizar.fxml")));
        } catch (Exception e) { e.printStackTrace(); }
    }
}
