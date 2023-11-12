package br.com.jpdev01.asaassdk.rest.pix.addresskey;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;

public class PixAddressKeyReader extends Reader<PixAddressKey> {
    @Override
    public String getResourceUrl() {
        return Domain.PIX_ADDRESS_KEY.toString();
    }

    @Override
    public Class<PixAddressKey> getResourceClass() {
        return PixAddressKey.class;
    }
}
