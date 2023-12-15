package io.github.jpdev.asaassdk.rest.paymentlink;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;


public class PaymentLinkReader extends Reader<PaymentLink> {


    public Boolean active;
    public Boolean includeDeleted;
    public String name;

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
