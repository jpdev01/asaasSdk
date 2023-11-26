package br.com.jpdev01.asaassdk.rest.paymentlink;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;


public class PaymentLinkFetcher extends Fetcher<PaymentLink> {

    private final String id;

    public PaymentLinkFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_LINK.addPathVariable(this.id);
    }

    @Override
    public Class<PaymentLink> getResourceClass() {
        return PaymentLink.class;
    }
}
