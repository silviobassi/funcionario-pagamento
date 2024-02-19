package com.silviobassi.pagamentofuncionario.core.domain.service;

import com.silviobassi.pagamentofuncionario.core.domain.model.Venda;

import java.time.YearMonth;
import java.util.Set;

public class GerenciadorVenda {

    private GerenciadorVenda() {
    }

    public static double getMaiorVendaDaListaDe(Set<Venda> vendas, YearMonth data) {
        if(vendas.isEmpty()) return 0;
        double totalVendas = 0;
        for (Venda venda : vendas)
            if (venda.temVenda(data)) totalVendas += venda.getValor();
        return totalVendas;
    }
}
