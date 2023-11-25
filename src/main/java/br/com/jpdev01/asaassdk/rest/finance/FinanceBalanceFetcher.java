package br.com.jpdev01.asaassdk.rest.finance;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

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
