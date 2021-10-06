package br.com.zup;

import java.util.Scanner;

public class Sistema {

    // Método responsável por automatizar a entrada de dados
    // Outra forma de receber os dados do usuário
    private static Scanner capturarDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    // Exibir possibilidades
    public static void menu() {
        System.out.println("BEM VINDE À IMOBILIARIA VOCÊ SEM CASA MINHA FELICIDADE");
        System.out.println("Digite 1 - Para cadastrar um imóvel. ");
        System.out.println("Digite 2 - Para exibir os imóveis cadastrados. ");
        System.out.println("Digite 3 para excluir um morador");
        System.out.println("Digite 4 - Para sair");
    }

    public static void submenu() {
        System.out.println("Digite 1 para cadastrar um morador");
        System.out.println("Digite 2 para finalizar o cadastro do Imóvel e voltar ao menu principal");
    }

    //método para validar cpf existente na imobiliária
    private static boolean validaCpf(Imobiliaria imobiliaria, Morador morador) {
        //procurar na imobiliária cada um dos imóveis
        for (Imovel imovelReferencia : imobiliaria.getImoveis()) {

            //procurar dentro de cada imóvel, o morador
            for (Morador moradorReferencia : imovelReferencia.getMoradores()) {
                if (moradorReferencia.getCpf().equals(morador.getCpf())) {
                    return true;
                }

            }
        }

        return false;
    }

    //método para validar email

    private static boolean validaEmail(Morador morador) {
        if (morador.getEmail().contains("@")) {
            return true;
        }
        return false;
    }

    // Método responsável por receber dados para cadastrar moradores
    public static Morador receberDadosMoradores() {
        String nome = capturarDados("Digite o nome do morador: ").nextLine();
        String cpf = capturarDados("Digite o cpf do morador: ").nextLine();
        String email = capturarDados("Digite o e-mail do morador:").nextLine();
        String telefone = capturarDados("Digite o telefone do morador: ").nextLine();
        double renda = capturarDados("Digite a renda do morador: ").nextDouble();

        Morador morador = new Morador(nome, cpf, telefone, renda, email);
        return morador;
    }

    //Método responsável por cadastrar um morador
    public static void cadastraMorador(Imobiliaria imobiliaria, Imovel imovel) {
        Morador morador = receberDadosMoradores();
        //Irá retornar true se o email for válido e false se o email for inválido
        boolean emailValido = validaEmail(morador);
        //Irá retornar true se o cpf já for cadastrado e false se o cpf não for cadastrado
        boolean cpfDeCadastro = validaCpf(imobiliaria, morador);
        if (emailValido && !cpfDeCadastro) {
            imovel.adicionaMorador(morador);
        }
        if (!emailValido) {
            System.out.println("Por favor digite um e-mail válido");
        }

        if (cpfDeCadastro) {
            System.out.println("CPF já cadastrado no sistema");
        }
    }

    // Método responsável por cadastrar funcionários
    public static Funcionario cadastrarFuncionario() {
        String nome = capturarDados("Digite nome do funcionário: ").nextLine();
        String cpf = capturarDados("Digite o cpf do funcionário: ").nextLine();
        String ctps = capturarDados("Digite a carteira de trabalho do funcionário: ").nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, ctps);
        return funcionario;
    }

    // Método responsável por cadastrar imóvel
    public static Imovel cadastrarImovel() {
        String endereco = capturarDados("Digite seu endereço: ").nextLine();
        double valorAluguel = capturarDados("Digite o valor do aluguel: ").nextDouble();

        Imovel imovel = new Imovel(endereco, valorAluguel);
        return imovel;
    }

    //método responsável por excluir um morador
    public static String excluiMorador(Imobiliaria imobiliaria) {
        String cpf = capturarDados("Digite o CPF do morador a ter o cadastro excluído: ").nextLine();
        //procurar em todos os imoveis
        for (Imovel imovelReferencia : imobiliaria.getImoveis()) {
            //procurar na lista de moradores de cada imóvel
            for (Morador moradorReferencia : imovelReferencia.getMoradores()) {
                if (moradorReferencia.getCpf().equals(cpf)) {
                    imovelReferencia.getMoradores().remove(moradorReferencia);
                    return "Cadastro deletado com sucesso";
                }
            }
        }
        return "Morador não cadastrado no sistema";
    }

    // Método responsável juntar tudo
    public static void executar() {
        boolean menu = true;
        Imobiliaria imobiliaria = new Imobiliaria();

        while (menu) {

            menu();
            int opcaoDoUsuario = capturarDados("Digite a opção desejada: ").nextInt();

            if (opcaoDoUsuario == 1) {
                Imovel imovel = cadastrarImovel();
                imobiliaria.adicionarImovel(imovel);
                Funcionario funcionario = cadastrarFuncionario();
                imovel.setFuncionarioResponsavel(funcionario);

                boolean submenu = true;

                while (submenu) {
                    submenu();
                    int escolhaSubmenu = capturarDados("Digite a opção desejada: ").nextInt();

                    if (escolhaSubmenu == 1) {
                        cadastraMorador(imobiliaria, imovel);

                    } else if (escolhaSubmenu == 2) {
                        System.out.println("Você será direcionado ao menu principal");
                        submenu = false;
                    }
                }

            } else if (opcaoDoUsuario == 2) {
                System.out.println(imobiliaria);
            } else if (opcaoDoUsuario == 3) {
                String removendoMorador = excluiMorador(imobiliaria);
                System.out.println(removendoMorador);
            } else if (opcaoDoUsuario == 4) {
                System.out.println("Obrigado e volte sempre");
                menu = false;
            }

        }
    }
}
