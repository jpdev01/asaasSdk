package io.github.jpdev.asaassdk.rest.paymentsplit;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class PaymentSplitPaidReader extends Reader<Split> {

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_SPLIT_PAID.toString();
    }

    @Override
    public Class<Split> getResourceClass() {
        return Split.class;
    }
}
