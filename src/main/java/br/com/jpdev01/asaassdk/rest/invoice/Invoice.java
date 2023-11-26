package br.com.jpdev01.asaassdk.rest.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    public String object;
    public String id;
    public InvoiceStatus status;
    public String customer;
    public String type;
    public Object statusDescription;
    public String serviceDescription;
    public Object pdfUrl;
    public Object xmlUrl;
    public Object rpsSerie;
    public Object rpsNumber;
    public Object number;
    public Object validationCode;
    public int value;
    public int deductions;
    public String effectiveDate;
    public String observations;
    public String estimatedTaxesDescription;
    public String payment;
    public Object installment;
    public Object externalReference;
    public Taxes taxes;
    public String municipalServiceId;
    public String municipalServiceCode;
    public String municipalServiceName;

    public static InvoiceCreator creator() {
        return new InvoiceCreator();
    }

    public static InvoiceFetcher fetcher(String id) {
        return new InvoiceFetcher(id);
    }

    public static InvoiceReader reader() {
        return new InvoiceReader();
    }

    public String getObject() {
        return object;
    }

    public Invoice setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public Invoice setId(String id) {
        this.id = id;
        return this;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public Invoice setStatus(InvoiceStatus status) {
        this.status = status;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Invoice setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getType() {
        return type;
    }

    public Invoice setType(String type) {
        this.type = type;
        return this;
    }

    public Object getStatusDescription() {
        return statusDescription;
    }

    public Invoice setStatusDescription(Object statusDescription) {
        this.statusDescription = statusDescription;
        return this;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public Invoice setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
        return this;
    }

    public Object getPdfUrl() {
        return pdfUrl;
    }

    public Invoice setPdfUrl(Object pdfUrl) {
        this.pdfUrl = pdfUrl;
        return this;
    }

    public Object getXmlUrl() {
        return xmlUrl;
    }

    public Invoice setXmlUrl(Object xmlUrl) {
        this.xmlUrl = xmlUrl;
        return this;
    }

    public Object getRpsSerie() {
        return rpsSerie;
    }

    public Invoice setRpsSerie(Object rpsSerie) {
        this.rpsSerie = rpsSerie;
        return this;
    }

    public Object getRpsNumber() {
        return rpsNumber;
    }

    public Invoice setRpsNumber(Object rpsNumber) {
        this.rpsNumber = rpsNumber;
        return this;
    }

    public Object getNumber() {
        return number;
    }

    public Invoice setNumber(Object number) {
        this.number = number;
        return this;
    }

    public Object getValidationCode() {
        return validationCode;
    }

    public Invoice setValidationCode(Object validationCode) {
        this.validationCode = validationCode;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Invoice setValue(int value) {
        this.value = value;
        return this;
    }

    public int getDeductions() {
        return deductions;
    }

    public Invoice setDeductions(int deductions) {
        this.deductions = deductions;
        return this;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public Invoice setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public Invoice setObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public String getEstimatedTaxesDescription() {
        return estimatedTaxesDescription;
    }

    public Invoice setEstimatedTaxesDescription(String estimatedTaxesDescription) {
        this.estimatedTaxesDescription = estimatedTaxesDescription;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public Invoice setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public Object getInstallment() {
        return installment;
    }

    public Invoice setInstallment(Object installment) {
        this.installment = installment;
        return this;
    }

    public Object getExternalReference() {
        return externalReference;
    }

    public Invoice setExternalReference(Object externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public Invoice setTaxes(Taxes taxes) {
        this.taxes = taxes;
        return this;
    }

    public String getMunicipalServiceId() {
        return municipalServiceId;
    }

    public Invoice setMunicipalServiceId(String municipalServiceId) {
        this.municipalServiceId = municipalServiceId;
        return this;
    }

    public String getMunicipalServiceCode() {
        return municipalServiceCode;
    }

    public Invoice setMunicipalServiceCode(String municipalServiceCode) {
        this.municipalServiceCode = municipalServiceCode;
        return this;
    }

    public String getMunicipalServiceName() {
        return municipalServiceName;
    }

    public Invoice setMunicipalServiceName(String municipalServiceName) {
        this.municipalServiceName = municipalServiceName;
        return this;
    }
}
