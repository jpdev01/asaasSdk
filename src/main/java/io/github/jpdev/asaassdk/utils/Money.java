package io.github.jpdev.asaassdk.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    public static BigDecimal create(BigDecimal originalValue) {
        return originalValue.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal create(double value) {
        BigDecimal parsed = new BigDecimal(value);
        return create(parsed);
    }
}
