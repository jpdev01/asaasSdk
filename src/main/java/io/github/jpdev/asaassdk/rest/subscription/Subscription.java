package io.github.jpdev.asaassdk.rest.subscription;

import io.github.jpdev.asaassdk.rest.payment.children.Discount;
import io.github.jpdev.asaassdk.rest.payment.children.Fine;
import io.github.jpdev.asaassdk.rest.payment.children.Interest;

public class Subscription {

    public String object;
    public String id;
    public String dateCreated;
    public String customer;
    public Object paymentLink;
    public String billingType;
    public String cycle;
    public double value;
    public String nextDueDate;
    public String description;
    public String status;
    public Discount discount;
    public Fine fine;
    public Interest interest;
    public boolean deleted;

    public Subscription() {
    }

    public static SubscriptionCreator creator() {
        return new SubscriptionCreator();
    }

}
