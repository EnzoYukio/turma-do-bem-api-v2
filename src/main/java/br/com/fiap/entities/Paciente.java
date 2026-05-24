package br.com.fiap.entities;

public class Paciente {
    private String nome;
    private int id;
    private String cpf;
    private String email;
    private String telefone;
    private String CodigoQR;
    private int idendereco;
    private String endereco;
    private String dentista;

    public Paciente() {
    }

    public Paciente(String nome, int id, String cpf, String email, String telefone, String codigoQR, int idendereco, String endereco, String dentista) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        CodigoQR = codigoQR;
        this.idendereco = idendereco;
        this.endereco = endereco;
        this.dentista = dentista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCodigoQR() {
        return CodigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        CodigoQR = codigoQR;
    }

    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDentista() {
        return dentista;
    }

    public void setDentista(String dentista) {
        this.dentista = dentista;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "\nnome='" + nome + '\'' +
                "\nid=" + id +
                "\ncpf='" + cpf + '\'' +
                "\nemail='" + email + '\'' +
                "\ntelefone='" + telefone + '\'' +
                "\nCodigoQR='" + CodigoQR + '\'' +
                "\nidendereco=" + idendereco +
                "\nendereco='" + endereco + '\'' +
                "\ndentista='" + dentista ;
    }
}