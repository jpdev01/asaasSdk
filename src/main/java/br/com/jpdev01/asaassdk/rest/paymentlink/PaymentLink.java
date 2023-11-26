package br.com.jpdev01.asaassdk.rest.paymentlink;

import br.com.jpdev01.asaassdk.utils.BillingType;
import br.com.jpdev01.asaassdk.utils.PaymentLinkChargeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentLink {

    public String id;
    public String name;
    public int value;
    public boolean active;
    public PaymentLinkChargeType chargeType;
    public String url;
    public BillingType billingType;
    public Object subscriptionCycle;
    public String description;
    public Date endDate;
    public boolean deleted;
    public int viewCount;
    public int maxInstallmentCount;
    public int dueDateLimitDays;
    public boolean notificationEnabled;

    public static PaymentLinkCreator creator() {
        return new PaymentLinkCreator();
    }

    public String getId() {
        return id;
    }

    public PaymentLink setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentLink setName(String name) {
        this.name = name;
        return this;
    }

    public int getValue() {
        return value;
    }

    public PaymentLink setValue(int value) {
        this.value = value;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public PaymentLink setActive(boolean active) {
        this.active = active;
        return this;
    }

    public PaymentLinkChargeType getChargeType() {
        return chargeType;
    }

    public PaymentLink setChargeType(PaymentLinkChargeType chargeType) {
        this.chargeType = chargeType;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PaymentLink setUrl(String url) {
        this.url = url;
        return this;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public PaymentLink setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public Object getSubscriptionCycle() {
        return subscriptionCycle;
    }

    public PaymentLink setSubscriptionCycle(Object subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentLink setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PaymentLink setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public PaymentLink setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getViewCount() {
        return viewCount;
    }

    public PaymentLink setViewCount(int viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    public int getMaxInstallmentCount() {
        return maxInstallmentCount;
    }

    public PaymentLink setMaxInstallmentCount(int maxInstallmentCount) {
        this.maxInstallmentCount = maxInstallmentCount;
        return this;
    }

    public int getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public PaymentLink setDueDateLimitDays(int dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
        return this;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public PaymentLink setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
        return this;
    }
}
