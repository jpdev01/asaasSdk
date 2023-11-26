package br.com.jpdev01.asaassdk.rest.invoice;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

public class InvoiceFetcher extends Fetcher<Invoice> {

    private final String id;

    public InvoiceFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.INVOICE.addPathVariable(this.id);
    }

    @Override
    public Class<Invoice> getResourceClass() {
        return Invoice.class;
    }
}
