package io.github.jpdev.asaassdk.rest.bill;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

import java.math.BigDecimal;
import java.util.Date;

public class BillCreator extends Creator<Bill> {

    String identificationField;
    Date scheduleDate;
    String description;
    BigDecimal discount;
    BigDecimal interest;
    BigDecimal fine;
    Date dueDate;
    BigDecimal value;

    public String getIdentificationField() {
        return identificationField;
    }

    public BillCreator setIdentificationField(String identificationField) {
        this.identificationField = identificationField;
        return this;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public BillCreator setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BillCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BillCreator setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public BillCreator setInterest(BigDecimal interest) {
        this.interest = interest;
        return this;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public BillCreator setFine(BigDecimal fine) {
        this.fine = fine;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public BillCreator setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BillCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.BILL.toString();
    }

    @Override
    public Class<Bill> getResourceClass() {
        return null;
    }
}
