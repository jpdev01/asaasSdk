package br.com.jpdev01.asaassdk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import java.util.List;


public class AsaasRestClient {


    @Getter
    private final ObjectMapper objectMapper;
    private final String token;
    @Getter
    private final ApacheHttpClient client;
    @Getter
    private final List<String> userAgentExtensions;

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

    public static class Builder {
        private String token;

        private ApacheHttpClient httpClient;
        private List<String> userAgentExtensions;

        /**
         * Create a new Twilio Rest Client.
         *
         * @param token token to use
         */
        public Builder(final String token) {
            this.token = token;
        }

//        public Builder client(final HttpClient client) {
//            this.client = client;
//            return this;
//        }


        /**
         * Build new TwilioRestClient.
         *
         * @return TwilioRestClient instance
         */
        public AsaasRestClient build() {
            if (this.httpClient == null) {
                this.httpClient = new ApacheHttpClient(this.token);
            }
            return new AsaasRestClient(this);
        }
    }

}
