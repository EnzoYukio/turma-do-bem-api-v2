package br.com.fiap.entities;

public class Procedimento {
    private int Idprocedimento;
    private String nomeProcedimento;
    private int id;
    private String tecnica;
    private double valorBase;

    public Procedimento() {
    }

    public Procedimento(int idprocedimento, String nomeProcedimento, int id, String tecnica, double valorBase) {
        Idprocedimento = idprocedimento;
        this.nomeProcedimento = nomeProcedimento;
        this.id = id;
        this.tecnica = tecnica;
        this.valorBase = valorBase;
    }

    public int getIdprocedimento() {
        return Idprocedimento;
    }

    public void setIdprocedimento(int idprocedimento) {
        Idprocedimento = idprocedimento;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    @Override
    public String toString() {
        return "Procedimento{" +
                "\nIdprocedimento=" + Idprocedimento +
                "\nnomeProcedimento='" + nomeProcedimento + '\'' +
                "\nid=" + id +
                "\ntecnica='" + tecnica + '\'' +
                "\nvalorBase=" + valorBase;
    }
}