package io.github.jpdev.asaassdk;

import io.github.jpdev.asaassdk.http.Asaas;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AsaasClientMock {

    public static void create() {
        Asaas.initSandbox(getApiToken());
    }

    private static String getApiToken() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo de configuração.", e);
        }
        return properties.getProperty("test.asaas.api.token");
    }
}
