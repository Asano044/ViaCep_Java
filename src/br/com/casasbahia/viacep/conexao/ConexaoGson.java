package br.com.casasbahia.viacep.conexao;

import br.com.casasbahia.viacep.modelo.Endereco;
import br.com.casasbahia.viacep.modelo.EnderecoViacep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ConexaoGson {
    private String json;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();;

    public ConexaoGson() {

    }
    public ConexaoGson(String json) {
        this.json = json;
    }

    public EnderecoViacep jsonParaEndViacep() {
        return gson.fromJson(json, EnderecoViacep.class);
    }

    public String enderecoParaJson(ArrayList<Endereco> enderecos) {
        return gson.toJson(enderecos);
    }

}
