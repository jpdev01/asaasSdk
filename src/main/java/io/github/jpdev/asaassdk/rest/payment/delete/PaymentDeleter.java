package io.github.jpdev.asaassdk.rest.payment.delete;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Deleter;
import io.github.jpdev.asaassdk.rest.commons.DeletedResource;

public class PaymentDeleter extends Deleter<DeletedResource> {

    private final String id;

    public PaymentDeleter(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT.addPathVariable(this.id);
    }

    @Override
    public Class<DeletedResource> getResourceClass() {
        return DeletedResource.class;
    }
}
