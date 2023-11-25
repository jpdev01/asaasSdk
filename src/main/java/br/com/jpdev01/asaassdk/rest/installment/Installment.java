package br.com.jpdev01.asaassdk.rest.installment;

import br.com.jpdev01.asaassdk.utils.BillingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Installment {

    public String object;
    public String id;
    public BigDecimal value;
    public BigDecimal netValue;
    public BigDecimal paymentValue;
    public int installmentCount;
    public BillingType billingType;
    public Date paymentDate;
    public String description;
    public int expirationDay;
    public boolean deleted;
    public Date dateCreated;
    public String customer;
    public String paymentLink;
    public String transactionReceiptUrl;

    public static InstallmentReader reader() {
        return new InstallmentReader();
    }
    public String getObject() {
        return object;
    }

    public Installment setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public Installment setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Installment setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public Installment setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
        return this;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public Installment setPaymentValue(BigDecimal paymentValue) {
        this.paymentValue = paymentValue;
        return this;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public Installment setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
        return this;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public Installment setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Installment setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Installment setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getExpirationDay() {
        return expirationDay;
    }

    public Installment setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Installment setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Installment setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Installment setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public Installment setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
        return this;
    }

    public String getTransactionReceiptUrl() {
        return transactionReceiptUrl;
    }

    public Installment setTransactionReceiptUrl(String transactionReceiptUrl) {
        this.transactionReceiptUrl = transactionReceiptUrl;
        return this;
    }
}
