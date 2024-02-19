package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;

public class BuilderGerente {
    private final Gerente gerente;

    public BuilderGerente(String nome, LocalDate dataContratacao) {
        this.gerente = new Gerente(nome, dataContratacao);
    }

    public BuilderGerente addPagamento(Pagamento pagamento) {
        this.gerente.getPagamentos().add(pagamento);
        return this;
    }

    public Gerente build() {
        return this.gerente;
    }
}