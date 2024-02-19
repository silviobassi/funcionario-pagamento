package com.silviobassi.pagamentofuncionario.core.domain.service;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.model.Pagamento;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraRemuneracaoDeUmFuncionario;

import java.time.YearMonth;
import java.util.Set;

public class GerenciadorPagamento {

    private GerenciadorPagamento() {
    }

    public static double getMaiorPagamentoDaListaDe(Set<Funcionario> funcionarios,
                                                    CalculadoraRemuneracaoDeUmFuncionario calculadora,
                                                    YearMonth pagoEm) {
        if (funcionarios.isEmpty()) return 0;
        double totalBeneficio = 0;
        for (Funcionario funcionario : funcionarios) {
            totalBeneficio += calculadora.calcular(funcionario, pagoEm);
        }
        return totalBeneficio;
    }

    public static double getMaiorPagamentoDo(Funcionario funcionario, double totalCalculo, YearMonth data) {
        double totalSalarioDeducao = 0;
        for (Pagamento pagamento : funcionario.getPagamentos())
            totalSalarioDeducao += pagamento.temPagamento(data) ? totalCalculo : 0;
        return totalSalarioDeducao;
    }
}
