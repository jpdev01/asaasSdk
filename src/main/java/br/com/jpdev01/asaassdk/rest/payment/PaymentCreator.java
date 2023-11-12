package br.com.jpdev01.asaassdk.rest.payment;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;
import br.com.jpdev01.asaassdk.rest.payment.children.DiscountSetting;
import br.com.jpdev01.asaassdk.utils.BillingType;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentCreator extends Creator<Payment> {

    String customer;

    BillingType billingType;
    Date dueDate;

    BigDecimal value;

    String description;

    String externalReference;
    boolean postalService;
    DiscountSetting discount;

    public PaymentCreator setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public PaymentCreator setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public PaymentCreator setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PaymentCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public PaymentCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public PaymentCreator setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public PaymentCreator setPostalService(boolean postalService) {
        this.postalService = postalService;
        return this;
    }

    public PaymentCreator setDiscount(DiscountSetting discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT.toString();
    }

    @Override
    public Class<Payment> getResourceClass() {
        return Payment.class;
    }
}
