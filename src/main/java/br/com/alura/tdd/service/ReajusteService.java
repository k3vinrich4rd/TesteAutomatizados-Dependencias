package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    //Strategy (Strategy pattern)
    public void concederReajuste(Funcionario funcionario, DesempenhoEnum desempenhoEnumEnum) {
        BigDecimal percentual = desempenhoEnumEnum.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }
}
