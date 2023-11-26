package br.com.jpdev01.asaassdk.rest.financialtransaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialTransaction {

    public String object;
    public String id;
    public BigDecimal value;
    public BigDecimal balance;
    public FinancialTransactionType type;
    public Date date;
    public String description;
    public String paymentId;
    public String transferId;
    public Object anticipationId;
    public Object billId;
    public Object invoiceId;
    public Object paymentDunningId;
    public Object creditBureauReportId;

    public static FinancialTransactionReader reader() {
        return new FinancialTransactionReader();
    }

    public String getObject() {
        return object;
    }

    public FinancialTransaction setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public FinancialTransaction setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public FinancialTransaction setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public FinancialTransaction setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public FinancialTransactionType getType() {
        return type;
    }

    public FinancialTransaction setType(FinancialTransactionType type) {
        this.type = type;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public FinancialTransaction setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FinancialTransaction setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public FinancialTransaction setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getTransferId() {
        return transferId;
    }

    public FinancialTransaction setTransferId(String transferId) {
        this.transferId = transferId;
        return this;
    }

    public Object getAnticipationId() {
        return anticipationId;
    }

    public FinancialTransaction setAnticipationId(Object anticipationId) {
        this.anticipationId = anticipationId;
        return this;
    }

    public Object getBillId() {
        return billId;
    }

    public FinancialTransaction setBillId(Object billId) {
        this.billId = billId;
        return this;
    }

    public Object getInvoiceId() {
        return invoiceId;
    }

    public FinancialTransaction setInvoiceId(Object invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    public Object getPaymentDunningId() {
        return paymentDunningId;
    }

    public FinancialTransaction setPaymentDunningId(Object paymentDunningId) {
        this.paymentDunningId = paymentDunningId;
        return this;
    }

    public Object getCreditBureauReportId() {
        return creditBureauReportId;
    }

    public FinancialTransaction setCreditBureauReportId(Object creditBureauReportId) {
        this.creditBureauReportId = creditBureauReportId;
        return this;
    }
}
