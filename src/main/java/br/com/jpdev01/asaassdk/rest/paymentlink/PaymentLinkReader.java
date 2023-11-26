package br.com.jpdev01.asaassdk.rest.paymentlink;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;


public class PaymentLinkReader extends Reader<PaymentLink> {


    Boolean active;
    Boolean includeDeleted;
    String name;

    public PaymentLinkReader setActive(Boolean active) {
        addFilter("active");
        this.active = active;
        return this;
    }

    public PaymentLinkReader setIncludeDeleted(Boolean includeDeleted) {
        addFilter("includeDeleted");
        this.includeDeleted = includeDeleted;
        return this;
    }

    public PaymentLinkReader setName(String name) {
        addFilter("name");
        this.name = name;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT_LINK.toString();
    }

    @Override
    public Class<PaymentLink> getResourceClass() {
        return PaymentLink.class;
    }
}
