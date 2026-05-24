package br.com.fiap.bo;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.DentistaDAO;
import br.com.fiap.entities.Consulta;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaBO {


    ConsultaDAO consultaDAO;

    public static Object buscarPorID(int id) {

        return null;
    }

    // Selecionar
    public ArrayList<Consulta> selecionarBo() throws ClassNotFoundException, SQLException {
        consultaDAO = new ConsultaDAO();
        // Regra de negocios
        return (ArrayList<Consulta>) consultaDAO.selecionar();
    }

    public Consulta buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        ConsultaDAO consultaDao = new ConsultaDAO();
        // Regra de negocios
        return consultaDao.buscarPorID(id);
    }

    // Inserir
    public static void inserirBo(Consulta consulta) throws ClassNotFoundException, SQLException {
        ConsultaDAO consultaDao = new ConsultaDAO();
        // Regra de negocios
        consultaDao.inserir(consulta);
    }

    // Atualizar
    public void atualizarBo(Consulta consulta) throws ClassNotFoundException, SQLException {
        ConsultaDAO consultaDao = new ConsultaDAO();
        // Regra de negocios
        consultaDao.atualizar(consulta);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        ConsultaDAO consultaDao = new ConsultaDAO();
        // Regra de negocios
        consultaDao.deletar(id);
    }

}

