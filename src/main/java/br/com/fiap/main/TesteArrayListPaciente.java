package br.com.fiap.main;

import br.com.fiap.entities.Paciente;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListPaciente {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    // int
    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    // double
    static double real(String j){
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) {

        // Preparar a lista de pacientes
        ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();

        // Preparar objeto null
        Paciente objPaciente= null;

        // Laço de repetição (entradas)
        do {

            objPaciente = new Paciente();
            objPaciente.setNome(texto("Nome do Paciente"));
            objPaciente.setId(inteiro("ID do Paciente"));
            objPaciente.setCpf(texto("CPF do Paciente"));
            objPaciente.setEmail(texto("Email do Paciente"));
            objPaciente.setTelefone(texto("Telefone do Paciente"));

            listaPacientes.add(objPaciente);

        }while( JOptionPane.showConfirmDialog(null,
                "Cadastrar mais paciente?",
                "CADASTRO DE PACIENTES",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE )  == 0);

        // Saidas utilizando o foreach
        for(Paciente a : listaPacientes)
            System.out.println(
                    "\n\nID: " + a.getId() +
                            "\nNome: " + a.getNome() +
                            "\nCPF: " + a.getCpf() +
                            "\nEMAIL: " + a.getEmail() +
                            "\nTelefone:" + a.getTelefone()
            );

    }



}
