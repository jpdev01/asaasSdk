package br.com.jpdev01.asaassdk.rest.payment.delete;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Deleter;

public class PaymentDeleter extends Deleter<PaymentDeleted> {

    private final String id;

    public PaymentDeleter(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT.addPathVariable(this.id);
    }

    @Override
    public Class<PaymentDeleted> getResourceClass() {
        return PaymentDeleted.class;
    }
}
