package br.com.jpdev01.asaassdk.rest.pix.qrcode.decode;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;

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
