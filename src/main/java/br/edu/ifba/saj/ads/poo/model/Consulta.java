package br.edu.ifba.saj.ads.poo.model;

import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime horario;
    private Medico medico;
    private Paciente paciente;

    public Consulta(LocalDateTime horario, Medico medico, Paciente paciente) {
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        medico.addConsulta(this);
        paciente.addConsulta(this);
    }

    public LocalDateTime getHorario() { return horario; }
    public Medico getMedico() { return medico; }
    public Paciente getPaciente() { return paciente; }

    @Override
    public String toString() {
        return String.format("%s com Dr. %s em %2$td/%2$tm/%2$tY %2$tH:%2$tM",
            paciente.getNome(), medico, horario);
    }

    @Override
    public int hashCode() {
        return horario.hashCode() + medico.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Consulta c) {
            return c.getHorario().equals(horario) && c.getMedico().equals(medico);
        }
        return false;
    }
}
