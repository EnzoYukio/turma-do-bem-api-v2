package br.com.fiap.main;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.entities.Endereco;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarEndereco {

    // String
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    // double
    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco();

        EnderecoDAO objEnderecoDao = new EnderecoDAO();

        objEndereco.setIdendereco(inteiro("Informe o ID do Endereco a ser atualizado"));
        objEndereco.setLogradouro(texto("Atualize o Logradouro"));
        objEndereco.setCidade(texto("Atualize a Cidade"));
        objEndereco.setEstado(texto("Atualize o Estado"));

        System.out.println(objEnderecoDao.atualizar(objEndereco));

    }
}
