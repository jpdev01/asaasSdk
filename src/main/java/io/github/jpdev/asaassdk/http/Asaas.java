package io.github.jpdev.asaassdk.http;

public class Asaas {

    private static final String ENDPOINT_PRODUCTION = "https://api.asaas.com/v3";
    private static final String ENDPOINT_SANDBOX = "https://sandbox.asaas.com/api/v3";

    private static String token;
    private static Integer timeout;

    public static AsaasRestClient restClient;

    public static String baseUrl = ENDPOINT_PRODUCTION;

    public static synchronized void init(final String token) {
        Asaas.setToken(token);
    }

    public static synchronized void initSandbox(final String token) {
        Asaas.baseUrl = ENDPOINT_SANDBOX;
        Asaas.setToken(token);
    }

    public static void setToken(String token) {
        Asaas.token = token;
    }

    public static void setTimeout(Integer timeout) {
        Asaas.timeout = timeout;
    }

    public static AsaasRestClient getRestClient() {
        if (Asaas.restClient == null) {
            synchronized (Asaas.class) {
                if (Asaas.restClient == null) {
                    Asaas.restClient = buildRestClient();
                }
            }
        }

        return Asaas.restClient;
    }

    public static String getBaseUrl() {
        return Asaas.baseUrl;
    }

    private static AsaasRestClient buildRestClient() {
        if (Asaas.token == null) {
            throw new RuntimeException(
                    "AsaasRestClient was used before AuthToken were set, please call Asaas.init()"
            );
        }

        AsaasRestClient.Builder builder = new AsaasRestClient.Builder(Asaas.token, Asaas.timeout);

        return builder.build();
    }
}
