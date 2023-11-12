package br.com.jpdev01.asaassdk.rest.pix.qrcode;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;

import java.math.BigDecimal;

public class PixQrCodeCreator extends Creator<PixQrCode> {

    public String addressKey;

    public String description;

    public BigDecimal value;

    public String format;

    public String expirationDate;

    public Integer expirationSeconds;

    public Boolean allowsMultiplePayments;

    public PixQrCodeCreator() {

    }

    public String getAddressKey() {
        return addressKey;
    }

    public PixQrCodeCreator setAddressKey(String addressKey) {
        this.addressKey = addressKey;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PixQrCodeCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PixQrCodeCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public PixQrCodeCreator setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public PixQrCodeCreator setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Integer getExpirationSeconds() {
        return expirationSeconds;
    }

    public PixQrCodeCreator setExpirationSeconds(Integer expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
        return this;
    }

    public Boolean getAllowsMultiplePayments() {
        return allowsMultiplePayments;
    }

    public PixQrCodeCreator setAllowsMultiplePayments(Boolean allowsMultiplePayments) {
        this.allowsMultiplePayments = allowsMultiplePayments;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.STATIC_PIX_QR_CODE.toString();
    }

    @Override
    public Class<PixQrCode> getResourceClass() {
        return PixQrCode.class;
    }
}
