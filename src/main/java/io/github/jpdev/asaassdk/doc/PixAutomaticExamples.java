package io.github.jpdev.asaassdk.doc;

import io.github.jpdev.asaassdk.rest.payment.Payment;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.PixAutomaticAuthorization;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.PixAutomaticAuthorizationReader;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate.ImmediateQrCodeCreator;
import io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction.PixAutomaticPaymentInstruction;
import io.github.jpdev.asaassdk.utils.BillingType;
import io.github.jpdev.asaassdk.utils.Money;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationFrequency;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationStatus;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PixAutomaticExamples {

    public static void start() {
        createPixAuthorization();
        readPixAutomaticAuthorizations();
        readPaymentInstructions();
        createPaymentInstruction();
    }

    private static void createPixAuthorization() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();

        ImmediateQrCodeCreator immediateQrCodeCreator = new ImmediateQrCodeCreator()
            .setDescription("teste")
            .setExpirationSeconds(3600)
            .setOriginalValue(Money.create(10));

        String contractId = String.valueOf(System.currentTimeMillis());
        PixAutomaticAuthorization authorization = PixAutomaticAuthorization.creator()
            .setCustomerId("cus_000007258649")
            .setStartDate(startDate)
            .setFrequency(PixAutomaticAuthorizationFrequency.MONTHLY)
            .setValue(Money.create(100))
            .setContractId("CONTRACT_IIDD" + contractId)
            .setImmediateQrCode(immediateQrCodeCreator)
            .create();

        assert authorization.getId() != null;
        assert authorization.getImmediateQrCode().getExpirationDate() != null;
    }

    private static void readPixAutomaticAuthorizations() {
        for (PixAutomaticAuthorization authorization : PixAutomaticAuthorization.reader().read().getData()) {
            assert authorization.getContractId() != null;
        }
    }

    private static void createPaymentInstruction() {
        Optional<PixAutomaticAuthorization> activeAuthorizationOptional = findActivePixAutomaticAuthorization();
        if (!activeAuthorizationOptional.isPresent()) return;

        PixAutomaticAuthorization authorization = activeAuthorizationOptional.get();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 3);

        Payment payment = Payment.creator()
            .setCustomer(authorization.getCustomerId())
            .setBillingType(BillingType.PIX)
            .setDueDate(calendar.getTime())
            .setValue(authorization.getValue())
            .setDescription("Teste")
            .setPixAutomaticAuthorizationId(authorization.getId())
            .create();

        assert payment != null;
    }

    private static Optional<PixAutomaticAuthorization> findActivePixAutomaticAuthorization() {
        PixAutomaticAuthorizationReader reader = PixAutomaticAuthorization.reader();
        PixAutomaticAuthorization activeAuthorization = null;
        Long offset = 0L;
        while (activeAuthorization == null) {
            reader.setOffset(offset);
            for (PixAutomaticAuthorization authorization : reader.read().getData()) {
                if (authorization.getStatus() == PixAutomaticAuthorizationStatus.ACTIVE) {
                    activeAuthorization = authorization;
                    break;
                }
            }
            offset++;
        }

        return Optional.ofNullable(activeAuthorization);
    }

    private static void readPaymentInstructions() {
        List<PixAutomaticPaymentInstruction> paymentInstructionList = PixAutomaticPaymentInstruction.reader().read().getData();
        paymentInstructionList.forEach(it -> {
            assert it.getId() != null;
            assert it.getDueDate() != null;
        });

        PixAutomaticPaymentInstruction fetchedPaymentInstruction = PixAutomaticPaymentInstruction.fetcher(paymentInstructionList.get(0).getId()).fetch();
        assert fetchedPaymentInstruction.getPaymentId() != null;
        assert fetchedPaymentInstruction.getDueDate() != null;
        assert fetchedPaymentInstruction.getAuthorization() != null;
    }
}
