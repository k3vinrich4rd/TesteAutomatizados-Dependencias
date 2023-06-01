package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    //Testando uma exception
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComsalarioMuitoAlto() {
        BonusService bonusService = new BonusService();

        assertThrows(IllegalArgumentException.class, () ->
                bonusService.calcularBonus(new Funcionario("Kevin",
                        LocalDate.now(), new BigDecimal("25000"))));

    }

    //Testando uma exception (Segunda maneira)
    //Nessa forma é util para verificar se a mensagem está realmente vindo
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComsalarioMuitoAlto2() {
        BonusService bonusService = new BonusService();

        try {
            bonusService.calcularBonus(new Funcionario("Kevin",
                    LocalDate.now(), new BigDecimal("25000")));
            fail("Não lançou a exception");
        } catch (IllegalArgumentException illegalArgumentException) {
            //Verificando se a mensagem realmente está sendo retornada
            assertEquals("Funcionário com salário maior do que R$ 10000, " +
                    "não pode receber bônus", illegalArgumentException.getMessage());
        }
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("José", LocalDate.now(),
                new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);

    }

    @Test
    void bonusDeveriaSerExatamenteDezPorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carlos", LocalDate.now(),
                new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}