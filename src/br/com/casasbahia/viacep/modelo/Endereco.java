package br.com.casasbahia.viacep.modelo;


public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String estado;

    public Endereco(EnderecoViacep endViacep) {
        this.cep = endViacep.cep();
        this.logradouro = endViacep.logradouro();
        this.bairro = endViacep.bairro();
        this.localidade = endViacep.localidade();
        this.estado = endViacep.uf();
    }

    @Override
    public String toString() {
        return "(cep: " + this.cep +
                ", logradouro: " + this.logradouro +
                ", bairro: " + this.bairro +
                ", localidade: " + this.localidade +
                ", estado: " + this.estado + ")";
    }
}
