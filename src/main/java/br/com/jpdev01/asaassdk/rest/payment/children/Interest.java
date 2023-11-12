package br.com.jpdev01.asaassdk.rest.payment.children;

import br.com.jpdev01.asaassdk.utils.InterestTypeValue;

import java.math.BigDecimal;

public class Interest {

    private BigDecimal value;
    private InterestTypeValue type;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public InterestTypeValue getType() {
        return type;
    }

    public Interest setType(InterestTypeValue type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Interest{" + "value=" + value + '}';
    }

}
