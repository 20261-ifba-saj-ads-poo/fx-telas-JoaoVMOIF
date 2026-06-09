package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.data.ClinicaData;
import br.edu.ifba.saj.ads.poo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConsultaController {

    @FXML private ChoiceBox<Medico> slMedico;
    @FXML private TextField txNomePaciente;
    @FXML private TextField txCpfPaciente;
    @FXML private DatePicker dtConsulta;
    @FXML private Spinner<Integer> spHora;
    @FXML private Spinner<Integer> spMinuto;

    @FXML
    private void initialize() {
        slMedico.getItems().addAll(ClinicaData.medicos);

        slMedico.setConverter(new StringConverter<>() {
            @Override public String toString(Medico m) {
                return m == null ? "" : m.getNome() + " - " + m.getEspecialidade();
            }
            @Override public Medico fromString(String s) { return null; }
        });
    }

    @FXML
    void salvar(ActionEvent event) {
        Medico medico = slMedico.getValue();
        LocalDate data = dtConsulta.getValue();

        if (medico == null || data == null
         || txNomePaciente.getText().isEmpty()
         || txCpfPaciente.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Preencha todos os campos!").showAndWait();
            return;
        }

        LocalDateTime horario = LocalDateTime.of(
            data, LocalTime.of(spHora.getValue(), spMinuto.getValue())
        );

        if (!medico.isDisponivel(horario)) {
            new Alert(Alert.AlertType.ERROR,
                "Médico indisponível nesse horário!").showAndWait();
            return;
        }

        Paciente paciente = new Paciente(
            txNomePaciente.getText(),
            txCpfPaciente.getText(),
            LocalDate.of(1990, 1, 1)
        );

        Consulta consulta = new Consulta(horario, medico, paciente);

        new Alert(Alert.AlertType.INFORMATION,
            String.format("Consulta agendada!\nMédico: Dr(a). %s\nPaciente: %s\nData: %2$td/%2$tm/%2$tY %2$tH:%2$tM",
                medico.getNome(), paciente.getNome(), horario)).showAndWait();
    }
}
