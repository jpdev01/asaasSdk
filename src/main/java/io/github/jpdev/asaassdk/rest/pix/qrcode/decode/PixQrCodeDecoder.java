package io.github.jpdev.asaassdk.rest.pix.qrcode.decode;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

public class PixQrCodeDecoder extends Creator<PixDecodedQrCode> {


    public String payload;

    public String getPayload() {
        return payload;
    }

    public PixQrCodeDecoder setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.DECODE_PIX_QR_CODE.toString();
    }

    @Override
    public Class<PixDecodedQrCode> getResourceClass() {
        return PixDecodedQrCode.class;
    }
}
