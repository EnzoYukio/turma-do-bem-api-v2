package br.com.fiap.main;

import br.com.fiap.entities.Consulta;

import javax.swing.*;
import java.util.ArrayList;

public class TestArrayListConsulta {


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
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();

        // Preparar objeto null
        Consulta objConsulta= null;

        // Laço de repetição (entradas)
        do {

            objConsulta = new Consulta();
            objConsulta.setIdconsulta(inteiro(" ID da consulta"));
            objConsulta.setDataHora(texto(" Data e hora da consulta"));
            objConsulta.setIdpaciente(inteiro("ID do Paciente"));
            objConsulta.setIddentista(inteiro(" ID do Dentista"));
            objConsulta.setIdprocedimento(inteiro("ID do Procedimento"));

            listaConsultas.add(objConsulta);

        }while( JOptionPane.showConfirmDialog(null,
                "Cadastrar mais consulta?",
                "CADASTRO DE CONSULTAS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE )  == 0);

        // Saidas utilizando o foreach
        for(Consulta a : listaConsultas)
            System.out.println(
                    "\n\nID: " + a.getId() +
                            "\nDataHora: " + a.getDataHora() +
                            "\nIdPaciente: " + a.getIdpaciente() +
                            "\nIdDentista: " + a.getIddentista() +
                            "\nIdprocedimento:" + a.getIdprocedimento()
            );

    }
}

