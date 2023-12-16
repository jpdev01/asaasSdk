package io.github.jpdev.asaassdk.rest.accounts;

public class AccountNumber {

    public String agency;
    public String account;
    public String accountDigit;

    public String getAgency() {
        return agency;
    }

    public AccountNumber setAgency(String agency) {
        this.agency = agency;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public AccountNumber setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getAccountDigit() {
        return accountDigit;
    }

    public AccountNumber setAccountDigit(String accountDigit) {
        this.accountDigit = accountDigit;
        return this;
    }
}
