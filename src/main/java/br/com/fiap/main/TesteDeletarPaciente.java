package br.com.fiap.main;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarPaciente {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Paciente objPaciente = new Paciente();

        PacienteDAO objPacienteDao = new PacienteDAO();

        objPaciente.setId(inteiro("Informe o ID do Paciente a ser deletado"));

        System.out.println(objPacienteDao.deletar(objPaciente.getId()));

    }
}
