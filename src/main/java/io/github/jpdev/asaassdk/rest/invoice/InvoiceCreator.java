package io.github.jpdev.asaassdk.rest.invoice;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceCreator extends Creator<Invoice> {

    String payment;
    String installment;
    String customer;
    String serviceDescription;
    String observations;
    String externalReference;
    BigDecimal value;
    BigDecimal deductions;
    Date effectiveDate;
    String municipalServiceId;
    String municipalServiceCode;
    String municipalServiceName;
    Boolean updatePayment;
    Taxes taxes;

    public String getPayment() {
        return payment;
    }

    public InvoiceCreator setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public String getInstallment() {
        return installment;
    }

    public InvoiceCreator setInstallment(String installment) {
        this.installment = installment;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public InvoiceCreator setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public InvoiceCreator setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public InvoiceCreator setObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public InvoiceCreator setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public InvoiceCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public InvoiceCreator setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
        return this;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public InvoiceCreator setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public String getMunicipalServiceId() {
        return municipalServiceId;
    }

    public InvoiceCreator setMunicipalServiceId(String municipalServiceId) {
        this.municipalServiceId = municipalServiceId;
        return this;
    }

    public String getMunicipalServiceCode() {
        return municipalServiceCode;
    }

    public InvoiceCreator setMunicipalServiceCode(String municipalServiceCode) {
        this.municipalServiceCode = municipalServiceCode;
        return this;
    }

    public Boolean getUpdatePayment() {
        return updatePayment;
    }

    public InvoiceCreator setUpdatePayment(Boolean updatePayment) {
        this.updatePayment = updatePayment;
        return this;
    }

    public String getMunicipalServiceName() {
        return municipalServiceName;
    }

    public InvoiceCreator setMunicipalServiceName(String municipalServiceName) {
        this.municipalServiceName = municipalServiceName;
        return this;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public InvoiceCreator setTaxes(Taxes taxes) {
        this.taxes = taxes;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.INVOICE.toString();
    }

    @Override
    public Class<Invoice> getResourceClass() {
        return Invoice.class;
    }
}
