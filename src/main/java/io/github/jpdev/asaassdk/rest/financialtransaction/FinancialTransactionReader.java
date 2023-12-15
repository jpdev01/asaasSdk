package io.github.jpdev.asaassdk.rest.financialtransaction;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class FinancialTransactionReader extends Reader<FinancialTransaction> {

    public String paymentId;
    public String transferId;
    public String anticipationId;
    public String billId;
    public String invoiceId;
    public String paymentDunningId;
    public String creditBureauReportId;

    public FinancialTransactionReader setPaymentId(String paymentId) {
        addFilter("paymentId");
        this.paymentId = paymentId;
        return this;
    }

    public FinancialTransactionReader setTransferId(String transferId) {
        addFilter("transferId");
        this.transferId = transferId;
        return this;
    }

    public FinancialTransactionReader setAnticipationId(String anticipationId) {
        addFilter("anticipationId");
        this.anticipationId = anticipationId;
        return this;
    }

    public FinancialTransactionReader setBillId(String billId) {
        addFilter("billId");
        this.billId = billId;
        return this;
    }

    public FinancialTransactionReader setInvoiceId(String invoiceId) {
        addFilter("invoiceId");
        this.invoiceId = invoiceId;
        return this;
    }

    public FinancialTransactionReader setPaymentDunningId(String paymentDunningId) {
        addFilter("paymentDunningId");
        this.paymentDunningId = paymentDunningId;
        return this;
    }

    public FinancialTransactionReader setCreditBureauReportId(String creditBureauReportId) {
        addFilter("creditBureauReportId");
        this.creditBureauReportId = creditBureauReportId;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.FINANCIAL_TRANSACTION.toString();
    }

    @Override
    public Class<FinancialTransaction> getResourceClass() {
        return FinancialTransaction.class;
    }
}
