package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public ConsultaDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Consulta consulta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into CONSULTA(ID_CONSULTA, DATA_CONSULTA, ID_PACIENTE, ID_DENTISTA, ID_PROCEDIMENTO, VALOR_FINAL) values (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, consulta.getIdconsulta());
        stmt.setString(2, consulta.getDataHora());
        stmt.setInt(3, consulta.getIdpaciente());
        stmt.setInt(4,  consulta.getIddentista());
        stmt.setInt(5, consulta.getIdprocedimento());
        stmt.setString(6, consulta.getValorfinal());

        stmt.execute();
        stmt.close();

        return "Consulta cadastrada com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from CONSULTA where = id_consulta ");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Consulta deletada com sucesso!";
    }

    // UpDate
    public String atualizar(Consulta consulta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update CONSULTA set ID_CONSULTA = ?, DATA_CONSULTA = ?, ID_PACIENTE= ?, ID_DENTISTA = ?, ID_PROCEDIMENTO = ?, VALOR_FINAL = ?   where id_consulta = ?");
        stmt.setInt(1, consulta.getIdconsulta());
        stmt.setString(2, consulta.getDataHora());
        stmt.setInt(3, consulta.getIdpaciente());
        stmt.setInt(4, consulta.getIddentista());
        stmt.setInt(5, consulta.getIdprocedimento());
        stmt.setString(6, consulta.getValorfinal());



        stmt.executeUpdate();
        stmt.close();

        return "Consulta atualizada com sucesso!";
    }

    // Select
    public List<Consulta> selecionar() throws SQLException {
        List<Consulta> listaConsultas = new ArrayList<Consulta>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from CONSULTA");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Consulta consulta = new Consulta();
            consulta.setIdconsulta(rs.getInt(1));
            consulta.setDataHora(rs.getString(2));
            consulta.setIdpaciente(rs.getInt(3));
            consulta.setIddentista(rs.getInt(4));
            consulta.setIdprocedimento(rs.getInt(5));
            consulta.setValorfinal(rs.getString(6));
            listaConsultas.add(consulta);
        }
        return listaConsultas;
    }

    // Buscar por ID
    public Consulta buscarPorID(int id) throws SQLException {
        Consulta consulta = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM CONSULTA WHERE ID_CONSULTA = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            consulta = new Consulta();
            consulta.setIdconsulta(rs.getInt(1));
            consulta.setDataHora(rs.getString(2));
            consulta.setIdpaciente(rs.getInt(3));
            consulta.setIddentista(rs.getInt(4));
            consulta.setIdprocedimento(rs.getInt(5));
            consulta.setValorfinal(rs.getString(6));
        }

        rs.close();
        stmt.close();

        return consulta;
    }

}

