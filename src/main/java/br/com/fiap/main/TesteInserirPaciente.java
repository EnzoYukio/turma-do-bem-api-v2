package br.com.fiap.main;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;
import br.com.fiap.exceptions.EnderecoNaoEncontradoException;
import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirPaciente {

    static String texto(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    static int inteiro(String mensagem) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }

    public static void main(String[] args) {

        Paciente paciente = new Paciente();

        try {
            // Instancia o DAO (Abre a conexão com o Oracle)
            PacienteDAO dao = new PacienteDAO();

            // Captura os dados dinamicamente via JOptionPane
            paciente.setId(inteiro("Informe o ID do Paciente (Use um número inédito, ex: 910)"));
            paciente.setNome(texto("Digite o Nome do Paciente"));
            paciente.setCpf(texto("Digite o CPF do Paciente"));
            paciente.setEmail(texto("Digite o E-mail do Paciente"));
            paciente.setIdendereco(inteiro("Informe o ID do Endereço (ex: 1 ou 2)"));

            // Executa o insert
            String resultado = dao.inserir(paciente);
            System.out.println(resultado);

        } catch (EnderecoNaoEncontradoException e) {
            // SEU CÓDIGO CAI AQUI SE O ID DO ENDEREÇO NÃO EXISTIR NO BANCO!
            System.err.println("\n[SUCESSO NO TESTE DE EXCEÇÃO] A camada DAO barrou o erro!");
            System.err.println("Mensagem da Exceção: " + e.getMessage());

        } catch (SQLException e) {
            System.err.println("\nErro nativo de SQL: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.err.println("\nErro ao carregar o driver do banco: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("\nOutro erro inesperado: " + e.getMessage());
        }
    }
}