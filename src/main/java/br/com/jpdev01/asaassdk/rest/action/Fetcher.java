package br.com.jpdev01.asaassdk.rest.action;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.http.AsaasRestClient;
import br.com.jpdev01.asaassdk.http.Response;
import com.fasterxml.jackson.core.type.TypeReference;

public abstract class Fetcher<T> {

    public T fetch() {
        return fetch(Asaas.getRestClient());
    }

    public T fetch(final AsaasRestClient client) {
        try {
            Response response = client.get(getResourceUrl());
            TypeReference<T> typeReference = new TypeReference<T>() {
            };
            return client.getObjectMapper().readValue(response.toString(), typeReference);
        } catch (Exception exception) {
            return null;
        }
    }

    public abstract String getResourceUrl();
}
