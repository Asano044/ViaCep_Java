package br.com.casasbahia.viacep.service;

import br.com.casasbahia.viacep.conexao.ConexaoGson;
import br.com.casasbahia.viacep.conexao.ConexaoViacep;
import br.com.casasbahia.viacep.modelo.Endereco;
import br.com.casasbahia.viacep.modelo.EnderecoViacep;

import java.io.IOException;

public class ConexaoService {

    public String pegarEndereco(String cep) throws IOException, InterruptedException {
        ConexaoViacep conexaoViacep = new ConexaoViacep(cep);
        return conexaoViacep.getJson();
    }

    public Endereco converterCEP(String json) {
        ConexaoGson conexaoGson = new ConexaoGson(json);
        EnderecoViacep enderecoViacep = conexaoGson.jsonParaEndViacep();
        return new Endereco(enderecoViacep);
    }

}

