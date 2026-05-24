package br.com.fiap.main;

import br.com.fiap.entities.Paciente;
import br.com.fiap.entities.Procedimento;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListProcedimento {

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
        ArrayList<Procedimento> listaProcedimentos = new ArrayList<Procedimento>();

        // Preparar objeto null
        Procedimento objProcedimento= null;

        // Laço de repetição (entradas)
        do {

            objProcedimento = new Procedimento();
            objProcedimento.setIdprocedimento(inteiro("ID do Procedimento"));
            objProcedimento.setNomeProcedimento(texto("Nome do Procedimento"));
            objProcedimento.setValorBase(real("Valor do Procedimento"));

            listaProcedimentos.add(objProcedimento);

        }while( JOptionPane.showConfirmDialog(null,
                "Cadastrar mais procedimento?",
                "CADASTRO DE PROCEDIEMNTOS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE )  == 0);

        // Saidas utilizando o foreach
        for(Procedimento a : listaProcedimentos)
            System.out.println(
                    "\n\nID: " + a.getId() +
                            "\nNome: " + a.getNomeProcedimento() +
                            "\nValorBase: " + a.getValorBase()
            );

    }

}
