package com.silviobassi.pagamentofuncionario.core.domain.service;

import com.silviobassi.pagamentofuncionario.core.domain.model.*;
import com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque.ComMaiorDeducaoImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque.ComMaiorRemuneracaoImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque.ComMaiorVendaImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.funcionariosdestaque.FuncionarioDestaque;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FuncionarioDestaqueTest {
    @Test
    void busca_funcionario_que_mais_ganhou_no_mes() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Funcionario vendedor = Vendedor.builder("Vendedor", LocalDate.now().minusYears(1))
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .build();
        Funcionario secretario = Secretario.builder("Secretário", LocalDate.now())
                .addPagamento(pagamento1)
                .build();
        Funcionario gerente = Gerente.builder("Gerente", LocalDate.now().minusDays(1))
                .addPagamento(pagamento1)
                .build();
        Set<Funcionario> funcionarios = Set.of(secretario, gerente, vendedor);
        FuncionarioDestaque funcionarioComMaiorRemuneracao = new ComMaiorRemuneracaoImpl();
        Funcionario result = funcionarioComMaiorRemuneracao.buscar(funcionarios, YearMonth.from(LocalDate.now()));
        assertEquals(gerente, result);
    }

    @Test
    void busca_funcionario_que_mais_ganhou_beneficios_no_mes() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Funcionario vendedor = Vendedor.builder("Vendedor", LocalDate.now().minusYears(1))
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .build();
        Funcionario secretario = Secretario.builder("Secretário", LocalDate.now())
                .addPagamento(pagamento1)
                .build();
        Funcionario gerente = Gerente.builder("Gerente", LocalDate.now().minusYears(1))
                .addPagamento(pagamento1)
                .build();
        Set<Funcionario> funcionarios = Set.of(secretario, gerente, vendedor);
        FuncionarioDestaque funcionarioComMaiorBeneficio = new ComMaiorDeducaoImpl();
        Funcionario result = funcionarioComMaiorBeneficio.buscar(funcionarios, YearMonth.from(LocalDate.now()));
        assertEquals(vendedor, result);
    }

    @Test
    void busca_funcionario_que_mais_vendeu_no_mes() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Funcionario anaSilva = Vendedor.builder("Ana Silva", LocalDate.of(2021, 12, 1))
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .build();
        Funcionario joaoMendes = Vendedor.builder("João Mendes", LocalDate.of(2021, 12, 1))
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 3400))
                .build();
        Set<Funcionario> funcionarios = Set.of(anaSilva, joaoMendes);
        FuncionarioDestaque funcionarioComMaiorVenda = new ComMaiorVendaImpl();
        Funcionario result = funcionarioComMaiorVenda.buscar(funcionarios, YearMonth.from(LocalDate.now()));
        assertEquals(anaSilva, result);
    }
}