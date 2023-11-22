package br.com.jpdev01.asaassdk.rest.action;

import br.com.jpdev01.asaassdk.exception.ApiException;
import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.http.AsaasRestClient;
import br.com.jpdev01.asaassdk.http.Response;
import br.com.jpdev01.asaassdk.utils.JsonUtil;
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
