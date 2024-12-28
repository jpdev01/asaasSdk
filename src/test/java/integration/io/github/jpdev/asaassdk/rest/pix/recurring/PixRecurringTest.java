package integration.io.github.jpdev.asaassdk.rest.pix.recurring;

import integration.io.github.jpdev.asaassdk.AsaasClientMock;
import integration.io.github.jpdev.asaassdk.CustomMockUtils;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.rest.transfer.children.PixRecurring;
import io.github.jpdev.asaassdk.rest.transfer.children.PixRecurringFrequency;
import io.github.jpdev.asaassdk.utils.Money;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PixRecurringTest {

    private static String recurringId;
    private static PixRecurringFrequency recurringFrequency;
    private static Integer recurringQuantity;

    @BeforeAll
    static void setup() {
        AsaasClientMock.create();
    }

    @Test
    @Tag("integration")
    @Order(1)
    @DisplayName("Teste de criação de recorrência")
    void save() {
        BigDecimal value = CustomMockUtils.randomValue();
        recurringFrequency = PixRecurringFrequency.MONTHLY;
        recurringQuantity = new Random().nextInt(8) + 1;

        PixRecurring recurring = new PixRecurring()
                .setFrequency(PixRecurringFrequency.MONTHLY)
                .setQuantity(2);

        Transfer transfer = Transfer.pixAddressKeyCreator()
                .setPixAddressKey("+5547999999999")
                .setValue(value)
                .setDescription("teste")
                .setPixAddressKeyType(PixAddressKeyType.PHONE)
                .setRecurring(recurring)
                .create();

        assertNotNull(transfer, "Transferência não criada.");
        assertNotNull(transfer.getRecurring());

        recurringId = transfer.getRecurring();
    }

    @Test
    @Tag("integration")
    @Order(2)
    @DisplayName("Teste de leitura de recorrência")
    void fetcher() {
        assumeTrue(recurringId != null, "Recorrência não criada.");

        PixRecurring recurring = PixRecurring.fetcher(recurringId)
                .fetch();

        assertNotNull(recurring, "Recorrência não encontrada.");
        assertEquals(recurringFrequency, recurring.getFrequency(), "Frequência incorreta.");
        assertEquals(recurringQuantity, recurring.getQuantity(), "Quantidade incorreta.");
    }
}
