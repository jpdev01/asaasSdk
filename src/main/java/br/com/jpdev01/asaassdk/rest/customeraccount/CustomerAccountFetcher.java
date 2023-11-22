package br.com.jpdev01.asaassdk.rest.customeraccount;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

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
