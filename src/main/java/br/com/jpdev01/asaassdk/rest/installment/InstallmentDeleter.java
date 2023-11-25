package br.com.jpdev01.asaassdk.rest.installment;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Deleter;
import br.com.jpdev01.asaassdk.rest.commons.DeletedResource;

public class InstallmentDeleter extends Deleter<DeletedResource> {

    private final String id;

    public InstallmentDeleter(String id) {
        this.id = id;
    }

    @Override
    public String getResourceUrl() {
        return Domain.INSTALLMENT.addPathVariable(this.id);
    }

    @Override
    public Class<DeletedResource> getResourceClass() {
        return DeletedResource.class;
    }
}
