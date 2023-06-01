package br.com.alura.tdd.enums;

import java.math.BigDecimal;

public enum DesempenhoEnum {


    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal percentualReajuste();
}


//Outra forma menos enxuta de se fazer esse enum
//public enum DesempenhoEnum {
//
//
//
//    A_DESEJAR(new BigDecimal("0.03")),
//    BOM(new BigDecimal("0.15")),
//    OTIMO(new BigDecimal("0.2"));
//
//    public final BigDecimal percentualReajuste;
//
//    DesempenhoEnum(BigDecimal percentualReajuste) {
//        this.percentualReajuste = percentualReajuste;
//    }
//}

