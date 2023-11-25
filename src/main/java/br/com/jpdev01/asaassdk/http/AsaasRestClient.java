package br.com.jpdev01.asaassdk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        this.objectMapper = buildMapper();
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

    public Response put(String url, String body) {
        String completedUrl = Asaas.getBaseUrl() + "/" + url;
        return client.put(completedUrl, body);
    }

    public Response delete(String url, String body) {
        String completedUrl = Asaas.getBaseUrl() + "/" + url;
        return client.delete(completedUrl);
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


    private ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Date.class, new CustomDateDeserializer());
        module.setDeserializers(deserializers);

        mapper.registerModule(module);
        return mapper;
    }

    static class CustomDateDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<Date> {
        private final SimpleDateFormat dateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private final SimpleDateFormat dateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date deserialize(com.fasterxml.jackson.core.JsonParser jsonParser, com.fasterxml.jackson.databind.DeserializationContext deserializationContext)
                throws IOException {
            String date = jsonParser.getText();
            try {
                if (date.contains(":")) {
                    return dateFormatWithTime.parse(date);
                } else {
                    return dateFormatWithoutTime.parse(date);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
