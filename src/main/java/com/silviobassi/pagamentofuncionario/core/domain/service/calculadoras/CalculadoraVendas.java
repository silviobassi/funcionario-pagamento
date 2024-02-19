package com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;

import java.time.YearMonth;

import static com.silviobassi.pagamentofuncionario.core.domain.service.GerenciadorVenda.getMaiorVendaDaListaDe;

public class CalculadoraVendas {

    private CalculadoraVendas() {
    }

    public static double calcular(Funcionario funcionario, YearMonth data) {
        return getMaiorVendaDaListaDe(funcionario.getVendas(), data);
    }
}
