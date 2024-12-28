package io.github.jpdev.asaassdk.rest.paymentsplit;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class PaymentSplitReceivedFetcher extends Fetcher<Split> {

    private final String id;

    public PaymentSplitReceivedFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_SPLIT_RECEIVED.addPathVariable(this.id);
    }

    @Override
    public Class<Split> getResourceClass() {
        return Split.class;
    }
}
