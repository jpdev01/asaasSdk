package br.com.jpdev01.asaassdk.rest.myaccount.accountnumber;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

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
