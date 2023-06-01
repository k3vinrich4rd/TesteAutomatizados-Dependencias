package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void instanciarObjeto() {
        System.out.println("inicializa");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Kevin", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("fim");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("ANTES DE TODOS");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("DEPOIS DE TODOS");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoBom() {
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoOtimo() {
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
