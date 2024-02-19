package com.silviobassi.pagamentofuncionario.core.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PagamentoTest {
    @Test
    void testCriacaoDePagamento() {
        Pagamento pagamento = new Pagamento(LocalDate.now());
        assertEquals(LocalDate.now(), pagamento.getData());
    }

    @Test
    void testVerificaSeTemPagamento() {
        LocalDate dataPagamento = LocalDate.now().minusDays(10);
        Pagamento pagamento = new Pagamento(dataPagamento);
        assertTrue(pagamento.temPagamento(YearMonth.from(dataPagamento)));
    }
}
