package io.github.jpdev.asaassdk.rest.action;

import io.github.jpdev.asaassdk.exception.ApiException;
import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.http.AsaasRestClient;
import io.github.jpdev.asaassdk.http.Response;
import io.github.jpdev.asaassdk.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Updater<T> {

    public T update() {
        return update(Asaas.getRestClient());
    }

    public T update(AsaasRestClient client) {
        Response response = client.put(getResourceUrl(), JsonUtil.toJSON(this));
        return parseResponse(client.getObjectMapper(), response);
    }

    private T parseResponse(ObjectMapper objectMapper, Response response) {
        if (response.getStatusCode() == 400) {
            throw new ApiException(400, response.getContent());
        }

        try {
            return objectMapper.readValue(response.getContent(), getResourceClass());
        } catch (Exception e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    public abstract String getResourceUrl();

    public abstract Class<T> getResourceClass();
}
