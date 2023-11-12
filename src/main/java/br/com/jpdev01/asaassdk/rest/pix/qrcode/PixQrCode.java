package br.com.jpdev01.asaassdk.rest.pix.qrcode;

public class PixQrCode {

    public String id;
    public String encodedImage;
    public String payload;
    public boolean allowsMultiplePayments;
    public String expirationDate;

    public PixQrCode() {
    }

    public static PixQrCodeCreator creator() {
        return new PixQrCodeCreator();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public boolean isAllowsMultiplePayments() {
        return allowsMultiplePayments;
    }

    public void setAllowsMultiplePayments(boolean allowsMultiplePayments) {
        this.allowsMultiplePayments = allowsMultiplePayments;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
