package br.com.jpdev01.asaassdk.rest.finance;

import java.math.BigDecimal;

public class FinanceBalance {

    public BigDecimal balance;

    public static FinanceBalanceFetcher fetcher() {
        return new FinanceBalanceFetcher();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public FinanceBalance setBalance(BigDecimal value) {
        this.balance = value;
        return this;
    }
}
