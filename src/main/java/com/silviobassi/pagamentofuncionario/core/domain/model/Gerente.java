package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
    private static final double SALARIO = 20000;
    private static final double ABONO_ANUAL = 3000;
    private static final double BENEFICIO = 0;

    protected Gerente(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    public static BuilderGerente builder(String nome, LocalDate dataContratacao) {
        return new BuilderGerente(nome, dataContratacao);
    }

    public double getSalario() {
        return SALARIO;
    }

    @Override
    public double getDeducao() {
        return BENEFICIO;
    }

    @Override
    public double getAbonoAnual() {
        return temDireitoAbono() ? ABONO_ANUAL : 0;
    }
}


