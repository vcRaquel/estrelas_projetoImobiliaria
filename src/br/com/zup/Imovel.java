package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private String endereco;
    private double valorDoAluguel;
    private Funcionario funcionarioResponsavel;
    private List<Morador> moradores = new ArrayList<>();

    //Construtor
    public Imovel() {

    }
    public Imovel(String endereco, double valorDoAluguel) {
        this.endereco = endereco;
        this.valorDoAluguel = valorDoAluguel;
    }

    public Imovel(String endereco, double valorDoAluguel, Funcionario funcionarioResponsavel) {
        this.endereco = endereco;
        this.valorDoAluguel = valorDoAluguel;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    //Getters e Setters

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorDoAluguel() {
        return valorDoAluguel;
    }

    public void setValorDoAluguel(double valorDoAluguel) {
        this.valorDoAluguel = valorDoAluguel;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    //método para adicionar morador na lista de moradores do imóvel
    public void adicionaMorador(Morador novoMorador){
        moradores.add(novoMorador);
    }


    //toString
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\n Endereço: " +endereco);
        retorno.append("\n Valor do Aluguel: R$ " +valorDoAluguel);
        retorno.append("\n Funcionário responsável: " +funcionarioResponsavel.getNome());
        retorno.append("\n Quantidade de moradores: " +moradores.size());
        retorno.append("\n Lista de moradores: " +moradores);
        return retorno.toString();
    }
}
