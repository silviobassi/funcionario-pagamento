package com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.maioresremuneracoes.TotalDeducoesImpl;

import java.time.YearMonth;

import static com.silviobassi.pagamentofuncionario.core.domain.service.GerenciadorPagamento.getMaiorPagamentoDo;

public class CalculadoraDeducoesImpl extends TotalDeducoesImpl implements CalculadoraRemuneracaoDeUmFuncionario {
    @Override
    public double calcular(Funcionario funcionario, YearMonth data) {
        double totalDeducao = getCalculadora().calcularDeducao(funcionario, data);
        return getMaiorPagamentoDo(funcionario, totalDeducao, data);
    }

    @Override
    protected CalculadoraRemuneracaoDeUmFuncionario getCalculadora() {
        return this;
    }
}
