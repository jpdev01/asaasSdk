package io.github.jpdev.asaassdk.rest.myaccount.fee;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

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
