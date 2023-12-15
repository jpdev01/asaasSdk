package io.github.jpdev.asaassdk.rest.paymentlink;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Deleter;
import io.github.jpdev.asaassdk.rest.commons.DeletedResource;

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
