package br.com.casasbahia.viacep.excecao;

public class TamanhoCepException extends RuntimeException {
    private final String mensagem;
    public TamanhoCepException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
