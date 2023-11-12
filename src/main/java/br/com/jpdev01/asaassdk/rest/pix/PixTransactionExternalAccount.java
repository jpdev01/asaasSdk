package br.com.jpdev01.asaassdk.rest.pix;

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
    public PixAccountType accountType;

    public int getIspb() {
        return ispb;
    }

    public PixTransactionExternalAccount setIspb(int ispb) {
        this.ispb = ispb;
        return this;
    }

    public String getIspbName() {
        return ispbName;
    }

    public PixTransactionExternalAccount setIspbName(String ispbName) {
        this.ispbName = ispbName;
        return this;
    }

    public String getName() {
        return name;
    }

    public PixTransactionExternalAccount setName(String name) {
        this.name = name;
        return this;
    }

    public Object getTradingName() {
        return tradingName;
    }

    public PixTransactionExternalAccount setTradingName(Object tradingName) {
        this.tradingName = tradingName;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public PixTransactionExternalAccount setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public PixTransactionExternalAccount setPersonType(PersonType personType) {
        this.personType = personType;
        return this;
    }

    public String getAgency() {
        return agency;
    }

    public PixTransactionExternalAccount setAgency(String agency) {
        this.agency = agency;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public PixTransactionExternalAccount setAccount(String account) {
        this.account = account;
        return this;
    }

    public PixAccountType getAccountType() {
        return accountType;
    }

    public PixTransactionExternalAccount setAccountType(PixAccountType accountType) {
        this.accountType = accountType;
        return this;
    }
}
