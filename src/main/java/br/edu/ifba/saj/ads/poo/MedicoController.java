package br.edu.ifba.saj.ads.poo;

import java.util.Objects;
import br.edu.ifba.saj.ads.poo.data.ClinicaData;
import br.edu.ifba.saj.ads.poo.model.Especialidade;
import br.edu.ifba.saj.ads.poo.model.Medico;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicoController {

    @FXML private TextField txNome;
    @FXML private TextField txCrm;
    @FXML private ChoiceBox<Especialidade> slEspecialidade;
    @FXML private TableView<Medico> tbMedicos;
    @FXML private TableColumn<Medico, String> clmNome;
    @FXML private TableColumn<Medico, String> clmCrm;
    @FXML private TableColumn<Medico, Especialidade> clmEspecialidade;

    @FXML
    private void initialize() {
        clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clmCrm.setCellValueFactory(new PropertyValueFactory<>("crm"));
        clmEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        slEspecialidade.getItems().addAll(Especialidade.values());
        loadList();
        Platform.runLater(() -> txNome.requestFocus());
    }

    public void loadList() {
        tbMedicos.setItems(FXCollections.observableList(ClinicaData.medicos));
    }

    @FXML
    void salvar(ActionEvent event) {
        if (Objects.nonNull(txNome.getText()) && !txNome.getText().isEmpty()
         && Objects.nonNull(txCrm.getText()) && !txCrm.getText().isEmpty()
         && slEspecialidade.getValue() != null) {

            Medico medico = new Medico(txNome.getText(), txCrm.getText(), slEspecialidade.getValue());
            ClinicaData.medicos.add(medico);
            new Alert(Alert.AlertType.INFORMATION,
                "Dr(a). " + medico.getNome() + " cadastrado(a)!").showAndWait();
            txNome.clear();
            txCrm.clear();
        } else {
            new Alert(Alert.AlertType.ERROR, "Preencha todos os campos!").showAndWait();
        }
        loadList();
    }
}
