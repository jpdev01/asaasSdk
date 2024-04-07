package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class TransferFetcher extends Fetcher<Transfer> {

    String id;

    public TransferFetcher(String id) {
        this.id = id;
    }


    @Override
    public String getResourceUrl() {
        return "";
    }

    @Override
    public Class<Transfer> getResourceClass() {
        return null;
    }
}
