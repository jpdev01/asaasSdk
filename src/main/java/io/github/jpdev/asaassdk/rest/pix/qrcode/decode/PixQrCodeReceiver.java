package io.github.jpdev.asaassdk.rest.pix.qrcode.decode;

import io.github.jpdev.asaassdk.utils.PersonType;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAccountType;

public class PixQrCodeReceiver {

    public int ispb;
    public String ispbName;

    public String name;
    public Object tradingName;
    public String cpfCnpj;
    public PersonType personType;
    public String agency;
    public String account;
    public PixAccountType accountType;
}
