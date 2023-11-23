package br.com.casasbahia.viacep.modelo;

public class Apresentacao {
    private String pedirEndereco = "\nInforme seu cep para receber seu endereço: ";
    private String boasVindas = """
            \n******************************************* 
                        BEM VINDO AO VIACEP
            *******************************************""";
    private String encerramento = """
            \n******************************************* 
                    MUITO OBRIGADO POR PARTICIPAR
            *******************************************""";
    public void apresenta() {
        System.out.println(boasVindas);
    }
    public void pedeEndereco() {
        System.out.println(pedirEndereco);
    }

    public void encerra() {
        System.out.println(encerramento);
    }
}
