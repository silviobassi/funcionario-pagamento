package com.silviobassi.pagamentofuncionario.core.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VendaTest {
    @Test
    void testVenda() {
        LocalDate expectedVendaEm = LocalDate.now();
        double expectedValor = 5200;
        Venda venda = new Venda(expectedVendaEm, expectedValor);
        assertEquals(expectedValor, venda.getValor(), 0.001);
    }

    @Test
    void tem_Venda() {
        LocalDate expectedVendaEm = LocalDate.now();
        double expectedValor = 5200;
        Venda venda = new Venda(expectedVendaEm, expectedValor);
        assertTrue(venda.temVenda(YearMonth.from(expectedVendaEm)));
    }

    @Test
    void nao_tem_Venda() {
        LocalDate expectedVendaEm = LocalDate.now().minusMonths(2);
        LocalDate dataSemVenda = LocalDate.now().minusMonths(3);
        double expectedValor = 5200;
        Venda venda = new Venda(expectedVendaEm, expectedValor);
        assertFalse(venda.temVenda(YearMonth.from(dataSemVenda)));
    }
}
