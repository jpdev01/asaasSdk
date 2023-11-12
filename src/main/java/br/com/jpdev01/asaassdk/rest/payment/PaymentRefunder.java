package br.com.jpdev01.asaassdk.rest.payment;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;

import java.math.BigDecimal;

public class PaymentRefunder extends Creator<Payment> {

    private Long id;

    public BigDecimal value;

    public PaymentRefunder(final Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PaymentRefunder setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.REFUND_PAYMENT.toString().replace("$id", this.id.toString());
    }

    @Override
    public Class<Payment> getResourceClass() {
        return Payment.class;
    }
}
