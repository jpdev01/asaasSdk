package io.github.jpdev.asaassdk.rest.pixautomatic.authorization;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Deleter;
import io.github.jpdev.asaassdk.rest.commons.DeletedResource;

public class PixAutomaticAuthorizationDeleter extends Deleter<PixAutomaticAuthorization> {

    private final String id;

    public PixAutomaticAuthorizationDeleter(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_AUTOMATIC_AUTHORIZATION.addPathVariable(this.id);
    }

    @Override
    public Class<PixAutomaticAuthorization> getResourceClass() {
        return PixAutomaticAuthorization.class;
    }
}
