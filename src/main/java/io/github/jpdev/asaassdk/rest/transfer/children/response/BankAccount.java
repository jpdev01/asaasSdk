package io.github.jpdev.asaassdk.rest.transfer.children.response;

public class BankAccount {

    public Bank bank;
    public String accountName;
    public String ownerName;
    public String cpfCnpj;
    public String type;
    public String pixAddressKey;

    public Bank getBank() {
        return bank;
    }

    public BankAccount setBank(Bank bank) {
        this.bank = bank;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public BankAccount setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BankAccount setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public BankAccount setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getType() {
        return type;
    }

    public BankAccount setType(String type) {
        this.type = type;
        return this;
    }

    public String getPixAddressKey() {
        return pixAddressKey;
    }

    public BankAccount setPixAddressKey(String pixAddressKey) {
        this.pixAddressKey = pixAddressKey;
        return this;
    }
}