package io.github.jpdev.asaassdk.rest.subscription;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Deleter;
import io.github.jpdev.asaassdk.rest.commons.DeletedResource;

public class SubscriptionDeleter extends Deleter<DeletedResource> {

    private final String id;

    public SubscriptionDeleter(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.SUBSCRIPTION.addPathVariable(this.id);
    }

    @Override
    public Class<DeletedResource> getResourceClass() {
        return DeletedResource.class;
    }
}
