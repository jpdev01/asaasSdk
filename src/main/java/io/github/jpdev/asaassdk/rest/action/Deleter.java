package io.github.jpdev.asaassdk.rest.action;

import io.github.jpdev.asaassdk.exception.ApiException;
import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.http.AsaasRestClient;
import io.github.jpdev.asaassdk.http.Response;
import io.github.jpdev.asaassdk.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;

public abstract class Deleter<T> {

    public T delete() {
        return delete(Asaas.getRestClient());
    }

    public T delete(final AsaasRestClient client) {
        Response response = client.delete(getResourceUrl(), JsonUtil.toJSON(this));
        return parseResponse(client, response);
    }

    private T parseResponse(AsaasRestClient client, Response response) {
        if (response.getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
            throw new ApiException(HttpStatus.SC_BAD_REQUEST, response.getContent());
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
