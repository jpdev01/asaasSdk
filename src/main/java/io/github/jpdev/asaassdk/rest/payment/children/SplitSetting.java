package io.github.jpdev.asaassdk.rest.payment.children;

import java.math.BigDecimal;

public class SplitSetting {

    String walletId;
    BigDecimal fixedValue;
    BigDecimal percentualValue;

    public SplitSetting setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public SplitSetting setFixedValue(BigDecimal fixedValue) {
        if (percentualValue != null) throw new IllegalArgumentException("Cannot set both fixedValue and percentualValue");

        this.fixedValue = fixedValue;
        return this;
    }

    public SplitSetting setPercentualValue(BigDecimal percentualValue) {
        if (fixedValue != null) throw new IllegalArgumentException("Cannot set both fixedValue and percentualValue");

        this.percentualValue = percentualValue;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public BigDecimal getFixedValue() {
        return fixedValue;
    }

    public BigDecimal getPercentualValue() {
        return percentualValue;
    }
}
