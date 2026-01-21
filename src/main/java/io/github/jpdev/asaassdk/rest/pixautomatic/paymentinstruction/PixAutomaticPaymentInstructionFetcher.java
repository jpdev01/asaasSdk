package io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class PixAutomaticPaymentInstructionFetcher extends Fetcher<PixAutomaticPaymentInstruction> {

    private final String id;

    public PixAutomaticPaymentInstructionFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_AUTOMATIC_PAYMENT_INSTRUCTION.addPathVariable(this.id);
    }

    @Override
    public Class<PixAutomaticPaymentInstruction> getResourceClass() {
        return PixAutomaticPaymentInstruction.class;
    }
}
