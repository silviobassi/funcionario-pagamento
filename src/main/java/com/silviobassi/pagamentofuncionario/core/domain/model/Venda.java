package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

public class Venda {
    private final LocalDate data;
    private final double valor;
    private UUID id;

    public Venda(LocalDate data, double valor) {
        this.data = data;
        this.valor = valor;
        this.id = UUID.randomUUID();
    }

    public double getValor() {
        return this.valor;
    }

    public UUID getId() {
        return id;
    }

    public boolean temVenda(YearMonth vendaEm) {
        return this.data.getMonth().equals(vendaEm.getMonth());
    }
}
