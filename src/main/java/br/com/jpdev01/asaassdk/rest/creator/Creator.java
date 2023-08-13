package br.com.jpdev01.asaassdk.rest.creator;

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
        return parseResponse(response.getContent());
    }

    private T parseResponse(String content) {
        try {
            return objectMapper.readValue(content, getResourceClass());
        } catch (Exception e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    public abstract String getResourceUrl();
    public abstract Class<T> getResourceClass();
}
