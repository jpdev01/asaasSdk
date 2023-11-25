package br.com.jpdev01.asaassdk.rest.payment.status;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

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
        return null;
    }
}
