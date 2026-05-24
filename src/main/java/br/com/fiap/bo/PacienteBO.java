package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entities.Paciente;
import br.com.fiap.exceptions.CpfInvalidoException;
import br.com.fiap.exceptions.EnderecoNaoEncontradoException;

public class PacienteBO {

    PacienteDAO pacienteDAO;

    // Buscar por ID — corrigido (antes estava retornando null)
    public static Paciente buscarPorID(int id) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        return pacienteDao.buscarPorID(id);
    }

    // Selecionar todos
    public ArrayList<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        return (ArrayList<Paciente>) pacienteDAO.selecionar();
    }

    public Paciente buscarPorRmBo(int id) throws SQLException, ClassNotFoundException {
        PacienteDAO pacienteDao = new PacienteDAO();
        return pacienteDao.buscarPorID(id);
    }

    // Inserir — valida CPF antes de salvar
    public static void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException, EnderecoNaoEncontradoException, CpfInvalidoException {
        // Regra de negocio: CPF precisa ter exatamente 11 digitos numericos
        String cpfSomenteNumeros = paciente.getCpf().replaceAll("[^0-9]", "");
        if (cpfSomenteNumeros.length() != 11) {
            throw new CpfInvalidoException("CPF inválido: precisa ter 11 dígitos.");
        }

        PacienteDAO pacienteDao = new PacienteDAO();
        pacienteDao.inserir(paciente);
    }

    // Atualizar — valida se o nome não está vazio antes de atualizar
    public void atualizarBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        // Regra de negocio: nome não pode ser vazio
        if (paciente.getNome() == null || paciente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do paciente não pode ser vazio.");
        }

        PacienteDAO pacienteDao = new PacienteDAO();
        pacienteDao.atualizar(paciente);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        pacienteDao.deletar(id);
    }

}
