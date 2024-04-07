package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;

import java.math.BigDecimal;

public class TransferPixAddressKeyCreator extends Creator<Transfer> {

    private String pixAddressKey;
    private PixAddressKeyType pixAddressKeyType;
    private BigDecimal value;
    private String description;


    public TransferPixAddressKeyCreator setPixAddressKey(String pixAddressKey) {
        this.pixAddressKey = pixAddressKey;
        return this;
    }

    public TransferPixAddressKeyCreator setPixAddressKeyType(PixAddressKeyType pixAddressKeyType) {
        this.pixAddressKeyType = pixAddressKeyType;
        return this;
    }

    public TransferPixAddressKeyCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public TransferPixAddressKeyCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getPixAddressKey() {
        return pixAddressKey;
    }

    public PixAddressKeyType getPixAddressKeyType() {
        return pixAddressKeyType;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
