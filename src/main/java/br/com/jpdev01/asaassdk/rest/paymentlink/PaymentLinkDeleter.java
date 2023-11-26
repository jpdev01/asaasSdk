package br.com.jpdev01.asaassdk.rest.paymentlink;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Deleter;
import br.com.jpdev01.asaassdk.rest.commons.DeletedResource;

public class PaymentLinkDeleter extends Deleter<DeletedResource> {

    private final String id;

    public PaymentLinkDeleter(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_LINK.addPathVariable(this.id);
    }

    @Override
    public Class<DeletedResource> getResourceClass() {
        return DeletedResource.class;
    }
}
