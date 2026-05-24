package br.com.fiap.main;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarPaciente {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

                PacienteDAO objPacienteDao = new PacienteDAO();

        List<Paciente> listaPacientes = (ArrayList<Paciente>) objPacienteDao.selecionar();

        if(listaPacientes != null){
            // foreach
            for(Paciente paciente : listaPacientes) {
                System.out.println(
                        paciente.getId() + " " +
                        paciente.getNome() + " " +
                        paciente.getCpf() + " " +
                        paciente.getEmail()  + " "
                );
            }
        }

    }
}
