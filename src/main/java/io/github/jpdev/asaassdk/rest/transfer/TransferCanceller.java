package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

public class TransferCanceller extends Creator<Transfer> {

    private final String id;

    public TransferCanceller(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_TRANSACTION_CANCELLATION.toString().replace("$id", this.id);
    }

    @Override
    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
