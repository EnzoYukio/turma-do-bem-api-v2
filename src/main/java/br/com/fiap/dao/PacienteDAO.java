package br.com.fiap.dao;

import br.com.fiap.entities.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.exceptions.EnderecoNaoEncontradoException; // Importando sua nova exceção

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Connection minhaConexao;

    // Método construtor
    public PacienteDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // 1. INSERT (Atualizado com o tratamento de exceção customizada)
    public String inserir(Paciente paciente) throws SQLException, EnderecoNaoEncontradoException {
        String sql = "Insert into PACIENTE(ID_PACIENTE, NOME, CPF, ID_ENDERECO, EMAIL) values (?, ?, ?, ?, ?)";

        // Usando o bloco try normal para capturar o erro do Oracle
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement(sql);
            stmt.setInt(1, paciente.getId());
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getCpf());
            stmt.setInt(4, paciente.getIdendereco());
            stmt.setString(5, paciente.getEmail());

            stmt.execute();
            stmt.close();

            return "Paciente cadastrado com sucesso!";

        } catch (SQLException e) {
            // Código 2291 = ORA-02291 (Chave estrangeira de endereço inválida)
            if (e.getErrorCode() == 2291) {
                throw new EnderecoNaoEncontradoException("Erro de consistência: O ID de endereço "
                        + paciente.getIdendereco() + " não existe na tabela de endereços cadastrados.");
            }
            // Se for qualquer outro erro de banco (ex: falta de conexão), repassa o erro original
            throw e;
        }
    }

    // 2. DELETE (Mantido original)
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from PACIENTE where id_paciente = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Paciente deletado com sucesso!";
    }

    // 3. UPDATE (Mantido original)
    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Update PACIENTE set NOME = ?, CPF = ?, id_endereco = ? where id_paciente = ?");
        stmt.setString(1, paciente.getNome());
        stmt.setString(2, paciente.getCpf());
        stmt.setInt(3, paciente.getIdendereco());
        stmt.setInt(4, paciente.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Paciente atualizado com sucesso!";
    }

    // 4. SELECT ALL (Ajustado os índices rs.get para não inverter dados)
    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from PACIENTE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Paciente paciente = new Paciente();
            // Boa prática para a FIAP: Buscar pelo nome da coluna evita erros se a tabela mudar de ordem
            paciente.setId(rs.getInt("ID_PACIENTE"));
            paciente.setNome(rs.getString("NOME"));
            paciente.setCpf(rs.getString("CPF"));
            paciente.setIdendereco(rs.getInt("ID_ENDERECO"));
            paciente.setEmail(rs.getString("EMAIL"));
            listaPacientes.add(paciente);
        }

        rs.close();
        stmt.close();
        return listaPacientes;
    }

    // 5. BUSCAR POR ID (Ajustado os índices rs.get pelas colunas)
    public Paciente buscarPorID(int id) throws SQLException {
        Paciente paciente = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM PACIENTE WHERE ID_PACIENTE = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            paciente = new Paciente();
            paciente.setId(rs.getInt("ID_PACIENTE"));
            paciente.setNome(rs.getString("NOME"));
            paciente.setCpf(rs.getString("CPF"));
            paciente.setIdendereco(rs.getInt("ID_ENDERECO"));
            paciente.setEmail(rs.getString("EMAIL"));
        }

        rs.close();
        stmt.close();

        return paciente;
    }
}