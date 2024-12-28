package integration.io.github.jpdev.asaassdk.rest.payment;

import integration.io.github.jpdev.asaassdk.AsaasClientMock;
import io.github.jpdev.asaassdk.rest.customeraccount.CustomerAccount;
import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.utils.BillingType;
import io.github.jpdev.asaassdk.utils.Money;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentTest {

    @BeforeAll
    static void setup() {
        AsaasClientMock.create();
    }

    @Test
    @Tag("integration")
    @DisplayName("Integração | Criação de cobrança Pix")
    @Order(1)
    void testCreatePixKey() {
        CustomerAccount customerAccount = getCustomerAccount();

        BigDecimal value = Money.create(5.01);
        Date dueDate = getDueDate();
        String description = "Teste unitário";
        String externalReference = UUID.randomUUID().toString();

        Payment payment = Payment.creator()
                        .setBillingType(BillingType.PIX)
                        .setCustomer(customerAccount.getId())
                        .setValue(value)
                        .setDueDate(dueDate)
                        .setDescription(description)
                        .setExternalReference(externalReference)
                        .create();

        assertNotNull(payment, "Cobrança não criada.");
        assertEquals(BillingType.PIX, payment.getBillingType(), "Tipo de cobrança incorreto.");
        assertEquals(value, Money.create(payment.getValue()), "Valor da cobrança incorreto.");
        assertEquals(dueDate, payment.getDueDate(), "Data de vencimento incorreta.");
        assertEquals(description, payment.getDescription(), "Descrição da cobrança incorreta.");
        assertEquals(externalReference, payment.getExternalReference(), "Referência externa incorreta.");
    }

    @Test
    @Tag("integration")
    @DisplayName("Integração | Criação de cobrança boleto")
    @Order(2)
    void testBoleto() {
        CustomerAccount customerAccount = getCustomerAccount();

        BigDecimal value = Money.create(5.01);
        Date dueDate = getDueDate();
        String description = "Teste unitário " + UUID.randomUUID();
        String externalReference = UUID.randomUUID().toString();

        Payment payment = Payment.creator()
                .setBillingType(BillingType.BOLETO)
                .setCustomer(customerAccount.getId())
                .setValue(value)
                .setDueDate(dueDate)
                .setDescription(description)
                .setExternalReference(externalReference)
                .create();

        assertNotNull(payment, "Cobrança não criada.");
        assertEquals(BillingType.BOLETO, payment.getBillingType(), "Tipo de cobrança incorreto.");
        assertEquals(value, Money.create(payment.getValue()), "Valor da cobrança incorreto.");
        assertEquals(dueDate, payment.getDueDate(), "Data de vencimento incorreta.");
        assertEquals(description, payment.getDescription(), "Descrição da cobrança incorreta.");
        assertEquals(externalReference, payment.getExternalReference(), "Referência externa incorreta.");
    }

    private Date getDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    private CustomerAccount getCustomerAccount() {
        CustomerAccount customerAccount = CustomerAccount.reader().read().getData().stream().findFirst().orElse(null);
        if (customerAccount == null) {
            customerAccount = CustomerAccount.creator()
                    .setName("Teste unitário")
                    .setCpfCnpj("06928316000124")
                    .setEmail("integration_example@gmail.com")
                    .create();
        }

        return customerAccount;
    }
}
