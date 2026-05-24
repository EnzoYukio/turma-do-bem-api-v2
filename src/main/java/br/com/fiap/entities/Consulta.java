package br.com.fiap.entities;

public class Consulta {
    private String dataHora;
    private String diagnóstico;
    private int id;
    private int Idpaciente;
    private String local;
    private int Idprocedimento;
    private int Iddentista;
    private String valorfinal;
    private int Idconsulta;

    public Consulta() {
    }

    public Consulta(String dataHora, String diagnóstico, int id, int idpaciente, String local, int idprocedimento, int iddentista, String valorfinal, int idconsulta) {
        this.dataHora = dataHora;
        this.diagnóstico = diagnóstico;
        this.id = id;
        Idpaciente = idpaciente;
        this.local = local;
        Idprocedimento = idprocedimento;
        Iddentista = iddentista;
        this.valorfinal = valorfinal;
        Idconsulta = idconsulta;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDiagnóstico() {
        return diagnóstico;
    }

    public void setDiagnóstico(String diagnóstico) {
        this.diagnóstico = diagnóstico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpaciente() {
        return Idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        Idpaciente = idpaciente;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdprocedimento() {
        return Idprocedimento;
    }

    public void setIdprocedimento(int idprocedimento) {
        Idprocedimento = idprocedimento;
    }

    public int getIddentista() {
        return Iddentista;
    }

    public void setIddentista(int iddentista) {
        Iddentista = iddentista;
    }

    public String getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(String valorfinal) {
        this.valorfinal = valorfinal;
    }

    public int getIdconsulta() {
        return Idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        Idconsulta = idconsulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "\ndataHora='" + dataHora + '\'' +
                "\ndiagnóstico='" + diagnóstico + '\'' +
                "\nid=" + id +
                "\nIdpaciente=" + Idpaciente +
                "\nlocal='" + local + '\'' +
                "\nIdprocedimento=" + Idprocedimento +
                "\nIddentista=" + Iddentista +
                "\nvalorfinal='" + valorfinal + '\'' +
                "\nIdconsulta=" + Idconsulta;
    }
}