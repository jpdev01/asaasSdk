package br.com.jpdev01.asaassdk.rest.myaccount.fee;

public class CreditBureauReportFee {

    public double naturalPersonFeeValue;
    public double legalPersonFeeValue;

    public double getNaturalPersonFeeValue() {
        return naturalPersonFeeValue;
    }

    public CreditBureauReportFee setNaturalPersonFeeValue(double naturalPersonFeeValue) {
        this.naturalPersonFeeValue = naturalPersonFeeValue;
        return this;
    }

    public double getLegalPersonFeeValue() {
        return legalPersonFeeValue;
    }

    public CreditBureauReportFee setLegalPersonFeeValue(double legalPersonFeeValue) {
        this.legalPersonFeeValue = legalPersonFeeValue;
        return this;
    }
}
