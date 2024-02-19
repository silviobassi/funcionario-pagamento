package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;

public class BuilderSecretario {
    private final Secretario secretario;

    public BuilderSecretario(String nome, LocalDate dataContratacao) {
        this.secretario = new Secretario(nome, dataContratacao);
    }

    public BuilderSecretario addPagamento(Pagamento pagamento) {
        this.secretario.getPagamentos().add(pagamento);
        return this;
    }

    public Secretario build() {
        return this.secretario;
    }
}