package io.github.jpdev.asaassdk.rest.myaccount.commercialinfo;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Fetcher;

public class CommercialInfoFetcher extends Fetcher<CommercialInfo> {

    @Override
    public String getResourceUrl() {
        return Domain.COMMERCIAL_INFO.toString();
    }

    @Override
    public Class<CommercialInfo> getResourceClass() {
        return CommercialInfo.class;
    }
}
