package br.com.jpdev01.asaassdk.rest.payment.children;

import br.com.jpdev01.asaassdk.utils.DiscountType;

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
