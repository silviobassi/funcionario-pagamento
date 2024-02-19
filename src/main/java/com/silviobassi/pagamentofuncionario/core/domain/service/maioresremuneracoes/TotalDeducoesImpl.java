package com.silviobassi.pagamentofuncionario.core.domain.service.maioresremuneracoes;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraRemuneracaoDeUmFuncionario;

import java.time.YearMonth;
import java.util.Set;

import static com.silviobassi.pagamentofuncionario.core.domain.service.GerenciadorPagamento.getMaiorPagamentoDaListaDe;

public abstract class TotalDeducoesImpl implements CalculadoraRemuneracaoDeVariosFuncionarios {
    @Override
    public double calcular(Set<Funcionario> funcionarios, YearMonth pagoEm) {
        return getMaiorPagamentoDaListaDe(funcionarios, getCalculadora(), pagoEm);
    }

    protected abstract CalculadoraRemuneracaoDeUmFuncionario getCalculadora();
}
