package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class TransferFetcher extends Fetcher<Transfer> {

    String id;

    public TransferFetcher(String id) {
        this.id = id;
    }


    @Override
    public String getResourceUrl() {
        return Domain.TRANSFER.addPathVariable(this.id);
    }

    @Override
    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
