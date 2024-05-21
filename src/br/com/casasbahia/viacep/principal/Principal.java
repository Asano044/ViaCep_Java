package br.com.casasbahia.viacep.principal;

import br.com.casasbahia.viacep.conexao.ConexaoGson;
import br.com.casasbahia.viacep.controller.Apresentacao;
import br.com.casasbahia.viacep.modelo.Endereco;
import br.com.casasbahia.viacep.service.ConexaoService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ConexaoService conexaoService = new ConexaoService();
    private static ConexaoGson conGson = new ConexaoGson();
    private static final ArrayList<Endereco> enderecos = new ArrayList<>();
    private static final Scanner leitura = new Scanner(System.in);

    public static void main(String[]args) throws IOException, InterruptedException {
//        Declarando as variáveis
        final FileWriter notas = new FileWriter("enderecos.json");
        final Apresentacao msg = new Apresentacao();
        String resposta = "";

//        Apresentação do projeto
        msg.mensagemApresentacao();

//        Começo do loop para receber quantos dados o usuário desejar
        while (!resposta.toLowerCase().contains("n")) {
            System.out.println("Deseja adicionar algum CEP? [S/N]: ");
            resposta = leitura.nextLine();

            if (resposta.toLowerCase().contains("n")) {
                break;
            }
            System.out.println("Informe CEP para exibir seu endereço: ");

            enderecos.add(buscarEndereco());
            notas.write(conGson.enderecoParaJson(enderecos));
            notas.close();
        }
//        Fim do loop
        msg.mensagemEncerramento();
    }

    private static Endereco buscarEndereco() throws IOException, InterruptedException {
        return conexaoService.converterCEP(conexaoService.pegarEndereco(leitura.nextLine()));
    }

}
