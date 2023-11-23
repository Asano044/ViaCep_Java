package br.com.casasbahia.viacep.principal;

import br.com.casasbahia.viacep.conexao.ConexaoGson;
import br.com.casasbahia.viacep.conexao.ConexaoViacep;
import br.com.casasbahia.viacep.excecao.tamanhoCepException;
import br.com.casasbahia.viacep.modelo.Apresentacao;
import br.com.casasbahia.viacep.modelo.Endereco;
import br.com.casasbahia.viacep.modelo.EnderecoViacep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[]args) throws IOException, InterruptedException {
//        Variáveis de conexão
        ConexaoViacep conViacep;
        ConexaoGson conGson = new ConexaoGson();
        EnderecoViacep endViacep;
        Endereco endereco;

//        Declarando as variáveis
        FileWriter notas = new FileWriter("enderecos.json");
        Scanner entrada = new Scanner(System.in);
        Apresentacao msg = new Apresentacao();
        String cep = "";
        String json;

//        Declarando ArrayList
        ArrayList<Endereco> enderecos = new ArrayList<>();

//        Apresentação do projeto
        msg.apresenta();

//        Começo do loop para receber quantos dados o usuário desejar
        while (cep != "sair") {

        //        Solicita para o usuário enviar o cep
            msg.pedeEndereco();
            cep = entrada.next();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

        //        Começo do bloco try e catch()
            try {
                conViacep = new ConexaoViacep(cep);
                json = conViacep.getJson();
                System.out.println("Cep cadastrado com sucesso!");

            //    Convertendo as informações recebidas para EnderecoViacep, convertendo para Endereco e armazenando no array
                conGson = new ConexaoGson(json);
                endViacep = conGson.jsonParaEndViacep();
                endereco = new Endereco(endViacep);
                enderecos.add(endereco);


            } catch (tamanhoCepException err) {
                System.out.println(err.getMessage());
            } catch (NumberFormatException err) {
                System.out.println(err.getMessage());
            }
        //        Fim do bloco try e catch()
        }
//        Fim do loop

        //    Convertendo os enderecos para json e enviando para o arquivo.json
        notas.write(conGson.enderecoParaJson(enderecos));
        notas.close();
//        Encerramento
        msg.encerra();

    }
}
