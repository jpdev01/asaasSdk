package br.com.jpdev01.asaassdk.http;

public enum Domain {

    TRANSFER("transfers"),
    PAYMENT("payments"),
    REFUND_PAYMENT("payments/$id/refund"),
    PIX_TRANSACTION("pix/transactions"),
    PIX_ADDRESS_KEY("pix/addressKeys"),
    STATIC_PIX_QR_CODE("pix/qrCodes/static"),
    DECODE_PIX_QR_CODE("pix/qrCodes/decode"),
    CUSTOMER_ACCOUNT("customers"),
    NOTIFICATION("notifications"),
    CUSTOMER_ACCOUNT_NOTIFICATIONS("customers/$id/notifications");

    private final String value;

    private Domain(final String value) {
        this.value = value;
    }

    public String addPathVariable(String value) {
        return this.toString() + "/" + value;
    }

    public String toString() {
        return value;
    }
}
