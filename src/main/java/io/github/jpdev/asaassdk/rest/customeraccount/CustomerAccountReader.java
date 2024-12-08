package io.github.jpdev.asaassdk.rest.customeraccount;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class CustomerAccountReader extends Reader<CustomerAccount> {

    @Override
    public String getResourceUrl() {
        return Domain.CUSTOMER_ACCOUNT.toString();
    }

    @Override
    public Class<CustomerAccount> getResourceClass() {
        return CustomerAccount.class;
    }
}
