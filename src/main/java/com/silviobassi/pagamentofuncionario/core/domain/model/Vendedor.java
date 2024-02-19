package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Vendedor extends Funcionario {
    private static final double SALARIO = 12000;
    private static final double ABONO_ANUAL = 1800;
    private static final double BENEFICIO = 0.3;
    private final Set<Venda> vendas = new HashSet<>();

    protected Vendedor(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    public static BuilderVendedor builder(String nome, LocalDate dataContratacao) {
        return new BuilderVendedor(nome, dataContratacao);
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

    @Override
    public Set<Venda> getVendas() {
        return vendas;
    }

    @Override
    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }

    @Override
    public boolean temVendas() {
        return !vendas.isEmpty();
    }

}
