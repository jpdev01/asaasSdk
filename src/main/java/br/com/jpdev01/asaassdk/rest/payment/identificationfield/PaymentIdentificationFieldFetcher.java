package br.com.jpdev01.asaassdk.rest.payment.identificationfield;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Fetcher;

public class PaymentIdentificationFieldFetcher extends Fetcher<PaymentIdentificationField> {

    final String id;

    public PaymentIdentificationFieldFetcher(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT.addVariableList(this.id, "identificationField");
    }

    @Override
    public Class<PaymentIdentificationField> getResourceClass() {
        return PaymentIdentificationField.class;
    }
}
