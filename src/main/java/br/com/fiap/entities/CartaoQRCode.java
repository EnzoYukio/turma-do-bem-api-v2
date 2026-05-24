package br.com.fiap.entities;

public class CartaoQRCode {
    private String codigo;
    private String acesso;
    private int Idcartao;
    private String dataemissao;
    private String status;
    private int Idpaciente;

    public CartaoQRCode() {
    }

    public CartaoQRCode(String codigo, String acesso, int idcartao, String dataemissao, String status, int idpaciente) {
        this.codigo = codigo;
        this.acesso = acesso;
        Idcartao = idcartao;
        this.dataemissao = dataemissao;
        this.status = status;
        Idpaciente = idpaciente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public int getIdcartao() {
        return Idcartao;
    }

    public void setIdcartao(int idcartao) {
        Idcartao = idcartao;
    }

    public String getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(String dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdpaciente() {
        return Idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        Idpaciente = idpaciente;
    }

    @Override
    public String toString() {
        return "CartaoQRCode{" +
                "\ncodigo='" + codigo + '\'' +
                "\nacesso='" + acesso + '\'' +
                "\nIdcartao=" + Idcartao +
                "\ndataemissao='" + dataemissao + '\'' +
                "\nstatus='" + status + '\'' +
                "\nIdpaciente=" + Idpaciente;
    }
}