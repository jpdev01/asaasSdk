package br.com.jpdev01.asaassdk.rest.myaccount.fee;

public class PaymentFee {

    public BankSlipFee bankSlip;
    public CreditCardFee creditCard;
    public DebitCardFee debitCard;
    public PixFee pix;

    public PaymentFee() {}

    public BankSlipFee getBankSlip() {
        return bankSlip;
    }

    public PaymentFee setBankSlip(BankSlipFee bankSlip) {
        this.bankSlip = bankSlip;
        return this;
    }

    public CreditCardFee getCreditCard() {
        return creditCard;
    }

    public PaymentFee setCreditCard(CreditCardFee creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    public DebitCardFee getDebitCard() {
        return debitCard;
    }

    public PaymentFee setDebitCard(DebitCardFee debitCard) {
        this.debitCard = debitCard;
        return this;
    }

    public PixFee getPix() {
        return pix;
    }

    public PaymentFee setPix(PixFee pix) {
        this.pix = pix;
        return this;
    }
}
