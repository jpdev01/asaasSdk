package io.github.jpdev.asaassdk.rest.pix.transaction;

import io.github.jpdev.asaassdk.AsaasClientMock;
import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.rest.action.ResourceSet;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;
import io.github.jpdev.asaassdk.rest.transfer.Transfer;
import io.github.jpdev.asaassdk.rest.transfer.children.response.TransferOperationType;
import io.github.jpdev.asaassdk.utils.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class PixTransactionTest {

    @BeforeAll
    static void setup() {
        AsaasClientMock.create();
    }

    @Test
    @DisplayName("Integração | Criação de transação Pix com chave")
    @Order(1)
    void testCreatePixKey() {
        BigDecimal value = BigDecimal.valueOf(0.01);

        Transfer transfer = Transfer.pixAddressKeyCreator()
                .setPixAddressKey("+5547999999999")
                .setPixAddressKeyType(PixAddressKeyType.PHONE)
                .setValue(value)
                .setDescription("Teste unitário")
                .create();

        assertNotNull(transfer, "Transferência não criada.");
        assertEquals(value, Money.create(transfer.getValue()), "Valor da transferência incorreto.");
        assertEquals("Teste unitário", transfer.getDescription(), "Descrição da transferência incorreta.");
        assertEquals(TransferOperationType.PIX, transfer.getOperationType(), "Tipo de operação incorreto.");
    }

    @Test
    @DisplayName("Integração | Leitura de transação Pix")
    @Order(2)
    void testListing() {
        List<Transfer> transferList = Transfer.reader().read().getData();
        assumeTrue(transferList != null && !transferList.isEmpty(), "Nenhuma transferência encontrada.");

        Transfer transfer = transferList.stream().findFirst().orElse(null);

        assertNotNull(transfer, "Transferência não encontrada.");
        assertNotNull(transfer.getId(), "ID da transferência não encontrado.");
        assertNotNull(transfer.getValue(), "Valor da transferência não encontrado.");
        assertNotNull(transfer.getDateCreated());
    }

    @Test
    @DisplayName("Integração | Leitura de transação Pix por ID")
    @Order(3)
    void testReadById() {
        List<Transfer> transferList = Transfer.reader().read().getData();
        assumeTrue(transferList != null && !transferList.isEmpty(), "Nenhuma transferência encontrada.");

        String sortedId = transferList.stream().findFirst().map(Transfer::getId).orElse(null);
        assumeTrue(sortedId != null, "Nenhuma transferência encontrada.");

        Transfer transfer = Transfer.fetcher(sortedId).fetch();

        assertNotNull(transfer, "Transferência não encontrada.");
        assertNotNull(transfer.getId(), "ID da transferência não encontrado.");
        assertNotNull(transfer.getValue(), "Valor da transferência não encontrado.");
        assertNotNull(transfer.getDateCreated());
    }
}
