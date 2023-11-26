package br.com.jpdev01.asaassdk.rest.paymentlink;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;
import br.com.jpdev01.asaassdk.utils.BillingType;
import br.com.jpdev01.asaassdk.utils.PaymentLinkChargeType;

import java.math.BigDecimal;
import java.util.Date;


public class PaymentLinkCreator extends Creator<PaymentLink> {

    String name;
    String description;
    Date endDate;
    BigDecimal value;
    BillingType billingType;
    PaymentLinkChargeType chargeType;
    Integer dueDateLimitDays;
    String subscriptionCycle;
    Integer maxInstallmentCount;
    Boolean notificationEnabled;

    public String getName() {
        return name;
    }

    public PaymentLinkCreator setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentLinkCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PaymentLinkCreator setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PaymentLinkCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public PaymentLinkCreator setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public PaymentLinkChargeType getChargeType() {
        return chargeType;
    }

    public PaymentLinkCreator setChargeType(PaymentLinkChargeType chargeType) {
        this.chargeType = chargeType;
        return this;
    }

    public Integer getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public PaymentLinkCreator setDueDateLimitDays(Integer dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
        return this;
    }

    public String getSubscriptionCycle() {
        return subscriptionCycle;
    }

    public PaymentLinkCreator setSubscriptionCycle(String subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle;
        return this;
    }

    public Integer getMaxInstallmentCount() {
        return maxInstallmentCount;
    }

    public PaymentLinkCreator setMaxInstallmentCount(Integer maxInstallmentCount) {
        this.maxInstallmentCount = maxInstallmentCount;
        return this;
    }

    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }

    public PaymentLinkCreator setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
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