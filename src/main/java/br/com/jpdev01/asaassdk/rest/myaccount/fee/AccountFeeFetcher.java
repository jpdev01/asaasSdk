package br.com.jpdev01.asaassdk.rest.myaccount.fee;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

public class AccountFeeFetcher extends Fetcher<AccountFee> {

    @Override
    public String getResourceUrl() {
        return Domain.FEE.toString();
    }

    @Override
    public Class<AccountFee> getResourceClass() {
        return AccountFee.class;
    }
}
