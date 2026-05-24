package br.com.fiap.main;

import br.com.fiap.dao.CartaoQRCodeDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.CartaoQRCode;
import br.com.fiap.entities.Paciente;

import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarCartaoQRCodePorId {

    // inteiro
    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        CartaoQRCode objCartaoQRCode = new CartaoQRCode();

        CartaoQRCodeDAO dao = new CartaoQRCodeDAO();

        objCartaoQRCode.setIdcartao(inteiro("Informe o IDcartao para consulta"));

        CartaoQRCode resultado = dao.buscarPorID(objCartaoQRCode.getIdcartao());

        if (resultado != null) {
            // Exibe no console (pode usar toString ou outro metodo que quiser)
            System.out.println(resultado);
        } else {
            JOptionPane.showMessageDialog(null, "ID " + objCartaoQRCode.getIdcartao() + " não encontrado no banco de dados.");
        }
    }
}

