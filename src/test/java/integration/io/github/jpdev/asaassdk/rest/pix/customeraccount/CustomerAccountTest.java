package integration.io.github.jpdev.asaassdk.rest.pix.customeraccount;

import integration.io.github.jpdev.asaassdk.AsaasClientMock;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import org.junit.jupiter.api.*;

public class CustomerAccountTest {

    @BeforeAll
    static void setup() {
        AsaasClientMock.create();
    }

    @Test
    @Tag("integration")
    @DisplayName("Teste de criação de conta de cliente")
    @Order(1)
    void save() {
        String name = "Teste unitário";
        String cnpj = "10030823005";

        CustomerAccount.fetcher("cus_000072683044").fetch();
        CustomerAccount customerAccount = CustomerAccount.creator()
                .setName(name)
                .setCpfCnpj(cnpj)
                .create();

        Assertions.assertNotNull(customerAccount, "Conta de cliente não criada.");
        Assertions.assertEquals(name, customerAccount.getName(), "Nome da conta de cliente incorreto.");
        Assertions.assertEquals(cnpj, customerAccount.getCpfCnpj(), "CPF/CNPJ da conta de cliente incorreto.");
    }
}
