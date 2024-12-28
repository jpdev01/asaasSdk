package io.github.jpdev.asaassdk.rest.transfer.children;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class PixRecurringFetcher extends Fetcher<PixRecurring> {

    private final String id;

    public PixRecurringFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_RECURRING.addPathVariable(id).toString();
    }

    @Override
    public Class<PixRecurring> getResourceClass() {
        return PixRecurring.class;
    }
}
