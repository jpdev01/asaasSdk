package br.com.jpdev01.asaassdk.rest.transfer;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;

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
