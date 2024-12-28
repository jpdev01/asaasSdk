package io.github.jpdev.asaassdk.rest.paymentsplit;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class PaymentSplitPaidFetcher extends Fetcher<Split> {

    private final String id;

    public PaymentSplitPaidFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_SPLIT_PAID.addPathVariable(this.id);
    }

    @Override
    public Class<Split> getResourceClass() {
        return Split.class;
    }
}
