package io.github.jpdev.asaassdk.rest.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.jpdev.asaassdk.rest.ApiResource;
import io.github.jpdev.asaassdk.rest.transfer.children.response.BankAccount;
import io.github.jpdev.asaassdk.rest.transfer.children.response.TransferOperationType;
import io.github.jpdev.asaassdk.rest.transfer.children.response.TransferStatus;
import io.github.jpdev.asaassdk.rest.transfer.children.response.TransferType;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer extends ApiResource {

    private String object;
    private String id;
    private BigDecimal value;
    private BigDecimal netValue;
    private BigDecimal transferFee;
    private Date dateCreated;
    private TransferStatus status;
    private Date effectiveDate;
    private Date confirmedDate;
    private Object endToEndIdentifier;
    private Object transactionReceiptUrl;
    private TransferOperationType operationType;
    private String failReason;
    private String walletId;
    private String description;
    private boolean canBeCancelled;
    private String externalReference;
    private boolean authorized;
    private Date scheduleDate;
    private TransferType type;
    private BankAccount bankAccount;
    private String recurring;

    public String getObject() {
        return object;
    }

    public Transfer setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public Transfer setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Transfer setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public Transfer setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
        return this;
    }

    public BigDecimal getTransferFee() {
        return transferFee;
    }

    public Transfer setTransferFee(BigDecimal transferFee) {
        this.transferFee = transferFee;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Transfer setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public Transfer setStatus(TransferStatus status) {
        this.status = status;
        return this;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public Transfer setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public Transfer setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
        return this;
    }

    public Object getEndToEndIdentifier() {
        return endToEndIdentifier;
    }

    public Transfer setEndToEndIdentifier(Object endToEndIdentifier) {
        this.endToEndIdentifier = endToEndIdentifier;
        return this;
    }

    public Object getTransactionReceiptUrl() {
        return transactionReceiptUrl;
    }

    public Transfer setTransactionReceiptUrl(Object transactionReceiptUrl) {
        this.transactionReceiptUrl = transactionReceiptUrl;
        return this;
    }

    public TransferOperationType getOperationType() {
        return operationType;
    }

    public Transfer setOperationType(TransferOperationType operationType) {
        this.operationType = operationType;
        return this;
    }

    public String getFailReason() {
        return failReason;
    }

    public Transfer setFailReason(String failReason) {
        this.failReason = failReason;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public Transfer setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Transfer setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isCanBeCancelled() {
        return canBeCancelled;
    }

    public Transfer setCanBeCancelled(boolean canBeCancelled) {
        this.canBeCancelled = canBeCancelled;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public Transfer setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public Transfer setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public Transfer setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    public TransferType getType() {
        return type;
    }

    public Transfer setType(TransferType type) {
        this.type = type;
        return this;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Transfer setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public String getRecurring() {
        return recurring;
    }

    public Transfer setRecurring(String recurring) {
        this.recurring = recurring;
        return this;
    }

    public static TransferPixAddressKeyCreator pixAddressKeyCreator() {
        return new TransferPixAddressKeyCreator();
    }

    public static TransferPixManualCreator pixManualCreator() {
        return new TransferPixManualCreator();
    }

    public static TransferTedCreator tedCreator() {
        return new TransferTedCreator().setOperationType("TED");
    }

    public static TransferReader reader() {
        return new TransferReader();
    }

    public static TransferInternalCreator internalCreator() {
        return new TransferInternalCreator();
    }

    public static TransferFetcher fetcher(String id) {
        return new TransferFetcher(id);
    }

    public static TransferCanceller canceller(String id) {
        return new TransferCanceller(id);
    }
}
