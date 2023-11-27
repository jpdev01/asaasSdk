package br.com.jpdev01.asaassdk.rest.myaccount.status;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

public class MyAccountStatusFetcher extends Fetcher<MyAccountStatus> {

    @Override
    public String getResourceUrl() {
        return Domain.STATUS.toString();
    }

    @Override
    public Class<MyAccountStatus> getResourceClass() {
        return MyAccountStatus.class;
    }
}
