package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, DesempenhoEnum desempenhoEnumEnum) {
        if (desempenhoEnumEnum == DesempenhoEnum.A_DESEJAR) {
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
            funcionario.reajustarSalario(reajuste);
        } else if (desempenhoEnumEnum == DesempenhoEnum.BOM) {
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
            funcionario.reajustarSalario(reajuste);
        } else {
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.2"));
            funcionario.reajustarSalario(reajuste);
        }
    }
}
