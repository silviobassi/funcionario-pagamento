package com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraDeducoesImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraRemuneracaoDeUmFuncionario;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.Set;

public class ComMaiorDeducaoImpl implements FuncionarioDestaque {
    @Override
    public Funcionario buscar(Set<Funcionario> funcionarios, YearMonth data) {
        CalculadoraRemuneracaoDeUmFuncionario beneficio = new CalculadoraDeducoesImpl();
        return funcionarios.stream()
                .max(Comparator.comparing(funcionario -> beneficio.calcular(funcionario, data)))
                .orElse(null);
    }

}