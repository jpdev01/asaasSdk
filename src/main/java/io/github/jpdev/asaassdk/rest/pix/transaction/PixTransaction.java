package io.github.jpdev.asaassdk.rest.pix.transaction;

import io.github.jpdev.asaassdk.rest.ApiResource;
import io.github.jpdev.asaassdk.rest.pix.enums.PixAddressKeyType;
import io.github.jpdev.asaassdk.rest.pix.enums.PixTransactionOriginType;
import io.github.jpdev.asaassdk.rest.pix.enums.PixTransactionStatus;
import io.github.jpdev.asaassdk.rest.pix.enums.PixTransactionType;

import java.math.BigDecimal;
import java.util.Date;

public class PixTransaction extends ApiResource {

    public String id;
    public Object transferId;
    public String endToEndIdentifier;
    public Object finality;

    public BigDecimal value;
    public BigDecimal changeValue;
    public BigDecimal refundedValue;
    public Date dateCreated;
    public Date effectiveDate;
    public Date scheduledDate;
    public PixTransactionStatus status;

    public PixTransactionType type;
    public PixTransactionOriginType originType;
    public String conciliationIdentifier;
    public String description;
    public String transactionReceiptUrl;
    public int chargedFeeValue;
    public boolean canBeRefunded;
    public String refundDisabledReason;
    public String refusalReason;
    public boolean canBeCanceled;
    public Object originalTransaction;
    public PixTransactionExternalAccount externalAccount;
    public Object qrCode;
    public Object payment;
    public String addressKey;
    public PixAddressKeyType addressKeyType;

    public PixTransaction() {

    }

    public static PixTransactionReader reader() {
        return new PixTransactionReader();
    }

    public static PixTransactionCanceller canceller(String id) {
        return new PixTransactionCanceller(id);
    }

    public static PixTransactionFetcher fetcher(Object id) {
        return new PixTransactionFetcher(id);
    }

    public static PixTransactionQrCodeCreator qrCodeCreator() {
        return new PixTransactionQrCodeCreator();
    }
}
