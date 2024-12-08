package io.github.jpdev.asaassdk.rest.accounts;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class AccountReader extends Reader<Account> {

    @Override
    public String getResourceUrl() {
        return Domain.ACCOUNT.toString();
    }

    @Override
    public Class<Account> getResourceClass() {
        return Account.class;
    }
}
