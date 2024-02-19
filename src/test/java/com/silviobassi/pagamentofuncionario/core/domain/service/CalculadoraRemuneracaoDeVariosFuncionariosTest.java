package com.silviobassi.pagamentofuncionario.core.domain.service;

import com.silviobassi.pagamentofuncionario.core.domain.model.*;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraDeducoesImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraSalariosDeducoesImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.calculadoras.CalculadoraSalariosImpl;
import com.silviobassi.pagamentofuncionario.core.domain.service.maioresremuneracoes.CalculadoraRemuneracaoDeVariosFuncionarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Set;

@SpringBootTest
class CalculadoraRemuneracaoDeVariosFuncionariosTest {
    @Test
    void deve_calcularTotal_de_salarioNoMes_dado_umaLista_de_Funcionarios() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Pagamento pagamento2 = new Pagamento(LocalDate.now().minusMonths(1));
        Set<Funcionario> funcionarios = Set.of(
                Vendedor.builder("Vendedor", LocalDate.now())
                        .addPagamento(pagamento1)
                        .build(),
                Secretario.builder("Secretário", LocalDate.now())
                        .addPagamento(pagamento1)
                        .build(),
                Gerente.builder("Gerente", LocalDate.now().minusDays(1))
                        .addPagamento(pagamento2)
                        .build()
        );
        CalculadoraRemuneracaoDeVariosFuncionarios totalSalario = new CalculadoraSalariosImpl();
        double result = totalSalario.calcular(funcionarios, YearMonth.from(LocalDate.now()));
        Assertions.assertEquals(19000, result, 0.001);
    }

    @Test
    void deve_calcularTotal_de_beneficiosNoMes_semAbono_dado_umaLista_de_Funcionarios() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Pagamento pagamento2 = new Pagamento(LocalDate.now().minusMonths(1));
        Funcionario vendedor = Vendedor.builder("Vendedor", LocalDate.now())
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .addVenda(new Venda(LocalDate.now().minusMonths(1), 4000))
                .build();
        Set<Funcionario> funcionarios = Set.of(
                vendedor,
                Secretario.builder("Secretário", LocalDate.now())
                        .addPagamento(pagamento1)
                        .build(),
                Gerente.builder("Gerente", LocalDate.now().minusDays(1))
                        .addPagamento(pagamento2)
                        .build()
        );

        CalculadoraRemuneracaoDeVariosFuncionarios totalBeneficio = new CalculadoraDeducoesImpl();
        double result = totalBeneficio.calcular(funcionarios, YearMonth.from(LocalDate.now()));
        Assertions.assertEquals(2960, result, 0.001);
    }

    @Test
    void deve_calcularTotal_de_beneficiosNoMes_comAbono_dado_umaLista_de_Funcionarios() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Pagamento pagamento2 = new Pagamento(LocalDate.now().minusMonths(1));
        Funcionario vendedor = Vendedor.builder("Vendedor", LocalDate.now().minusYears(1))
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .addVenda(new Venda(LocalDate.now().minusMonths(1), 4000))
                .build();
        Set<Funcionario> funcionarios = Set.of(
                vendedor,
                Secretario.builder("Secretário", LocalDate.now())
                        .addPagamento(pagamento1)
                        .build(),
                Gerente.builder("Gerente", LocalDate.now().minusDays(1))
                        .addPagamento(pagamento2)
                        .build()
        );
        CalculadoraRemuneracaoDeVariosFuncionarios totalBeneficio = new CalculadoraDeducoesImpl();
        double result = totalBeneficio.calcular(funcionarios, YearMonth.from(LocalDate.now()));
        Assertions.assertEquals(4760, result, 0.001);
    }

    @Test
    void deve_calcularTotal_de_salarioBeneficiosNoMes_semAbono_dado_umaLista_de_Funcionarios() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now());
        Pagamento pagamento2 = new Pagamento(LocalDate.now().minusMonths(1));
        Funcionario vendedor = Vendedor.builder("Vendedor", LocalDate.now())
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .addVenda(new Venda(LocalDate.now().minusMonths(1), 4000))
                .build();
        Set<Funcionario> funcionarios = Set.of(
                vendedor,
                Secretario.builder("Secretário", LocalDate.now())
                        .addPagamento(pagamento1)
                        .build(),
                Gerente.builder("Gerente", LocalDate.now().minusDays(1))
                        .addPagamento(pagamento2)
                        .build()
        );
        CalculadoraRemuneracaoDeVariosFuncionarios totalSalarioBeneficio = new CalculadoraSalariosDeducoesImpl();
        double result = totalSalarioBeneficio.calcular(funcionarios, YearMonth.from(LocalDate.now()));
        Assertions.assertEquals(21960, result, 0.001);
    }

    @Test
    void deve_calcularTotal_de_salarioBeneficiosNoMes_comAbono_dado_umaLista_de_Funcionarios() {
        Pagamento pagamento1 = new Pagamento(LocalDate.now().minusMonths(1));
        Pagamento pagamento2 = new Pagamento(LocalDate.now());
        Funcionario vendedor = Vendedor.builder("Vendedor", LocalDate.now())
                .addPagamento(pagamento1)
                .addVenda(new Venda(LocalDate.now(), 5200))
                .addVenda(new Venda(LocalDate.now().minusMonths(1), 4000))
                .build();
        Set<Funcionario> funcionarios = Set.of(
                vendedor,
                Secretario.builder("Secretário", LocalDate.now())
                        .addPagamento(pagamento1)
                        .build(),
                Gerente.builder("Gerente", LocalDate.now().minusYears(1))
                        .addPagamento(pagamento2)
                        .build()
        );
        CalculadoraRemuneracaoDeVariosFuncionarios totalSalarioDeducao = new CalculadoraSalariosDeducoesImpl();
        double result = totalSalarioDeducao.calcular(funcionarios, YearMonth.from(LocalDate.now()));
        Assertions.assertEquals(23000, result, 0.001);
    }
}
