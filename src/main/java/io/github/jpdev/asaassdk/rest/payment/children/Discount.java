package io.github.jpdev.asaassdk.rest.payment.children;

import io.github.jpdev.asaassdk.utils.DiscountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Discount {

    private BigDecimal value;
    private Integer dueDateLimitDays;
    private DiscountType type;
    private Date limitDate;

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

    public Date getLimitDate() {
        return limitDate;
    }

    public Discount setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
        return this;
    }
}
