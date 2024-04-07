package io.github.jpdev.asaassdk.rest.subscription;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;
import io.github.jpdev.asaassdk.utils.BillingType;

public class SubscriptionReader extends Reader<Subscription> {

    public String customer;
    public BillingType billingType;
    public SubscriptionStatus status;
    public String externalReference;

    @Override
    public String getResourceUrl() {
        return Domain.SUBSCRIPTION.toString();
    }

    @Override
    public Class<Subscription> getResourceClass() {
        return Subscription.class;
    }
}
