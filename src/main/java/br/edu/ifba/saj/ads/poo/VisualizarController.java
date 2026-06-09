package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.data.ClinicaData;
import br.edu.ifba.saj.ads.poo.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

public class VisualizarController {

    @FXML private ChoiceBox<Medico> slMedico;
    @FXML private TableView<Consulta> tbConsultas;
    @FXML private TableColumn<Consulta, String> clmPaciente;
    @FXML private TableColumn<Consulta, String> clmHorario;

    @FXML
    private void initialize() {
        slMedico.getItems().addAll(ClinicaData.medicos);

        slMedico.setConverter(new StringConverter<>() {
            @Override public String toString(Medico m) {
                return m == null ? "" : m.getNome() + " - " + m.getEspecialidade();
            }
            @Override public Medico fromString(String s) { return null; }
        });

        clmPaciente.setCellValueFactory(data ->
            new javafx.beans.property.SimpleStringProperty(
                data.getValue().getPaciente().getNome()
            )
        );

        clmHorario.setCellValueFactory(data ->
            new javafx.beans.property.SimpleStringProperty(
                String.format("%1$td/%1$tm/%1$tY %1$tH:%1$tM",
                    data.getValue().getHorario())
            )
        );

        slMedico.getSelectionModel().selectedItemProperty()
            .addListener((obs, old, novo) -> {
                if (novo != null) {
                    tbConsultas.setItems(
                        FXCollections.observableList(novo.getConsultas())
                    );
                }
            });
    }
}
