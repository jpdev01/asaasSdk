package io.github.jpdev.asaassdk.rest.payment.identificationfield;

public class PaymentIdentificationField {

    String identificationField;
    String nossoNumero;
    String barCode;

    public PaymentIdentificationField() {

    }

    public String getIdentificationField() {
        return identificationField;
    }

    public PaymentIdentificationField setIdentificationField(String identificationField) {
        this.identificationField = identificationField;
        return this;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public PaymentIdentificationField setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
        return this;
    }

    public String getBarCode() {
        return barCode;
    }

    public PaymentIdentificationField setBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }
}
