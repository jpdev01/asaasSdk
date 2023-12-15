package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.transfer.children.BankAccountSetting;

import java.math.BigDecimal;

public class TransferTedCreator extends Creator<Transfer> {

    private BankAccountSetting bankAccount;
    private String operationType;
    private BigDecimal value;

    public TransferTedCreator setBankAccount(BankAccountSetting bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public TransferTedCreator setOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public TransferTedCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    public BankAccountSetting getBankAccount() {
        return bankAccount;
    }

    public String getOperationType() {
        return operationType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
