package br.com.fiap.main;

import br.com.fiap.dao.DentistaDAO;
import br.com.fiap.entities.Dentista;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirDentista {

    // String
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // ID para teste: 98, 97, 96, 5, 7
        Dentista objDentista = new Dentista();

        DentistaDAO objDentistaDao = new DentistaDAO();
        objDentista.setIddentista(inteiro("Informe o ID do Dentista"));
        objDentista.setNome(texto("Informe o Nome do Dentista"));
        objDentista.setCro(texto("Informe o CRO do Dentista"));
        objDentista.setEspecialidade(texto("Informe a especialidade do Dentista"));

        System.out.println(objDentistaDao.inserir(objDentista));

    }

}
