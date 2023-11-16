package br.com.jpdev01.asaassdk.rest.pix.transaction;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;

public class PixTransactionReader extends Reader<PixTransaction> {
    @Override
    public String getResourceUrl() {
        return Domain.PIX_TRANSACTION.toString();
    }

    @Override
    public Class<PixTransaction> getResourceClass() {
        return PixTransaction.class;
    }
}
