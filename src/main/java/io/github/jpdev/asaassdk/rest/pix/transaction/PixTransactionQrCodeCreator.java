package io.github.jpdev.asaassdk.rest.pix.transaction;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.pix.transaction.children.QrCode;

import java.math.BigDecimal;

public class PixTransactionQrCodeCreator extends Creator<PixTransaction> {

    private QrCode qrCode;
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public PixTransactionQrCodeCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public PixTransactionQrCodeCreator setPayload(String payload) {
        this.qrCode = new QrCode().setPayload(payload);
        return this;
    }

    public QrCode getQrCode() {
        return qrCode;
    }

    public String getResourceUrl() {
        return Domain.PIX_TRANSACTION_QR_CODE.toString();
    }

    public Class<PixTransaction> getResourceClass() {
        return PixTransaction.class;
    }
}
