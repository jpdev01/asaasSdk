package br.com.jpdev01.asaassdk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


public class AsaasRestClient {

    private final ObjectMapper objectMapper;
    private final String token;
    private final ApacheHttpClient client;
    private final List<String> userAgentExtensions;

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public String getToken() {
        return token;
    }

    public ApacheHttpClient getClient() {
        return client;
    }

    public List<String> getUserAgentExtensions() {
        return userAgentExtensions;
    }

    protected AsaasRestClient(Builder b) {
        this.token = b.token;
        this.client = b.httpClient;
        this.objectMapper = new ObjectMapper();
        this.userAgentExtensions = b.userAgentExtensions;
    }


    public Response post(String url, String body) {
        String completedUrl = Asaas.getBaseUrl() + "/" + url;
        return client.post(completedUrl, body);
    }

    public Response get(String url) {
        String completedUrl = Asaas.getBaseUrl() + "/" + url;
        return client.get(completedUrl);
    }

    public static class Builder {
        private String token;

        private ApacheHttpClient httpClient;
        private List<String> userAgentExtensions;

        public Builder(final String token) {
            this.token = token;
        }


        public AsaasRestClient build() {
            if (this.httpClient == null) {
                this.httpClient = new ApacheHttpClient(this.token);
            }
            return new AsaasRestClient(this);
        }
    }

}
