package br.com.zup;

public class Funcionario extends Pessoa{
    private String ctps;

    //Construtores

    public Funcionario() {

    }

    public Funcionario(String nome, String cpf, String ctps) {
        super(nome, cpf);
        this.ctps = ctps;
    }

    //Getters e Setters

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }


    //toString
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append(super.toString());
        retorno.append("\n Carteira de trabalho: " +ctps);
        return retorno.toString();
    }
}
