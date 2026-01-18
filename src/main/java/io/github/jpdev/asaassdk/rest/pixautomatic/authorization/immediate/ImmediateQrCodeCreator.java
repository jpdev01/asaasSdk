package io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate;

import java.math.BigDecimal;

public class ImmediateQrCodeCreator {

    private String pixKey;
    private Integer expirationSeconds;
    private BigDecimal originalValue;
    private String description;

    public ImmediateQrCodeCreator setPixKey(String pixKey) {
        this.pixKey = pixKey;
        return this;
    }

    public ImmediateQrCodeCreator setExpirationSeconds(Integer expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
        return this;
    }

    public ImmediateQrCodeCreator setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
        return this;
    }

    public ImmediateQrCodeCreator setDescription(String description) {
        this.description = description;
        return this;
    }
}
