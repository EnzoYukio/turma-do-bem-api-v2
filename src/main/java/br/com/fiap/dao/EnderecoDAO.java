package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into ENDERECO(ID_ENDERECO, LOGRADOURO, CIDADE, ESTADO) values (?, ?, ?, ?)");
        stmt.setInt(1, endereco.getIdendereco());
        stmt.setString(2, endereco.getLogradouro());
        stmt.setString(3, endereco.getCidade());
        stmt.setString(4, endereco.getEstado());

        stmt.execute();
        stmt.close();

        return "Endereco cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from ENDERECO where = id_endereco");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Endereco deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Endereco set LOGRADOURO = ?, CIDADE = ?, ESTADO= ? where id_endereco = ?");
        stmt.setString(1, endereco.getLogradouro());
        stmt.setString(2, endereco.getCidade());
        stmt.setString(3, endereco.getEstado());
        stmt.setInt(4, endereco.getIdendereco());

        stmt.executeUpdate();
        stmt.close();

        return "Endereco atualizado com sucesso!";
    }

    // Select
    public List<Endereco> selecionar() throws SQLException {
        List<Endereco> listaEndereco = new ArrayList<Endereco>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from ENDERECO");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Endereco endereco = new Endereco();
            endereco.setIdendereco(rs.getInt(1));
            endereco.setLogradouro(rs.getString(2));
            endereco.setCidade(rs.getString(3));
            endereco.setEstado(rs.getString(4));
            listaEndereco.add(endereco);
        }
        return listaEndereco;
    }

    // Buscar por ID
    public Endereco buscarPorID(int id) throws SQLException {
        Endereco endereco = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM ENDERECO WHERE ID_ENDERECO = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            endereco = new Endereco();
            endereco.setIdendereco(rs.getInt(1));
            endereco.setLogradouro(rs.getString(2));
            endereco.setCidade(rs.getString(3));
            endereco.setEstado(rs.getString(4));
        }

        rs.close();
        stmt.close();

        return endereco;
    }

}

