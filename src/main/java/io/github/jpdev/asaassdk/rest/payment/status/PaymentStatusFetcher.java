package io.github.jpdev.asaassdk.rest.payment.status;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class PaymentStatusFetcher extends Fetcher<PaymentStatusData> {

    private final String id;

    public PaymentStatusFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_STATUS.toString().replace("$id", this.id);
    }

    @Override
    public Class<PaymentStatusData> getResourceClass() {
        return PaymentStatusData.class;
    }
}
