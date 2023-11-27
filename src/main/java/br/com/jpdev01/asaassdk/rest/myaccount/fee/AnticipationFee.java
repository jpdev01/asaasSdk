package br.com.jpdev01.asaassdk.rest.myaccount.fee;

public class AnticipationFee {

    public CreditCardFee creditCard;
    public BankSlipFee bankSlip;

    public CreditCardFee getCreditCard() {
        return creditCard;
    }

    public AnticipationFee setCreditCard(CreditCardFee creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    public BankSlipFee getBankSlip() {
        return bankSlip;
    }

    public AnticipationFee setBankSlip(BankSlipFee bankSlip) {
        this.bankSlip = bankSlip;
        return this;
    }
}
