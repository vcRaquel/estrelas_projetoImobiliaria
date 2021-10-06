package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {
    private List<Imovel> imoveis = new ArrayList<>();

    //método pra adicionar um imóvel na lista
    public void adicionarImovel(Imovel novoImovel){
        imoveis.add(novoImovel);
    }

    //toString
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Quantidade de imoveis: " +imoveis.size());
        retorno.append("Imoveis: ");
        retorno.append("\n " +imoveis);
        return retorno.toString();
    }
}
