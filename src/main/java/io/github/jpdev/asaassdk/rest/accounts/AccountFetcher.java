package io.github.jpdev.asaassdk.rest.accounts;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class AccountFetcher extends Fetcher<Account> {

    private final String id;

    public AccountFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.ACCOUNT.addPathVariable(this.id);
    }

    @Override
    public Class<Account> getResourceClass() {
        return Account.class;
    }
}
