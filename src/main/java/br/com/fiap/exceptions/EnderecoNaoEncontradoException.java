package br.com.fiap.exceptions;

public class EnderecoNaoEncontradoException extends Exception {

    public EnderecoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}