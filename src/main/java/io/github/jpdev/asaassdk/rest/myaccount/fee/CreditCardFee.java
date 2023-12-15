package io.github.jpdev.asaassdk.rest.myaccount.fee;

public class CreditCardFee {

    public double operationValue;
    public double oneInstallmentPercentage;
    public double upToSixInstallmentsPercentage;
    public double upToTwelveInstallmentsPercentage;
    public double discountOneInstallmentPercentage;
    public double discountUpToSixInstallmentsPercentage;
    public double discountUpToTwelveInstallmentsPercentage;
    public String discountExpiration;
    public int detachedMonthlyFeeValue;
    public double installmentMonthlyFeeValue;

    public Boolean hasValidDiscount;

    public double getOperationValue() {
        return operationValue;
    }

    public CreditCardFee setOperationValue(double operationValue) {
        this.operationValue = operationValue;
        return this;
    }

    public double getOneInstallmentPercentage() {
        return oneInstallmentPercentage;
    }

    public CreditCardFee setOneInstallmentPercentage(double oneInstallmentPercentage) {
        this.oneInstallmentPercentage = oneInstallmentPercentage;
        return this;
    }

    public double getUpToSixInstallmentsPercentage() {
        return upToSixInstallmentsPercentage;
    }

    public CreditCardFee setUpToSixInstallmentsPercentage(double upToSixInstallmentsPercentage) {
        this.upToSixInstallmentsPercentage = upToSixInstallmentsPercentage;
        return this;
    }

    public double getUpToTwelveInstallmentsPercentage() {
        return upToTwelveInstallmentsPercentage;
    }

    public CreditCardFee setUpToTwelveInstallmentsPercentage(double upToTwelveInstallmentsPercentage) {
        this.upToTwelveInstallmentsPercentage = upToTwelveInstallmentsPercentage;
        return this;
    }

    public double getDiscountOneInstallmentPercentage() {
        return discountOneInstallmentPercentage;
    }

    public CreditCardFee setDiscountOneInstallmentPercentage(double discountOneInstallmentPercentage) {
        this.discountOneInstallmentPercentage = discountOneInstallmentPercentage;
        return this;
    }

    public double getDiscountUpToSixInstallmentsPercentage() {
        return discountUpToSixInstallmentsPercentage;
    }

    public CreditCardFee setDiscountUpToSixInstallmentsPercentage(double discountUpToSixInstallmentsPercentage) {
        this.discountUpToSixInstallmentsPercentage = discountUpToSixInstallmentsPercentage;
        return this;
    }

    public double getDiscountUpToTwelveInstallmentsPercentage() {
        return discountUpToTwelveInstallmentsPercentage;
    }

    public CreditCardFee setDiscountUpToTwelveInstallmentsPercentage(double discountUpToTwelveInstallmentsPercentage) {
        this.discountUpToTwelveInstallmentsPercentage = discountUpToTwelveInstallmentsPercentage;
        return this;
    }

    public String getDiscountExpiration() {
        return discountExpiration;
    }

    public CreditCardFee setDiscountExpiration(String discountExpiration) {
        this.discountExpiration = discountExpiration;
        return this;
    }

    public int getDetachedMonthlyFeeValue() {
        return detachedMonthlyFeeValue;
    }

    public CreditCardFee setDetachedMonthlyFeeValue(int detachedMonthlyFeeValue) {
        this.detachedMonthlyFeeValue = detachedMonthlyFeeValue;
        return this;
    }

    public double getInstallmentMonthlyFeeValue() {
        return installmentMonthlyFeeValue;
    }

    public CreditCardFee setInstallmentMonthlyFeeValue(double installmentMonthlyFeeValue) {
        this.installmentMonthlyFeeValue = installmentMonthlyFeeValue;
        return this;
    }

    public Boolean getHasValidDiscount() {
        return hasValidDiscount;
    }

    public CreditCardFee setHasValidDiscount(Boolean hasValidDiscount) {
        this.hasValidDiscount = hasValidDiscount;
        return this;
    }
}
