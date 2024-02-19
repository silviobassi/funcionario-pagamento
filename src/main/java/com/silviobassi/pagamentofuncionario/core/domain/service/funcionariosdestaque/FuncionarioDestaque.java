package com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque;

import com.silviobassi.pagamentofuncionario.core.domain.model.Funcionario;

import java.time.YearMonth;
import java.util.Set;

public interface FuncionarioDestaque {
    Funcionario buscar(Set<Funcionario> funcionarios, YearMonth data);
}
