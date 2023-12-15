package io.github.jpdev.asaassdk.rest.bill;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {

    public String object;
    public String id;
    public String status;
    public BigDecimal value;
    public BigDecimal discount;
    public BigDecimal interest;
    public BigDecimal fine;
    public String identificationField;
    public Date dueDate;
    public Date scheduleDate;
    public Date paymentDate;
    public BigDecimal fee;
    public String description;
    public Object companyName;
    public String transactionReceiptUrl;
    public boolean canBeCancelled;
    public Object failReasons;

    public static BillCreator creator() {
        return new BillCreator();
    }
    public String getObject() {
        return object;
    }

    public Bill setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public Bill setId(String id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Bill setStatus(String status) {
        this.status = status;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Bill setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Bill setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public Bill setInterest(BigDecimal interest) {
        this.interest = interest;
        return this;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public Bill setFine(BigDecimal fine) {
        this.fine = fine;
        return this;
    }

    public String getIdentificationField() {
        return identificationField;
    }

    public Bill setIdentificationField(String identificationField) {
        this.identificationField = identificationField;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Bill setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public Bill setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Bill setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public Bill setFee(BigDecimal fee) {
        this.fee = fee;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Bill setDescription(String description) {
        this.description = description;
        return this;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public Bill setCompanyName(Object companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getTransactionReceiptUrl() {
        return transactionReceiptUrl;
    }

    public Bill setTransactionReceiptUrl(String transactionReceiptUrl) {
        this.transactionReceiptUrl = transactionReceiptUrl;
        return this;
    }

    public boolean isCanBeCancelled() {
        return canBeCancelled;
    }

    public Bill setCanBeCancelled(boolean canBeCancelled) {
        this.canBeCancelled = canBeCancelled;
        return this;
    }

    public Object getFailReasons() {
        return failReasons;
    }

    public Bill setFailReasons(Object failReasons) {
        this.failReasons = failReasons;
        return this;
    }
}
