package io.github.jpdev.asaassdk.rest.myaccount.accountnumber;

public class AccountNumber {

    String agency;
    String account;
    String accountDigit;

    public static AccountNumberFetcher fetcher() {
        return new AccountNumberFetcher();
    }
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
