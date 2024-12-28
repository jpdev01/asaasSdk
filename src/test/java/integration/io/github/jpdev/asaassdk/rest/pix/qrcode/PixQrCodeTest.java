package integration.io.github.jpdev.asaassdk.rest.pix.qrcode;

import integration.io.github.jpdev.asaassdk.AsaasClientMock;
import io.github.jpdev.asaassdk.rest.pix.qrcode.PixQrCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import io.github.jpdev.asaassdk.utils.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PixQrCodeTest {

    @BeforeAll
    static void setup() {
        AsaasClientMock.create();
    }

    @Test
    @Tag("integration")
    @DisplayName("Teste de criação de QR Code Pix")
    void creating() {
        BigDecimal value = Money.create(10.0);
        String description = "Teste unitário";
        Integer expirationSeconds = 100;

        PixQrCode qrCode = PixQrCode.creator()
                .setValue(value)
                .setDescription(description)
                .setExpirationSeconds(expirationSeconds)
                .create();

        assertNotNull(qrCode, "QR Code não criado.");
        assertNotNull(qrCode.expirationDate);
    }
}
