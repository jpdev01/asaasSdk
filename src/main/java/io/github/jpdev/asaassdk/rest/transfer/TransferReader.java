package io.github.jpdev.asaassdk.rest.transfer;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class TransferReader extends Reader<Transfer> {


    @Override
    public String getResourceUrl() {
        return Domain.TRANSFER.toString();
    }

    @Override
    public Class<Transfer> getResourceClass() {
        return Transfer.class;
    }
}
