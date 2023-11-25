package br.com.jpdev01.asaassdk.rest.payment.restore;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;
import br.com.jpdev01.asaassdk.rest.payment.Payment;

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
