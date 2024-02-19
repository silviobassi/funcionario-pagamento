package com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.maioresremuneracoes.TotalSalariosImpl;

import java.time.YearMonth;

import static com.silviobassi.pagamentofuncionario.core.domain.service.GerenciadorPagamento.getMaiorPagamentoDo;

public class CalculadoraSalariosImpl extends TotalSalariosImpl implements CalculadoraRemuneracaoDeUmFuncionario {
    @Override
    public double calcular(Funcionario funcionario, YearMonth data) {
        return getMaiorPagamentoDo(funcionario, funcionario.getSalario(), data);
    }

    @Override
    protected CalculadoraRemuneracaoDeUmFuncionario getCalculadora() {
        return this;
    }
}
