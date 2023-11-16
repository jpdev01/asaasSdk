package br.com.jpdev01.asaassdk.rest.pix.transaction;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

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
