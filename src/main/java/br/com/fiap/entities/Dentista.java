package br.com.fiap.entities;

public class Dentista {
    private String nome;
    private String cpf;
    private String especialidade;
    private int Iddentista;
    private String cro;

    public Dentista() {
    }

    public Dentista(String nome, String cpf, String especialidade, int iddentista, String cro) {
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        Iddentista = iddentista;
        this.cro = cro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getIddentista() {
        return Iddentista;
    }

    public void setIddentista(int iddentista) {
        Iddentista = iddentista;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "\nnome='" + nome + '\'' +
                "\ncpf='" + cpf + '\'' +
                "\nespecialidade='" + especialidade + '\'' +
                "\nIddentista=" + Iddentista +
                "\ncro='" + cro;
    }
}