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

    Integer installmentCount;
    BigDecimal installmentValue;

    public String getCustomer() {
        return customer;
    }

    public PaymentCreator setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public PaymentCreator setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public PaymentCreator setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PaymentCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public PaymentCreator setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public boolean isPostalService() {
        return postalService;
    }

    public PaymentCreator setPostalService(boolean postalService) {
        this.postalService = postalService;
        return this;
    }

    public DiscountSetting getDiscount() {
        return discount;
    }

    public PaymentCreator setDiscount(DiscountSetting discount) {
        this.discount = discount;
        return this;
    }

    public Integer getInstallmentCount() {
        return installmentCount;
    }

    public PaymentCreator setInstallmentCount(Integer installmentCount) {
        this.installmentCount = installmentCount;
        return this;
    }

    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    public PaymentCreator setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
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
