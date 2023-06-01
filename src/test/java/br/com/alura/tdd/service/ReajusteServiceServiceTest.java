package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Kevin", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Kevin", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoOtimo() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Kevin", LocalDate.now(), new BigDecimal("1000.0"));
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }


}
