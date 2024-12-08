package io.github.jpdev.asaassdk.rest.paymentsplit;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class PaymentSplitReceivedReader extends Reader<Split> {

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_SPLIT_RECEIVED.toString();
    }

    @Override
    public Class<Split> getResourceClass() {
        return Split.class;
    }
}
