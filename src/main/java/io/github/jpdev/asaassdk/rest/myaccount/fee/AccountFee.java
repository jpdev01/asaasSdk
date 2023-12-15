package io.github.jpdev.asaassdk.rest.myaccount.fee;

public class AccountFee {

    public PaymentFee payment;
    public TransferFee transfer;
    public NotificationFee notification;
    public CreditBureauReportFee creditBureauReport;
    public InvoiceFee invoice;
    public AnticipationFee anticipation;

    public static AccountFeeFetcher fetcher() {
        return new AccountFeeFetcher();
    }

    public PaymentFee getPayment() {
        return payment;
    }

    public AccountFee setPayment(PaymentFee payment) {
        this.payment = payment;
        return this;
    }

    public TransferFee getTransfer() {
        return transfer;
    }

    public AccountFee setTransfer(TransferFee transfer) {
        this.transfer = transfer;
        return this;
    }

    public NotificationFee getNotification() {
        return notification;
    }

    public AccountFee setNotification(NotificationFee notification) {
        this.notification = notification;
        return this;
    }

    public CreditBureauReportFee getCreditBureauReport() {
        return creditBureauReport;
    }

    public AccountFee setCreditBureauReport(CreditBureauReportFee creditBureauReport) {
        this.creditBureauReport = creditBureauReport;
        return this;
    }

    public InvoiceFee getInvoice() {
        return invoice;
    }

    public AccountFee setInvoice(InvoiceFee invoice) {
        this.invoice = invoice;
        return this;
    }

    public AnticipationFee getAnticipation() {
        return anticipation;
    }

    public AccountFee setAnticipation(AnticipationFee anticipation) {
        this.anticipation = anticipation;
        return this;
    }
}
