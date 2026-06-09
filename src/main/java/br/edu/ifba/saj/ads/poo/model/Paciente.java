package br.edu.ifba.saj.ads.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private List<Consulta> consultas;

    public Paciente(String nome, String cpf, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.consultas = new ArrayList<>();
    }

    public void addConsulta(Consulta consulta) { consultas.add(consulta); }
    public List<Consulta> getConsultas() { return List.copyOf(consultas); }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDate getNascimento() { return nascimento; }

    @Override
    public String toString() { return nome + " (" + cpf + ")"; }
}
