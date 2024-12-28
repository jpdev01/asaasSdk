package unit.io.github.jpdev.asaassdk.http;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import integration.io.github.jpdev.asaassdk.AsaasClientMock;
import io.github.jpdev.asaassdk.exception.ConnectionException;
import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AsaasTest {

    @BeforeAll
    static void setup() {
        AsaasClientMock.create();
    }

    @Test
    @DisplayName("Teste de token informado")
    void testInformedToken() {
        assumeTrue(Asaas.getRestClient() != null, "Token da API não configurado.");
    }

    @Test
    @DisplayName("Teste de token incorreto")
    void testIncorrectToken() {
        assumeTrue(Asaas.getRestClient() != null, "Token da API não configurado.");

        Asaas.setToken("incorrectToken");
        assertThrowsExactly(ConnectionException.class, () -> Payment.reader().read());
    }
}