package io.github.jpdev.asaassdk.rest.payment.restore;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.payment.Payment;

public class PaymentRestorer extends Creator<Payment> {

    private final String id;

    public PaymentRestorer(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_RESTORE.toString().replace("$id", this.id);
    }

    @Override
    public Class<Payment> getResourceClass() {
        return Payment.class;
    }
}
