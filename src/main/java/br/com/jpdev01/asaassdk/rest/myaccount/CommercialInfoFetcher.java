package br.com.jpdev01.asaassdk.rest.myaccount;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

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
