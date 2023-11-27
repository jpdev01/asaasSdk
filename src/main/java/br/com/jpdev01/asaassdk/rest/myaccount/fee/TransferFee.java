package br.com.jpdev01.asaassdk.rest.myaccount.fee;

public class TransferFee {

    public int monthlyTransfersWithoutFee;
    public TedFee ted;
    public PixFee pix;

    public int getMonthlyTransfersWithoutFee() {
        return monthlyTransfersWithoutFee;
    }

    public TransferFee setMonthlyTransfersWithoutFee(int monthlyTransfersWithoutFee) {
        this.monthlyTransfersWithoutFee = monthlyTransfersWithoutFee;
        return this;
    }

    public TedFee getTed() {
        return ted;
    }

    public TransferFee setTed(TedFee ted) {
        this.ted = ted;
        return this;
    }

    public PixFee getPix() {
        return pix;
    }

    public TransferFee setPix(PixFee pix) {
        this.pix = pix;
        return this;
    }
}
