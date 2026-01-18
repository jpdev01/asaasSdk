package io.github.jpdev.asaassdk.rest.pixautomatic.authorization;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class PixAutomaticAuthorizationFetcher extends Fetcher<PixAutomaticAuthorization> {

    private final String id;

    public PixAutomaticAuthorizationFetcher(String id) {
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
