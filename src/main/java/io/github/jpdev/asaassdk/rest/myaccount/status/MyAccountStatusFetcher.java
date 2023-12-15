package io.github.jpdev.asaassdk.rest.myaccount.status;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

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
