package br.com.jpdev01.asaassdk.rest.pix.transaction;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;
import br.com.jpdev01.asaassdk.utils.pix.PixTransactionStatus;
import br.com.jpdev01.asaassdk.utils.pix.PixTransactionType;

public class PixTransactionReader extends Reader<PixTransaction> {

    public PixTransactionStatus status;
    public PixTransactionType type;
    public String endToEndIdentifier;

    public PixTransactionReader setStatus(PixTransactionStatus status) {
        addFilter("status");
        this.status = status;
        return this;
    }

    public PixTransactionReader setType(PixTransactionType type) {
        addFilter("type");
        this.type = type;
        return this;
    }

    public PixTransactionReader setEndToEndIdentifier(String endToEndIdentifier) {
        addFilter("endToEndIdentifier");
        this.endToEndIdentifier = endToEndIdentifier;
        return this;
    }


    @Override
    public String getResourceUrl() {
        return Domain.PIX_TRANSACTION.toString();
    }

    @Override
    public Class<PixTransaction> getResourceClass() {
        return PixTransaction.class;
    }
}
