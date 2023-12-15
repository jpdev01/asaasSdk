package io.github.jpdev.asaassdk.rest.pix.addresskey;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;

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
