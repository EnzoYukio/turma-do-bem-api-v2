package br.com.fiap.main;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;


import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarPacientePorId {

    // inteiro
    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Paciente objPaciente = new Paciente();

        PacienteDAO dao = new PacienteDAO();

        objPaciente.setId(inteiro("Informe o ID do paciente para consulta"));

        Paciente resultado = dao.buscarPorID(objPaciente.getId());

        if (resultado != null) {
            // Exibe no console (pode usar toString ou outro metodo que quiser)
            System.out.println(resultado);
        } else {
            JOptionPane.showMessageDialog(null, "ID " + objPaciente.getId() + " não encontrado no banco de dados.");
        }
    }
}
