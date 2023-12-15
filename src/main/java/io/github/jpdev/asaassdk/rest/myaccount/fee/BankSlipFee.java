package io.github.jpdev.asaassdk.rest.myaccount.fee;

public class BankSlipFee {

    public double defaultValue;
    public double discountValue;
    public String expirationDate;
    public double monthlyFeePercentage;

    public double getDefaultValue() {
        return defaultValue;
    }

    public BankSlipFee setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public BankSlipFee setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public BankSlipFee setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public double getMonthlyFeePercentage() {
        return monthlyFeePercentage;
    }

    public BankSlipFee setMonthlyFeePercentage(double monthlyFeePercentage) {
        this.monthlyFeePercentage = monthlyFeePercentage;
        return this;
    }
}
