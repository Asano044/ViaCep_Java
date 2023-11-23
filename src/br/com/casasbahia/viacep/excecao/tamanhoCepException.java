package br.com.casasbahia.viacep.excecao;

public class tamanhoCepException extends RuntimeException {
    private String mensagem;
    public tamanhoCepException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
