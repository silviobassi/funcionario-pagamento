package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

public class Pagamento {
    private final LocalDate data;
    private UUID id;

    public Pagamento(LocalDate data) {
        this.data = data;
        this.id = UUID.randomUUID();
    }

    public boolean temPagamento(YearMonth pagamentoEm) {
        return this.data.getMonth().equals(pagamentoEm.getMonth());
    }

    public LocalDate getData() {
        return data;
    }

    public UUID getId() {
        return id;
    }
}
