package io.github.jpdev.asaassdk.rest.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jpdev.asaassdk.exception.ApiException;
import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.rest.ApiResource;
import io.github.jpdev.asaassdk.utils.JsonUtil;
import io.github.jpdev.asaassdk.http.AsaasRestClient;
import io.github.jpdev.asaassdk.http.Response;
import org.apache.http.HttpStatus;

public abstract class Creator<T> {

    public T create() {
        return create(Asaas.getRestClient());
    }

    public T create(final AsaasRestClient client) {
        Response response = client.post(getResourceUrl(), JsonUtil.toJSON(this));
        return parseResponse(client, response);
    }

    private T parseResponse(AsaasRestClient client, Response response) {
        if (response.getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
            throw new ApiException(HttpStatus.SC_BAD_REQUEST, response.getContent());
        }

        try {
            T objectResponse = client.getObjectMapper().readValue(response.getContent(), getResourceClass());
            if (objectResponse instanceof ApiResource) {
                ((ApiResource) objectResponse).setRateLimit(response.getRateLimit());
            }
            return objectResponse;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    @JsonIgnore
    public abstract String getResourceUrl();

    @JsonIgnore
    public abstract Class<T> getResourceClass();
}
