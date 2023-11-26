package br.com.jpdev01.asaassdk.rest.paymentlink;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Updater;
import br.com.jpdev01.asaassdk.utils.BillingType;
import br.com.jpdev01.asaassdk.rest.payment.enums.PaymentLinkChargeType;

import java.math.BigDecimal;
import java.util.Date;


public class PaymentLinkUpdater extends Updater<PaymentLink> {

    private final String id;
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

    public PaymentLinkUpdater(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public PaymentLinkUpdater setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentLinkUpdater setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PaymentLinkUpdater setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PaymentLinkUpdater setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public PaymentLinkUpdater setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public PaymentLinkChargeType getChargeType() {
        return chargeType;
    }

    public PaymentLinkUpdater setChargeType(PaymentLinkChargeType chargeType) {
        this.chargeType = chargeType;
        return this;
    }

    public Integer getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public PaymentLinkUpdater setDueDateLimitDays(Integer dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
        return this;
    }

    public String getSubscriptionCycle() {
        return subscriptionCycle;
    }

    public PaymentLinkUpdater setSubscriptionCycle(String subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle;
        return this;
    }

    public Integer getMaxInstallmentCount() {
        return maxInstallmentCount;
    }

    public PaymentLinkUpdater setMaxInstallmentCount(Integer maxInstallmentCount) {
        this.maxInstallmentCount = maxInstallmentCount;
        return this;
    }

    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }

    public PaymentLinkUpdater setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
        return this;
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
