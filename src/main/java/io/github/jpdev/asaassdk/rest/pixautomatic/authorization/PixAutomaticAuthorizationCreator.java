package io.github.jpdev.asaassdk.rest.pixautomatic.authorization;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate.ImmediateQrCodeCreator;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationFrequency;

import java.math.BigDecimal;
import java.util.Date;

public class PixAutomaticAuthorizationCreator extends Creator<PixAutomaticAuthorization> {

    private Date startDate;
    private Date finishDate;
    private String customer;
    private PixAutomaticAuthorizationFrequency frequency;
    private String contractId;
    private BigDecimal value;
    private String description;
    private BigDecimal minLimitValue;
    private ImmediateQrCodeCreator immediateQrCode;

    public PixAutomaticAuthorizationCreator setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public PixAutomaticAuthorizationCreator setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public PixAutomaticAuthorizationCreator setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public PixAutomaticAuthorizationCreator setFrequency(PixAutomaticAuthorizationFrequency frequency) {
        this.frequency = frequency;
        return this;
    }

    public PixAutomaticAuthorizationCreator setContractId(String contractId) {
        this.contractId = contractId;
        return this;
    }

    public PixAutomaticAuthorizationCreator setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public PixAutomaticAuthorizationCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public PixAutomaticAuthorizationCreator setMinLimitValue(BigDecimal minLimitValue) {
        this.minLimitValue = minLimitValue;
        return this;
    }

    public PixAutomaticAuthorizationCreator setImmediateQrCode(ImmediateQrCodeCreator immediateQrCode) {
        this.immediateQrCode = immediateQrCode;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PIX_AUTOMATIC_AUTHORIZATION.toString();
    }

    @Override
    public Class<PixAutomaticAuthorization> getResourceClass() {
        return PixAutomaticAuthorization.class;
    }
}
