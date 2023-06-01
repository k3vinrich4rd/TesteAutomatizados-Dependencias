package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Funcionário com salário maior do " +
                    "que R$ 10000, não pode receber bônus");
        }
        //Para retornar duas casas decimais e definindo a regra de arredondamento
        return valor.setScale(2, RoundingMode.UP);
    }

}
