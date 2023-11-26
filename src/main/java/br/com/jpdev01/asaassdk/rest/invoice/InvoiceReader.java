package br.com.jpdev01.asaassdk.rest.invoice;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;

import java.util.Date;

public class InvoiceReader extends Reader<Invoice> {

    public Date effectiveDateStart;
    public Date effectiveDateFinish;
    public String payment;
    public String installment;
    public String externalReference;
    public InvoiceStatus status;
    public String customer;

    public InvoiceReader setEffectiveDateStart(Date effectiveDateStart) {
        addFilter("effectiveDateStart", "effectiveDate[ge]");
        this.effectiveDateStart = effectiveDateStart;
        return this;
    }

    public InvoiceReader setEffectiveDateFinish(Date effectiveDateFinish) {
        addFilter("effectiveDateFinish", "effectiveDate[le]");
        this.effectiveDateFinish = effectiveDateFinish;
        return this;
    }

    public InvoiceReader setPayment(String payment) {
        addFilter("payment");
        this.payment = payment;
        return this;
    }

    public InvoiceReader setInstallment(String installment) {
        addFilter("installment");
        this.installment = installment;
        return this;
    }

    public InvoiceReader setExternalReference(String externalReference) {
        addFilter("externalReference");
        this.externalReference = externalReference;
        return this;
    }

    public InvoiceReader setStatus(InvoiceStatus status) {
        addFilter("status");
        this.status = status;
        return this;
    }

    public InvoiceReader setCustomer(String customer) {
        addFilter("customer");
        this.customer = customer;
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
