package com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.maioresremuneracoes.TotalSalariosDeducoesImpl;

import java.time.YearMonth;

import static com.silviobassi.pagamentofuncionario.core.domain.service.GerenciadorPagamento.getMaiorPagamentoDo;

public class CalculadoraSalariosDeducoesImpl extends TotalSalariosDeducoesImpl implements CalculadoraRemuneracaoDeUmFuncionario {
    @Override
    public double calcular(Funcionario funcionario, YearMonth data) {
        double totalSalarioDeducao = calcularSalarioDeducao(funcionario);
        return getMaiorPagamentoDo(funcionario, totalSalarioDeducao, data);
    }

    private double calcularSalarioDeducao(Funcionario funcionario) {
        return funcionario.getSalario() + getCalculadora().calcularDeducao(funcionario, YearMonth.now());
    }

    @Override
    protected CalculadoraRemuneracaoDeUmFuncionario getCalculadora() {
        return this;
    }
}
