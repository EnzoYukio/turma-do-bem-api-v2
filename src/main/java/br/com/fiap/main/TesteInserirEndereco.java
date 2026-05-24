package br.com.fiap.main;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.entities.Endereco;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirEndereco {

    // String
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Endereco objEndereco = new Endereco();

        EnderecoDAO objEnderecoDao = new EnderecoDAO();
        // ID para o teste: 888
        // 10 foi testado tambem
        objEndereco.setIdendereco(inteiro("Informe o IDendereco"));
        objEndereco.setLogradouro(texto("Informe o logradouro"));
        objEndereco.setCidade(texto("Informe a Cidade"));
        objEndereco.setEstado(texto("Informe o Estado"));

        System.out.println(objEnderecoDao.inserir(objEndereco));

    }

}
