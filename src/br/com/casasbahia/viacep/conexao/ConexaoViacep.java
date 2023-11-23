package br.com.casasbahia.viacep.conexao;

import br.com.casasbahia.viacep.excecao.tamanhoCepException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoViacep {
    private String cep;
    private int validacaoCep;
    private String json;
    private HttpResponse<String> response;


    public ConexaoViacep(String cep) throws IOException, InterruptedException {
        this.cep = cep;
        try {
            this.validacaoCep = Integer.parseInt(this.cep);
        } catch (NumberFormatException err) {
            this.cep = "00000000";
        }


        if (this.cep.length() != 8) {
            throw new tamanhoCepException("Quantidade de dígitos não permitida deve ser enviado 8 dígitos");
        }

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://viacep.com.br/ws/" + this.cep + "/json/"))
            .build();
    response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getJson() {
        return json = response.body();
    }
}
