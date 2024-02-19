package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;

public class BuilderVendedor {
    private final Vendedor vendedor;

    public BuilderVendedor(String nome, LocalDate dataContratacao) {
        this.vendedor = new Vendedor(nome, dataContratacao);
    }

    public BuilderVendedor addVenda(Venda venda) {
        this.vendedor.getVendas().add(venda);
        return this;
    }

    public BuilderVendedor addPagamento(Pagamento pagamento) {
        this.vendedor.getPagamentos().add(pagamento);
        return this;
    }

    public Vendedor build() {
        return this.vendedor;
    }
}