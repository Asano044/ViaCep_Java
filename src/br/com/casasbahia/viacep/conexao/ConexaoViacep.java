package br.com.casasbahia.viacep.conexao;

import br.com.casasbahia.viacep.excecao.TamanhoCepException;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoViacep {
    private final HttpResponse<String> response;

    public ConexaoViacep(String cep) throws IOException, InterruptedException {
        try {
            Integer.parseInt(cep);
        } catch (NumberFormatException err) {
            System.out.println("Não foi possível cadastrar o CEP. Tente novamente.");
            System.exit(0);
        }
        if (cep.length() != 8) {
            throw new TamanhoCepException("CEP inválido. Informe 8 dígitos.");
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();
        response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getJson() {
        return response.body();
    }
}
