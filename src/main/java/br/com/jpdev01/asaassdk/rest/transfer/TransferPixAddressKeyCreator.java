package br.com.jpdev01.asaassdk.rest.transfer;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;
import br.com.jpdev01.asaassdk.utils.pix.PixAddressKeyType;

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


    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
