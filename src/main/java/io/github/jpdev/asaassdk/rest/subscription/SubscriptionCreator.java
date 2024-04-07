package io.github.jpdev.asaassdk.rest.subscription;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.payment.children.Discount;
import io.github.jpdev.asaassdk.rest.payment.children.Fine;
import io.github.jpdev.asaassdk.rest.payment.children.Interest;
import io.github.jpdev.asaassdk.utils.BillingType;

import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionCreator extends Creator<Subscription> {

    public BillingType billingType;
    public Discount discount;
    public Interest interest;
    public Fine fine;
    public SubscriptionCycle cycle;
    public String customer;
    public Date nextDueDate;
    public BigDecimal value;
    public String description;

    public BillingType getBillingType() {
        return billingType;
    }

    public SubscriptionCreator setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public Discount getDiscount() {
        return discount;
    }

    public SubscriptionCreator setDiscount(Discount discount) {
        this.discount = discount;
        return this;
    }

    public Interest getInterest() {
        return interest;
    }

    public SubscriptionCreator setInterest(Interest interest) {
        this.interest = interest;
        return this;
    }

    public Fine getFine() {
        return fine;
    }

    public SubscriptionCreator setFine(Fine fine) {
        this.fine = fine;
        return this;
    }

    public SubscriptionCycle getCycle() {
        return cycle;
    }

    public SubscriptionCreator setCycle(SubscriptionCycle cycle) {
        this.cycle = cycle;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public SubscriptionCreator setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public Date getNextDueDate() {
        return nextDueDate;
    }

    public SubscriptionCreator setNextDueDate(Date nextDueDate) {
        this.nextDueDate = nextDueDate;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public SubscriptionCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubscriptionCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.SUBSCRIPTION.toString();
    }

    @Override
    public Class<Subscription> getResourceClass() {
        return Subscription.class;
    }
}
