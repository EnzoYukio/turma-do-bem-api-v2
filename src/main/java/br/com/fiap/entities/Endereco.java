package br.com.fiap.entities;

public class Endereco {
    private int Idendereco;
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    public Endereco(int idendereco, String logradouro, String numero, String cep, String cidade, String estado) {
        Idendereco = idendereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getIdendereco() {
        return Idendereco;
    }

    public void setIdendereco(int idendereco) {
        Idendereco = idendereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "\nIdendereco=" + Idendereco +
                "\nlogradouro='" + logradouro + '\'' +
                "\nnumero='" + numero + '\'' +
                "\ncep='" + cep + '\'' +
                "\ncidade='" + cidade + '\'' +
                "\nestado='" + estado ;
    }
}