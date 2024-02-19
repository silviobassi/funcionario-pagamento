package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;

public class Secretario extends Funcionario {
    private static final double SALARIO = 7000;
    private static final double ABONO_ANUAL = 1200;
    private static final double BENEFICIO = 0.2;

    protected Secretario(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    public static BuilderSecretario builder(String nome, LocalDate dataContratacao) {
        return new BuilderSecretario(nome, dataContratacao);
    }

    @Override
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
