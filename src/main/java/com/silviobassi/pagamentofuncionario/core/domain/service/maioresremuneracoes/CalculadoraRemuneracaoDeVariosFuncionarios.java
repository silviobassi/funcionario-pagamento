package com.silviobassi.pagamentofuncionario.core.domain.service.maioresremuneracoes;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;

import java.time.YearMonth;
import java.util.Set;

public interface CalculadoraRemuneracaoDeVariosFuncionarios {
    double calcular(Set<Funcionario> funcionarios, YearMonth pagoEm);
}
