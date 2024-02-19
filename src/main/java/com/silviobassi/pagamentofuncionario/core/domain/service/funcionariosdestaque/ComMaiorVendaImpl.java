package com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraVendas;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.Set;

public class ComMaiorVendaImpl implements FuncionarioDestaque {
    @Override
    public Funcionario buscar(Set<Funcionario> vendedores, YearMonth data) {
        return vendedores.stream()
                .max(Comparator.comparing(funcionario -> CalculadoraVendas.calcular(funcionario, data)))
                .orElse(null);
    }
}
