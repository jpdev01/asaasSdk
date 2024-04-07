package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

import java.math.BigDecimal;

public class TransferInternalCreator extends Creator<Transfer> {

    BigDecimal value;
    String walletId;

    public BigDecimal getValue() {
        return value;
    }

    public TransferInternalCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public TransferInternalCreator setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    @Override
    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
