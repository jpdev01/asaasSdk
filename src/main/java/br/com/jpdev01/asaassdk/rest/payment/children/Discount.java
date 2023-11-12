package br.com.jpdev01.asaassdk.rest.payment.children;

import br.com.jpdev01.asaassdk.utils.DiscountType;

import java.math.BigDecimal;

public class Discount {

    private BigDecimal value;
    private Integer dueDateLimitDays;
    private DiscountType type;

    public Discount() {
    }
    
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public void setDueDateLimitDays(Integer dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
    }

    public DiscountType getType() {
        return type;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }

}
