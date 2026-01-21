package io.github.jpdev.asaassdk.rest.pixautomatic.authorization;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate.ImmediateQrCodeCreator;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationFrequency;

import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PixAutomaticAuthorizationCreator extends Creator<PixAutomaticAuthorization> {

    private Date startDate;
    private Date finishDate;
    private String customerId;
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

    public PixAutomaticAuthorizationCreator setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public PixAutomaticAuthorizationFrequency getFrequency() {
        return frequency;
    }

    public String getContractId() {
        return contractId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMinLimitValue() {
        return minLimitValue;
    }

    public ImmediateQrCodeCreator getImmediateQrCode() {
        return immediateQrCode;
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
