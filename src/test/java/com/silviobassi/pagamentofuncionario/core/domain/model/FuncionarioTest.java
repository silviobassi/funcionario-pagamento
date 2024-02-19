package com.silviobassi.pagamentofuncionario.core.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FuncionarioTest {
    @Test
    void testGerenteConstructor() {
        String expectedNome = "John Doe";
        LocalDate expectedDataContratacao = LocalDate.now();
        Funcionario gerente = Gerente.builder(expectedNome, expectedDataContratacao).build();
        assertNotNull(gerente);
        assertEquals(0, gerente.getDeducao());
        assertEquals(20000, gerente.getSalario());
    }

    @Test
    void testVendedorConstructor() {
        String expectedNome = "John Doe";
        LocalDate expectedDataContratacao = LocalDate.now();
        Funcionario vendedor = Vendedor.builder(expectedNome, expectedDataContratacao).build();
        assertEquals(12000, vendedor.getSalario());
        assertNotNull(vendedor);
    }

    @Test
    void testVendedorComVendasConstructor() {
        String expectedNome = "John Doe";
        LocalDate expectedDataContratacao = LocalDate.now();
        Funcionario vendedor = Vendedor.builder(expectedNome, expectedDataContratacao).build();
        Venda venda = new Venda(LocalDate.now(), 5200);
        vendedor.addVenda(venda);
        assertTrue(vendedor.temVendas());
        assertTrue(vendedor.temVendas());
    }

    @Test
    void testSecretarioConstructor() {
        String expectedNome = "John Doe";
        LocalDate expectedDataContratacao = LocalDate.now();
        Funcionario secretario = Secretario.builder(expectedNome, expectedDataContratacao).build();
        assertEquals(1400, secretario.getDeducao() * secretario.getSalario());
        assertEquals(7000, secretario.getSalario());
    }

    @Test
    void testTemDireitoAbono() {
        Funcionario gerente = Secretario.builder("John Doe", LocalDate.now().minusYears(2)).build();
        gerente.receberAbono(LocalDate.now().minusYears(1));
        Funcionario vendedor = Vendedor.builder("Jane Doe", LocalDate.now().minusMonths(6)).build();
        assertFalse(vendedor.temDireitoAbono());
        Funcionario secretario = Secretario.builder("Bob Smith", LocalDate.now().minusYears(2)).build();
        assertTrue(secretario.temDireitoAbono());
        Funcionario secretario2 = Secretario.builder("Alice Johnson", LocalDate.now().minusMonths(6)).build();
        assertFalse(secretario2.temDireitoAbono());
        assertTrue(gerente.temDireitoAbono());
    }

    @Test
    void tem_Pagamento() {
        LocalDate dataPagamento = LocalDate.now();
        Pagamento pagamento = new Pagamento(dataPagamento);
        assertTrue(pagamento.temPagamento(YearMonth.from(dataPagamento)));
    }

    @Test
    void nao_tem_Pagamento() {
        LocalDate dataPagamento = LocalDate.now();
        LocalDate dataSemPagamento = LocalDate.now().minusMonths(2);
        Pagamento pagamento = new Pagamento(dataPagamento);
        assertFalse(pagamento.temPagamento(YearMonth.from(dataSemPagamento)));
    }

    @Test
    void testCalculaBeneficio() {
        LocalDate dataContratacao = LocalDate.now();
        Funcionario gerente = Gerente.builder("Gerente", dataContratacao).build();
        Funcionario secretario = Secretario.builder("Secretário", dataContratacao).build();
        LocalDate dataVenda = LocalDate.now();
        Venda venda = new Venda(dataVenda, 5200);
        Funcionario vendedor = Vendedor.builder("Vendedor", dataContratacao).addVenda(venda).build();
        assertEquals(0, gerente.getDeducao() * gerente.getSalario());
        assertEquals(1400, secretario.getDeducao() * secretario.getSalario());
        assertEquals(1560, vendedor.getDeducao() * venda.getValor());
        assertEquals(7000, secretario.getSalario());
        assertEquals(12000, vendedor.getSalario());
        assertEquals(20000, gerente.getSalario());
    }
}
