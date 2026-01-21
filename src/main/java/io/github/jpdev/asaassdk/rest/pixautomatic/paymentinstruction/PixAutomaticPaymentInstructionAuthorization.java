package io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PixAutomaticPaymentInstructionAuthorization {

    private String id;
    private String endToEndIdentifier;

    public String getId() {
        return id;
    }

    public String getEndToEndIdentifier() {
        return endToEndIdentifier;
    }
}
