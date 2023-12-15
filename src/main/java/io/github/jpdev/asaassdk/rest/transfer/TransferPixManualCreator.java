package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.transfer.children.BankAccountSetting;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransferPixManualCreator extends Creator<Transfer> {


    private BankAccountSetting bankAccount;
    private BigDecimal value;
    private String description;

    public BigDecimal getValue() {
        return value;
    }

    public TransferPixManualCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TransferPixManualCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public TransferPixManualCreator setBankAccount(BankAccountSetting bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }

    public BankAccountSetting getBankAccount() {
        return bankAccount;
    }
}
