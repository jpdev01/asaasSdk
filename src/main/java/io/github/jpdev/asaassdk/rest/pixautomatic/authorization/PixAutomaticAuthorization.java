package io.github.jpdev.asaassdk.rest.pixautomatic.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate.ImmediateQrCode;
import io.github.jpdev.asaassdk.rest.pixautomatic.authorization.immediate.ImmediateQrCodeCreator;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationFrequency;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationOriginType;
import io.github.jpdev.asaassdk.utils.PixAutomaticAuthorizationStatus;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PixAutomaticAuthorization {

    private String id;
    private BigDecimal minLimitValue;
    private Date cancellationDate;
    private String cancellationReason;
    private String contractId;
    private String customerId;
    private String description;
    private Date finishDate;
    private PixAutomaticAuthorizationFrequency frequency;
    private String endToEndIdentifier;
    private Date startDate;
    private PixAutomaticAuthorizationStatus status;
    private BigDecimal value;
    private String payload;
    private String encodedImage;
    private ImmediateQrCode immediateQrCode;
    private PixAutomaticAuthorizationOriginType originType;
    private String subscriptionId;

    public static PixAutomaticAuthorizationCreator creator() {
        return new PixAutomaticAuthorizationCreator();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getMinLimitValue() {
        return minLimitValue;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public String getContractId() {
        return contractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDescription() {
        return description;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public PixAutomaticAuthorizationFrequency getFrequency() {
        return frequency;
    }

    public String getEndToEndIdentifier() {
        return endToEndIdentifier;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PixAutomaticAuthorizationStatus getStatus() {
        return status;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getPayload() {
        return payload;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public ImmediateQrCode getImmediateQrCode() {
        return immediateQrCode;
    }

    public PixAutomaticAuthorizationOriginType getOriginType() {
        return originType;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public ImmediateQrCodeCreator immediateQrCodeCreator() {
        return new ImmediateQrCodeCreator();
    }
}
