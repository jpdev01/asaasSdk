package io.github.jpdev.asaassdk.rest.action;

import io.github.jpdev.asaassdk.exception.ApiException;
import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.utils.JsonUtil;
import io.github.jpdev.asaassdk.http.AsaasRestClient;
import io.github.jpdev.asaassdk.http.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Creator<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public T create() {
        return create(Asaas.getRestClient());
    }

    public T create(final AsaasRestClient client) {
        Response response = client.post(getResourceUrl(), JsonUtil.toJSON(this));
        return parseResponse(client, response);
    }

    private T parseResponse(AsaasRestClient client, Response response) {
        if (response.getStatusCode() == 400) {
            throw new ApiException(400, response.getContent());
        }

        try {
            return client.getObjectMapper().readValue(response.getContent(), getResourceClass());
        } catch (Exception e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    public abstract String getResourceUrl();
    public abstract Class<T> getResourceClass();
}
