package br.com.jpdev01.asaassdk.rest.action;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.http.AsaasRestClient;
import br.com.jpdev01.asaassdk.http.Response;

import java.util.ArrayList;

public abstract class Reader<T> {

    public ResourceSet<T> read() {
        return read(Asaas.getRestClient());
    }

    public ResourceSet<T> read(final AsaasRestClient client) {
        Response response = client.get(getResourceUrl());
        return ResourceSet.fromJson(
                "data",
                response.getContent(),
                getResourceClass(),
                client.getObjectMapper()
        );
    }

    public abstract String getResourceUrl();
    public abstract Class<T> getResourceClass();
}
