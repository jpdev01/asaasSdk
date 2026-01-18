package io.github.jpdev.asaassdk.rest.pixautomatic.authorization;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class PixAutomaticAuthorizationReader extends Reader<PixAutomaticAuthorization> {

    @Override
    public String getResourceUrl() {
        return Domain.PIX_AUTOMATIC_AUTHORIZATION.toString();
    }

    @Override
    public Class<PixAutomaticAuthorization> getResourceClass() {
        return PixAutomaticAuthorization.class;
    }
}
