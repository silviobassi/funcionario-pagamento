package com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraRemuneracaoDeUmFuncionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraSalariosDeducoesImpl;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.Set;

public class ComMaiorRemuneracaoImpl implements FuncionarioDestaque {
    @Override
    public Funcionario buscar(Set<Funcionario> funcionarios, YearMonth data) {
        CalculadoraRemuneracaoDeUmFuncionario salarioDeducao = new CalculadoraSalariosDeducoesImpl();
        return funcionarios.stream()
                .max(Comparator.comparing(funcionario -> salarioDeducao.calcular(funcionario, data)))
                .orElse(null);
    }
}
