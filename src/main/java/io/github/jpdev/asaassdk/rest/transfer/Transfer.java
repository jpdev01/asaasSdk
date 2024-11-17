package io.github.jpdev.asaassdk.rest.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.jpdev.asaassdk.rest.ApiResource;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer extends ApiResource {

    private BigDecimal value;

    private String recurring;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getRecurring() {
        return recurring;
    }

    public void setRecurring(String recurring) {
        this.recurring = recurring;
    }

    public static TransferPixAddressKeyCreator pixAddressKeyCreator() {
        return new TransferPixAddressKeyCreator();
    }

    public static TransferPixManualCreator pixManualCreator() {
        return new TransferPixManualCreator();
    }

    public static TransferTedCreator tedCreator() {
        return new TransferTedCreator().setOperationType("TED");
    }

    public static TransferReader reader() {
        return new TransferReader();
    }

    public static TransferInternalCreator internalCreator() {
        return new TransferInternalCreator();
    }

    public static TransferFetcher fetcher(String id) {
        return new TransferFetcher(id);
    }

    public static TransferCanceller canceller(String id) {
        return new TransferCanceller(id);
    }
}
