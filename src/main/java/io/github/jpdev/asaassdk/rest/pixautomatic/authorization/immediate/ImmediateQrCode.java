package io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate;

import java.util.Date;

public class ImmediateQrCode {

    private String conciliationIdentifier;
    private Date expirationDate;

    public String getConciliationIdentifier() {
        return conciliationIdentifier;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
