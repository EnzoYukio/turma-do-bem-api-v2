package br.com.fiap.bo;

import br.com.fiap.dao.DentistaDAO;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;
import java.util.ArrayList;

public class DentistaBO {

    DentistaDAO dentistaDAO;

    // Buscar por ID
    public static Dentista buscarPorID(int id) throws ClassNotFoundException, SQLException {
        DentistaDAO dentistaDao = new DentistaDAO();
        return dentistaDao.buscarPorID(id);
    }

    // Selecionar todos
    public ArrayList<Dentista> selecionarBo() throws ClassNotFoundException, SQLException {
        dentistaDAO = new DentistaDAO();
        return (ArrayList<Dentista>) dentistaDAO.selecionar();
    }

    public Dentista buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        DentistaDAO dentistaDao = new DentistaDAO();
        return dentistaDao.buscarPorID(id);
    }

    // Inserir — valida CRO antes de salvar
    public static void inserirBo(Dentista dentista) throws ClassNotFoundException, SQLException {
        // Regra de negocio: CRO não pode ser vazio
        if (dentista.getCro() == null || dentista.getCro().trim().isEmpty()) {
            throw new IllegalArgumentException("CRO do dentista não pode ser vazio.");
        }

        DentistaDAO dentistaDao = new DentistaDAO();
        dentistaDao.inserir(dentista);
    }

    // Atualizar — valida se especialidade não está vazia
    public void atualizarBo(Dentista dentista) throws ClassNotFoundException, SQLException {
        // Regra de negocio: especialidade não pode ser vazia
        if (dentista.getEspecialidade() == null || dentista.getEspecialidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade do dentista não pode ser vazia.");
        }

        DentistaDAO dentistaDao = new DentistaDAO();
        dentistaDao.atualizar(dentista);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        DentistaDAO dentistaDao = new DentistaDAO();
        dentistaDao.deletar(id);
    }

}
