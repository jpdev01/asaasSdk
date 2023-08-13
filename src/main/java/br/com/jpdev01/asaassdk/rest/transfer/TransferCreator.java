package br.com.jpdev01.asaassdk.rest.transfer;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.creator.Creator;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class TransferCreator extends Creator<Transfer> {

    @Expose
    private String pixAddressKey;

    @Expose
    private String pixAddressKeyType;

    @Expose
    private BigDecimal value;

    @Expose
    private String description;

    public String getPixAddressKey() {
        return pixAddressKey;
    }

    public TransferCreator setPixAddressKey(String pixAddressKey) {
        this.pixAddressKey = pixAddressKey;
        return this;
    }

    public String getPixAddressKeyType() {
        return pixAddressKeyType;
    }

    public TransferCreator setPixAddressKeyType(String pixAddressKeyType) {
        this.pixAddressKeyType = pixAddressKeyType;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public TransferCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TransferCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
