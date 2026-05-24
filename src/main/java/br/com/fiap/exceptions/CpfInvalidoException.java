package br.com.fiap.exceptions;

public class CpfInvalidoException extends Exception {

    // Construtor padrão que aceita uma mensagem customizada
    public CpfInvalidoException(String mensagem) {
        super(mensagem);
    }
}
