package io.github.jpdev.asaassdk.rest.action;

import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.http.AsaasRestClient;
import io.github.jpdev.asaassdk.http.Response;

public abstract class Fetcher<T> {

    public T fetch() {
        return fetch(Asaas.getRestClient());
    }

    public T fetch(final AsaasRestClient client) {
        try {
            Response response = client.get(getResourceUrl());

            return client.getObjectMapper().readValue(response.getContent(), getResourceClass());
        } catch (Exception exception) {
            return null;
        }
    }

    public abstract String getResourceUrl();

    public abstract Class<T> getResourceClass();
}
