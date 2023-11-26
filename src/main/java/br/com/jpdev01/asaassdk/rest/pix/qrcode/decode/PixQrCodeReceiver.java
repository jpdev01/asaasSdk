package br.com.jpdev01.asaassdk.rest.pix.qrcode.decode;

import br.com.jpdev01.asaassdk.utils.PersonType;
import br.com.jpdev01.asaassdk.rest.pix.enums.PixAccountType;

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
