package io.github.jpdev.asaassdk.rest.pix.transaction;

import io.github.jpdev.asaassdk.utils.PersonType;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAccountType;

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
