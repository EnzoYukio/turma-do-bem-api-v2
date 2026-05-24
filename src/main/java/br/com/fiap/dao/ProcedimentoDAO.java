package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Endereco;
import br.com.fiap.entities.Procedimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcedimentoDAO {


    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public ProcedimentoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Procedimento procedimento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into PROCEDIMENTO(ID_PROCEDIMENTO, NOME_PROCEDIMENTO, VALOR_BASE) values (?, ?, ?)");
        stmt.setInt(1, procedimento.getIdprocedimento());
        stmt.setString(2, procedimento.getNomeProcedimento());
        stmt.setDouble(3, procedimento.getValorBase());

        stmt.execute();
        stmt.close();

        return "Procedimento cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from PROCEDIMENTO where = id_procedimento");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Procedimento deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Procedimento procedimento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Procedimento set ID_PROCEDIMENTO = ?, NOME_PROCEDIMETNO = ?, VALOR_BASE = ?, where id_procedimento = ?");
        stmt.setInt(1, procedimento.getIdprocedimento());
        stmt.setString(2, procedimento.getNomeProcedimento());
        stmt.setDouble(3, procedimento.getValorBase());

        stmt.executeUpdate();
        stmt.close();

        return "Procedimento atualizado com sucesso!";
    }

    // Select
    public List<Procedimento> selecionar() throws SQLException {
        List<Procedimento> listaProcedimento = new ArrayList<Procedimento>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from PROCEDIMENTO");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Procedimento procedimento = new Procedimento();
            procedimento.setIdprocedimento(rs.getInt(1));
            procedimento.setNomeProcedimento(rs.getString(2));
            procedimento.setValorBase(rs.getDouble(3));

            listaProcedimento.add(procedimento);
        }
        return listaProcedimento;
    }

    // Buscar por ID
    public Procedimento buscarPorID(int id) throws SQLException {
        Procedimento procedimento = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM PROCEDIMENTO WHERE ID_PROCEDIMENTO = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            procedimento = new Procedimento();
            procedimento.setIdprocedimento(rs.getInt(1));
            procedimento.setNomeProcedimento(rs.getString(2));
            procedimento.setValorBase(rs.getDouble(3));
        }

        rs.close();
        stmt.close();

        return procedimento;
    }

}
