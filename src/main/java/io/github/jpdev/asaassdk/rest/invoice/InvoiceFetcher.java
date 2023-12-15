package io.github.jpdev.asaassdk.rest.invoice;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

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
