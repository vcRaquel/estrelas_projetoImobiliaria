package br.com.zup;

import java.util.Scanner;

public class Sistema {

    // Método responsável por automatizar a entrada de dados
    // Outra forma de receber os dados do usuário
    private static Scanner capturarDados(String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    // Exibir possibilidades
    public static void menu(){
        System.out.println("BEM VINDE À IMOBILIARIA VOCÊ SEM CASA MINHA FELICIDADE");
        System.out.println("Digite 1 - Para cadastrar um imóvel. ");
        System.out.println("Digite 2 - Para exibir os imóveis cadastrados. ");
        System.out.println("Digite 3 - Para sair");
    }

    // Método responsável por cadastrar moradores
    public static Morador cadastrarMoradores(){
        String nome = capturarDados("Digite seu nome: ").nextLine();
        String cpf = capturarDados("Digite seu cpf: ").nextLine();
        String telefone = capturarDados("Digite o seu telefone: ").nextLine();
        double renda = capturarDados("Digite o salario: ").nextDouble();

        Morador morador = new Morador(nome, cpf, telefone, renda);
        return morador;
    }

    // Método responsável por cadastrar funcionários
    public static Funcionario cadastrarFuncionario(){
        String nome = capturarDados("Digite seu nome: ").nextLine();
        String cpf = capturarDados("Digite seu cpf: ").nextLine();
        String ctps = capturarDados("Digite sua carteira de trabalho: ").nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, ctps);
        return funcionario;
    }

    // Método responsável por cadastrar imóvel
    public static Imovel cadastrarImovel(){
        String endereco = capturarDados("Digite seu endereço: ").nextLine();
        double valorAluguel = capturarDados("Digite o valor do aluguel: ").nextDouble();

        Imovel imovel = new Imovel(endereco, valorAluguel);
        return imovel;
    }

    // Método responsável juntar tudo
    public static void executar(){
        boolean menu = true;
        Imobiliaria imobiliaria = new Imobiliaria();

        while (menu){


            menu();
            int opcaoDoUsuario = capturarDados("Digite a opção desejada: ").nextInt();
            switch (opcaoDoUsuario){
                case 1:
                    Imovel imovel = cadastrarImovel();
                    Funcionario funcionario = cadastrarFuncionario();
                    imovel.setFuncionarioResponsavel(funcionario);

                    int qtdMoradores = capturarDados("Digite a quantidade de moradores: ").nextInt();
                    for (int i = 0; i < qtdMoradores; i++) {
                        Morador morador = cadastrarMoradores();
                        imovel.adicionaMorador(morador);
                    }

                    imobiliaria.adicionarImovel(imovel);
                    break;
                case 2:
                    System.out.println(imobiliaria);
                    break;
                case 3:
                    System.out.println("Obrigado e volte sempre");
                    menu = false;
                    break;
            }
        }
    }
}
