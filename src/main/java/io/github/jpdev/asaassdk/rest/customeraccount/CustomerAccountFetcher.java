package io.github.jpdev.asaassdk.rest.customeraccount;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class CustomerAccountFetcher extends Fetcher<CustomerAccount> {

    private final String id;

    public CustomerAccountFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.CUSTOMER_ACCOUNT.addPathVariable(this.id);
    }

    @Override
    public Class<CustomerAccount> getResourceClass() {
        return CustomerAccount.class;
    }
}
