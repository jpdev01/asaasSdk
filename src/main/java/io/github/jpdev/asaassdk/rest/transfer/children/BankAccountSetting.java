package io.github.jpdev.asaassdk.rest.transfer.children;

import java.util.Date;

public class BankAccountSetting {

    private BankSetting bank;
    private String accountName;
    private String ownerName;
    private Date ownerBirthDate;
    private String cpfCnpj;
    private String agency;

    private String account;

    private String accountDigit;

    private BankAccountType bankAccountType;

    public BankAccountSetting() {}
    public BankAccountSetting setBank(BankSetting bank) {
        this.bank = bank;
        return this;
    }

    public BankAccountSetting setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public BankAccountSetting setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public BankAccountSetting setOwnerBirthDate(Date ownerBirthDate) {
        this.ownerBirthDate = ownerBirthDate;
        return this;
    }

    public BankAccountSetting setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public BankAccountSetting setAgency(String agency) {
        this.agency = agency;
        return this;
    }

    public BankAccountSetting setAccount(String account) {
        this.account = account;
        return this;
    }

    public BankAccountSetting setAccountDigit(String accountDigit) {
        this.accountDigit = accountDigit;
        return this;
    }

    public BankAccountSetting setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
        return this;
    }

    public BankSetting getBank() {
        return bank;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Date getOwnerBirthDate() {
        return ownerBirthDate;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccount() {
        return account;
    }

    public String getAccountDigit() {
        return accountDigit;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }
}
