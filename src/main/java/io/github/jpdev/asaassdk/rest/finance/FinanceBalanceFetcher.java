package io.github.jpdev.asaassdk.rest.finance;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class FinanceBalanceFetcher extends Fetcher<FinanceBalance> {

    @Override
    public String getResourceUrl() {
        return Domain.FINANCE_BALANCE.toString();
    }

    @Override
    public Class<FinanceBalance> getResourceClass() {
        return FinanceBalance.class;
    }
}
