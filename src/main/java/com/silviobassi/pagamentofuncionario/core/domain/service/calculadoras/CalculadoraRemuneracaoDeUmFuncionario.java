package com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;

import java.time.YearMonth;

public interface CalculadoraRemuneracaoDeUmFuncionario {
    double calcular(Funcionario funcionario, YearMonth data);

    default double calcularDeducao(Funcionario funcionario, YearMonth data) {
        double baseCalculo = funcionario.temVendas() ? CalculadoraVendas.calcular(funcionario, data) : funcionario.getSalario();
        return baseCalculo * funcionario.getDeducao() + funcionario.getAbonoAnual();
    }

}
