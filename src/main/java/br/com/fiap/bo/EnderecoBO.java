package br.com.fiap.bo;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.entities.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoBO {

    EnderecoDAO enderecoDAO;

    public static Object buscarPorID(int id) {

        return null;
    }

    // Selecionar
    public ArrayList<Endereco> selecionarBo() throws ClassNotFoundException, SQLException {
        enderecoDAO = new EnderecoDAO();
        // Regra de negocios
        return (ArrayList<Endereco>) enderecoDAO.selecionar();
    }

    public Endereco buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDao = new EnderecoDAO();
        // Regra de negocios
        return enderecoDao.buscarPorID(id);
    }

    // Inserir
    public static void inserirBo(Endereco endereco) throws ClassNotFoundException, SQLException {
        EnderecoDAO enderecoDao = new EnderecoDAO();
        // Regra de negocios
        enderecoDao.inserir(endereco);
    }

    // Atualizar
    public void atualizarBo(Endereco endereco) throws ClassNotFoundException, SQLException {
        EnderecoDAO consultaDao = new EnderecoDAO();
        // Regra de negocios
        consultaDao.atualizar(endereco);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        EnderecoDAO enderecoDao = new EnderecoDAO();
        // Regra de negocios
        enderecoDao.deletar(id);
    }

}
