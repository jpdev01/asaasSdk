package br.com.jpdev01.asaassdk.rest.action;

import br.com.jpdev01.asaassdk.exception.ApiException;
import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.utils.JsonUtil;
import br.com.jpdev01.asaassdk.http.AsaasRestClient;
import br.com.jpdev01.asaassdk.http.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Creator<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public T create() {
        return create(Asaas.getRestClient());
    }

    public T create(final AsaasRestClient client) {
        Response response = client.post(getResourceUrl(), JsonUtil.toJSON(this));
        return parseResponse(response);
    }

    private T parseResponse(Response response) {
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
