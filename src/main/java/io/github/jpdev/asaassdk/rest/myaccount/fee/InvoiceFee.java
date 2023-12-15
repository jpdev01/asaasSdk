package io.github.jpdev.asaassdk.rest.myaccount.fee;

public class InvoiceFee {

    public double feeValue;

    public double getFeeValue() {
        return feeValue;
    }

    public InvoiceFee setFeeValue(double feeValue) {
        this.feeValue = feeValue;
        return this;
    }
}
