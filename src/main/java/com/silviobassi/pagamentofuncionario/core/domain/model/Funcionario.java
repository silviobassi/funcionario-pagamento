package com.silviobassi.pagamentofuncionario.core.domain.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*
 * @class Vendedor subscreve estes métodos para que sejam acessados a partir desta classe:
 * @method getVendas
 * @method addVenda
 * @method temVendas
 */
public abstract class Funcionario {
    private final UUID id;
    private final String nome;
    private final LocalDate dataContratacao;
    private Set<Pagamento> pagamentos = new HashSet<>();
    private LocalDate ultimoPagamentoAbono;

    protected Funcionario(String nome, LocalDate dataContratacao) {
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.id = UUID.randomUUID();
    }

    public abstract double getSalario();

    public abstract double getDeducao();

    public abstract double getAbonoAnual();

    public UUID getId() {
        return id;
    }

    public Set<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public boolean temDireitoAbono() {
        return ChronoUnit.YEARS.between(getDataReferencia(), getDataAtual()) >= 1;
    }

    public Set<Venda> getVendas() {
        return Collections.emptySet();
    }

    public void addVenda(Venda venda) {
    }

    public boolean temVendas() {
        return false;
    }

    public void receberAbono(LocalDate ultimoPagamentoAbono) {
        this.ultimoPagamentoAbono = ultimoPagamentoAbono;
    }

    private LocalDate getDataReferencia() {
        return (ultimoPagamentoAbono == null) ? dataContratacao : ultimoPagamentoAbono;
    }

    private LocalDate getDataAtual() {
        return LocalDate.now();
    }
}
