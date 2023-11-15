package br.com.jpdev01.asaassdk.rest.pix;

import br.com.jpdev01.asaassdk.utils.pix.PixTransactionStatus;
import br.com.jpdev01.asaassdk.utils.pix.PixTransactionType;

import java.math.BigDecimal;
import java.util.Date;

public class PixTransaction {

    public String id;
    public Object transferId;
    public String endToEndIdentifier;
    public Object finality;

    public BigDecimal value;
    public Object changeValue;
    public int refundedValue;
    public String dateCreated;
    public String effectiveDate;
    public Date scheduledDate;
    public PixTransactionStatus status;

    public PixTransactionType type;
    public String originType;
    public Object conciliationIdentifier;
    public Object description;
    public String transactionReceiptUrl;
    public int chargedFeeValue;
    public boolean canBeRefunded;
    public Object refundDisabledReason;
    public Object refusalReason;
    public boolean canBeCanceled;
    public Object originalTransaction;
    public PixTransactionExternalAccount externalAccount;
    public Object qrCode;
    public Object payment;
    public Object addressKey;
    public Object addressKeyType;

    public PixTransaction() {

    }

    public static PixTransactionReader reader() {
        return new PixTransactionReader();
    }
}
