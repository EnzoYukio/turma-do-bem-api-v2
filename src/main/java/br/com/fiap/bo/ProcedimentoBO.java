package br.com.fiap.bo;

import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.entities.Procedimento;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProcedimentoBO {

    ProcedimentoDAO procedimentoDAO;

    public static Object buscarPorID(int id) {

        return null;
    }

    // Selecionar
    public ArrayList<Procedimento> selecionarBo() throws ClassNotFoundException, SQLException {
        procedimentoDAO = new ProcedimentoDAO();
        // Regra de negocios
        return (ArrayList<Procedimento>) procedimentoDAO.selecionar();
    }

    public Procedimento buscarPorRmBo(int id) throws SQLException, ClassNotFoundException {
        ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
        // Regra de negocios
        return procedimentoDao.buscarPorID(id);
    }

    // Inserir
    public static void inserirBo(Procedimento procedimento) throws ClassNotFoundException, SQLException {
        ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
        // Regra de negocios
        procedimentoDao.inserir(procedimento);
    }

    // Atualizar
    public void atualizarBo(Procedimento procedimento) throws ClassNotFoundException, SQLException {
        ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
        // Regra de negocios
        procedimentoDao.atualizar(procedimento);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
        // Regra de negocios
        procedimentoDao.deletar(id);
    }

}

