package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String crm;
    private Especialidade especialidade;
    private List<Consulta> consultas;

    public Medico(String nome, String crm, Especialidade especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public void addConsulta(Consulta consulta) {
        if (!consultas.contains(consulta)) {
            consultas.add(consulta);
        }
    }

    public boolean isDisponivel(java.time.LocalDateTime horario) {
        for (Consulta c : consultas) {
            if (c.getHorario().equals(horario)) return false;
        }
        return true;
    }

    public List<Consulta> getConsultas() { return List.copyOf(consultas); }
    public String getNome() { return nome; }
    public String getCrm() { return crm; }
    public Especialidade getEspecialidade() { return especialidade; }

    @Override
    public String toString() { return nome + " - " + especialidade; }

    @Override
    public int hashCode() { return crm.hashCode(); }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Medico m) return m.getCrm().equals(crm);
        return false;
    }
}
