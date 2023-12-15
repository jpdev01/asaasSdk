package io.github.jpdev.asaassdk.rest.myaccount.accountnumber;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class AccountNumberFetcher extends Fetcher<AccountNumber> {

    @Override
    public String getResourceUrl() {
        return Domain.ACCOUNT_NUMBER.toString();
    }

    @Override
    public Class<AccountNumber> getResourceClass() {
        return AccountNumber.class;
    }
}
