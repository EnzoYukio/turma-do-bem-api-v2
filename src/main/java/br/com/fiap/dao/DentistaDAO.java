package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Dentista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistaDAO {

    public Connection minhaConexao;

    public DentistaDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into DENTISTA(ID_DENTISTA, NOME, CRO, ESPECIALIDADE) values (?, ?, ?, ?)");
        stmt.setInt(1, dentista.getIddentista());
        stmt.setString(2, dentista.getNome());
        stmt.setString(3, dentista.getCro());
        stmt.setString(4, dentista.getEspecialidade());

        stmt.execute();
        stmt.close();

        return "Dentista cadastrado com sucesso!";
    }

    // Delete — corrigido (tinha erro de sintaxe SQL)
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from DENTISTA where id_dentista = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Dentista deletado com sucesso!";
    }

    // Update — corrigido (faltava o parâmetro do WHERE)
    public String atualizar(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update DENTISTA set NOME = ?, CRO = ?, ESPECIALIDADE = ? where id_dentista = ?");
        stmt.setString(1, dentista.getNome());
        stmt.setString(2, dentista.getCro());
        stmt.setString(3, dentista.getEspecialidade());
        stmt.setInt(4, dentista.getIddentista());

        stmt.executeUpdate();
        stmt.close();

        return "Dentista atualizado com sucesso!";
    }

    // Select
    public List<Dentista> selecionar() throws SQLException {
        List<Dentista> listaDentistas = new ArrayList<Dentista>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from DENTISTA");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Dentista dentista = new Dentista();
            dentista.setIddentista(rs.getInt(1));
            dentista.setNome(rs.getString(2));
            dentista.setCro(rs.getString(3));
            dentista.setEspecialidade(rs.getString(4));
            listaDentistas.add(dentista);
        }
        return listaDentistas;
    }

    // Buscar por ID
    public Dentista buscarPorID(int id) throws SQLException {
        Dentista dentista = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM DENTISTA WHERE ID_DENTISTA = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            dentista = new Dentista();
            dentista.setIddentista(rs.getInt(1));
            dentista.setNome(rs.getString(2));
            dentista.setCro(rs.getString(3));
            dentista.setEspecialidade(rs.getString(4));
        }

        rs.close();
        stmt.close();

        return dentista;
    }

}
