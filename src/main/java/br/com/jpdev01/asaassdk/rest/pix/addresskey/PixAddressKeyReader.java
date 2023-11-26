package br.com.jpdev01.asaassdk.rest.pix.addresskey;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Reader;
import br.com.jpdev01.asaassdk.rest.pix.enums.PixAddressKeyStatus;

public class PixAddressKeyReader extends Reader<PixAddressKey> {

    public PixAddressKeyStatus status;

    public PixAddressKeyStatus getStatus() {
        return status;
    }

    public PixAddressKeyReader setStatus(PixAddressKeyStatus status) {
        addFilter("status");
        this.status = status;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_ADDRESS_KEY.toString();
    }

    @Override
    public Class<PixAddressKey> getResourceClass() {
        return PixAddressKey.class;
    }
}
