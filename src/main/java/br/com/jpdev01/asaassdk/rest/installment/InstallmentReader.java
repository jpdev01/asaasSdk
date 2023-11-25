package br.com.jpdev01.asaassdk.rest.installment;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;

public class InstallmentReader extends Reader<Installment> {

    @Override
    public String getResourceUrl() {
        return Domain.INSTALLMENT.toString();
    }

    @Override
    public Class<Installment> getResourceClass() {
        return Installment.class;
    }
}
