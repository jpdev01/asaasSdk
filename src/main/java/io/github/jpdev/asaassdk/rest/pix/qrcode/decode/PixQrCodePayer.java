package io.github.jpdev.asaassdk.rest.pix.qrcode.decode;

public class PixQrCodePayer {

    public String name;
    public String cpfCnpj;

    public PixQrCodePayer() {

    }

    public String getName() {
        return name;
    }

    public PixQrCodePayer setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public PixQrCodePayer setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }
}
