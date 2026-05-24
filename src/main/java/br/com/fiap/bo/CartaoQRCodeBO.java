package br.com.fiap.bo;

import br.com.fiap.dao.CartaoQRCodeDAO;
import br.com.fiap.entities.CartaoQRCode;

import java.sql.SQLException;
import java.util.ArrayList;

public class CartaoQRCodeBO {

    CartaoQRCodeDAO cartaoQRCodeDAO;

    public static Object buscarPorID(int id) {

        return null;
    }

    // Selecionar
    public ArrayList<CartaoQRCode> selecionarBo() throws ClassNotFoundException, SQLException {
        cartaoQRCodeDAO = new CartaoQRCodeDAO();
        // Regra de negocios
        return (ArrayList<CartaoQRCode>) cartaoQRCodeDAO.selecionar();
    }

    public CartaoQRCode buscarPorRmBo(int id) throws SQLException, ClassNotFoundException {
        CartaoQRCodeDAO cartaoQRCodeDao = new CartaoQRCodeDAO();
        // Regra de negocios
        return cartaoQRCodeDao.buscarPorID(id);
    }

    // Inserir
    public static void inserirBo(CartaoQRCode cartaoQRCode) throws ClassNotFoundException, SQLException {
        CartaoQRCodeDAO cartaoqrcodeDao = new CartaoQRCodeDAO();
        // Regra de negocios
        cartaoqrcodeDao.inserir(cartaoQRCode);
    }

    // Atualizar
    public void atualizarBo(CartaoQRCode cartaoQRCode) throws ClassNotFoundException, SQLException {
        CartaoQRCodeDAO cartaoQRCodeDao = new CartaoQRCodeDAO();
        // Regra de negocios
        cartaoQRCodeDao.atualizar(cartaoQRCode);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        CartaoQRCodeDAO cartaoQRCodeDAO = new CartaoQRCodeDAO();
        // Regra de negocios
        cartaoQRCodeDAO.deletar(id);
    }

}

