package br.com.jpdev01.asaassdk.rest.pix.addresskey;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Creator;
import br.com.jpdev01.asaassdk.rest.pix.enums.PixAddressKeyType;

public class PixAddressKeyCreator extends Creator<PixAddressKey> {

    private PixAddressKeyType type;

    public PixAddressKeyType getType() {
        return type;
    }

    public PixAddressKeyCreator setType(PixAddressKeyType type) {
        this.type = type;
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
