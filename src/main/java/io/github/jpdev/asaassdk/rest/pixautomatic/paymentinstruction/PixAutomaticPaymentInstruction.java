package io.github.jpdev.asaassdk.rest.pixautomatic.paymentinstruction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.jpdev.asaassdk.utils.PixAutomaticPaymentInstructionStatus;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PixAutomaticPaymentInstruction {

    private String id;
    private String endToEndIdentifier;
    private PixAutomaticPaymentInstructionAuthorization authorization;
    private Date dueDate;
    private PixAutomaticPaymentInstructionStatus status;
    private String paymentId;

    public String getId() {
        return id;
    }

    public String getEndToEndIdentifier() {
        return endToEndIdentifier;
    }

    public PixAutomaticPaymentInstructionAuthorization getAuthorization() {
        return authorization;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public PixAutomaticPaymentInstructionStatus getStatus() {
        return status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public static PixAutomaticPaymentInstructionFetcher fetcher(String id) {
        return new PixAutomaticPaymentInstructionFetcher(id);
    }

    public static PixAutomaticPaymentInstructionReader reader() {
        return new PixAutomaticPaymentInstructionReader();
    }
}
