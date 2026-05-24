package br.com.fiap.main;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarPaciente {

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

     Paciente objPaciente = new Paciente();

     PacienteDAO objPacienteDao = new PacienteDAO();

     objPaciente.setId(inteiro("Informe o ID do Paciente a ser atualizado"));
     objPaciente.setNome(texto("Atualize o Nome"));
     objPaciente.setCpf(texto("Atualize o CPF"));
     objPaciente.setEmail(texto("Atualize o Email"));

        System.out.println(objPacienteDao.atualizar(objPaciente));

    }
}
