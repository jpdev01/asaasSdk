package br.com.jpdev01.asaassdk.utils;

import java.math.BigDecimal;

public class Money {

    public static BigDecimal create(BigDecimal bigDecimal) {
        bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal;
    }

    public static BigDecimal create(double value) {
        return create(new BigDecimal(value));
    }
}
