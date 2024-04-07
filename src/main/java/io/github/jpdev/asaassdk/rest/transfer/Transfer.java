package io.github.jpdev.asaassdk.rest.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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
}
