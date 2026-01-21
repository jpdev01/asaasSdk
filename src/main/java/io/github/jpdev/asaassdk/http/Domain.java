package io.github.jpdev.asaassdk.http;

import java.util.List;

public enum Domain {

    TRANSFER("transfers"),
    PAYMENT("payments"),
    REFUND_PAYMENT("payments/$id/refund"),
    PIX_TRANSACTION("pix/transactions"),
    PIX_TRANSACTION_CANCELLATION("pix/transactions/$id/cancel"),
    PIX_TRANSACTION_QR_CODE("pix/qrCodes/pay"),
    PIX_ADDRESS_KEY("pix/addressKeys"),
    STATIC_PIX_QR_CODE("pix/qrCodes/static"),
    DECODE_PIX_QR_CODE("pix/qrCodes/decode"),
    CUSTOMER_ACCOUNT("customers"),
    NOTIFICATION("notifications"),
    CUSTOMER_ACCOUNT_NOTIFICATIONS("customers/$id/notifications"),
    PAYMENT_STATUS("payments/$id/status"),
    PAYMENT_RESTORE("payments/$id/restore"),
    PAYMENT_SPLIT_RECEIVED("payments/splits/received"),
    PAYMENT_SPLIT_PAID("payments/splits/paid"),
    INSTALLMENT("installments"),
    FINANCE_BALANCE("finance/balance"),
    PAYMENT_LINK("paymentLinks"),
    BILL("bill"),
    FINANCIAL_TRANSACTION("financialTransactions"),
    INVOICE("invoices"),
    COMMERCIAL_INFO("myAccount/commercialInfo"),
    ACCOUNT_NUMBER("myAccount/accountNumber"),
    FEE("myAccount/fees"),
    STATUS("myAccount/status"),
    ACCOUNT("accounts"),
    SUBSCRIPTION("subscriptions"),
    WEBHOOK("webhooks"),
    PIX_RECURRING("pix/transactions/recurrings"),
    PIX_AUTOMATIC_AUTHORIZATION("pix/automatic/authorizations"),
    PIX_AUTOMATIC_PAYMENT_INSTRUCTION("pix/automatic/paymentInstructions");

    private final String value;

    private Domain(final String value) {
        this.value = value;
    }

    public String addPathVariable(String value) {
        return this.toString() + "/" + value;
    }

    public String addVariableList(String... variables) {
        StringBuilder path = new StringBuilder(this.toString());
        for (String variable : variables) {
            path.append("/").append(variable);
        }
        return path.toString();
    }

    public String toString() {
        return value;
    }
}
