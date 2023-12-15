package io.github.jpdev.asaassdk.rest.payment.children;

import io.github.jpdev.asaassdk.utils.DiscountType;

import java.math.BigDecimal;

public class DiscountSetting {

    BigDecimal value;
    DiscountType discountType;

    public DiscountSetting setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public DiscountSetting setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
        return this;
    }
}
