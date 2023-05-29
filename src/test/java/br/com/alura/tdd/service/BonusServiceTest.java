package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComsalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Kevin", LocalDate.now(), new BigDecimal("25000")));

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("José", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);

    }

    @Test
    void bonusDeveriaSerExatamenteDezPorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}