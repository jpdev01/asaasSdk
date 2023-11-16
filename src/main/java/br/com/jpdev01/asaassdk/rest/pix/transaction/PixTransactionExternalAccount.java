package br.com.jpdev01.asaassdk.rest.pix.transaction;

import br.com.jpdev01.asaassdk.utils.PersonType;
import br.com.jpdev01.asaassdk.utils.pix.PixAccountType;

public class PixTransactionExternalAccount {

    public int ispb;
    public String ispbName;

    public String name;
    public Object tradingName;
    public String cpfCnpj;
    public PersonType personType;
    public String agency;
    public String account;

    public String accountDigit;

    public String addressKey;

    public String addressKeyType;

    public PixAccountType accountType;

}
