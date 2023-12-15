package io.github.jpdev.asaassdk.rest.installment;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

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
