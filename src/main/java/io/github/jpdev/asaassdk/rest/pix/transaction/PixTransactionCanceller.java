package io.github.jpdev.asaassdk.rest.pix.transaction;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

public class PixTransactionCanceller extends Creator<PixTransaction> {


    private final String id;

    public PixTransactionCanceller(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_TRANSACTION_CANCELLATION.toString().replace("$id", this.id);
    }

    @Override
    public Class<PixTransaction> getResourceClass() {
        return null;
    }
}
