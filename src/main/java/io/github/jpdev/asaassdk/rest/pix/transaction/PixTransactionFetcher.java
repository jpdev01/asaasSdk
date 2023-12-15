package io.github.jpdev.asaassdk.rest.pix.transaction;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class PixTransactionFetcher extends Fetcher<PixTransaction> {

    Object id;

    public PixTransactionFetcher(Object id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_TRANSACTION.addPathVariable(id.toString());
    }

    @Override
    public Class<PixTransaction> getResourceClass() {
        return PixTransaction.class;
    }
}
