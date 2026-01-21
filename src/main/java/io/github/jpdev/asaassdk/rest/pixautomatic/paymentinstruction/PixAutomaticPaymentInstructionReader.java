package io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.PixAutomaticAuthorization;

public class PixAutomaticPaymentInstructionReader extends Reader<PixAutomaticPaymentInstruction> {

    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }

    public PixAutomaticPaymentInstructionReader setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_AUTOMATIC_PAYMENT_INSTRUCTION.toString();
    }

    @Override
    public Class<PixAutomaticPaymentInstruction> getResourceClass() {
        return PixAutomaticPaymentInstruction.class;
    }
}
