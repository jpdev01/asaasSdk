package br.com.jpdev01.asaassdk.rest.pix.qrcode.decode;

import br.com.jpdev01.asaassdk.rest.pix.PixTransactionExternalAccount;

public class PixDecodedQrCode {

    public String payload;
    public String type;
    public String transactionOriginType;
    public String pixKey;
    public String conciliationIdentifier;
    public String endToEndIdentifier;
    public String dueDate;
    public String expirationDate;
    public Object finality;
    public double value;
    public Object changeValue;
    public boolean canBePaidWithDifferentValue;
    public boolean canModifyCashValue;
    public double interest;
    public double fine;
    public double discount;
    public double totalValue;
    public PixTransactionExternalAccount receiver;
    public PixQrCodePayer payer;
    public String description;
    public boolean canBePaid;
    public Object cannotBePaidReason;

    public PixDecodedQrCode() {

    }
    public String getPayload() {
        return payload;
    }

    public PixDecodedQrCode setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    public String getType() {
        return type;
    }

    public PixDecodedQrCode setType(String type) {
        this.type = type;
        return this;
    }

    public String getTransactionOriginType() {
        return transactionOriginType;
    }

    public PixDecodedQrCode setTransactionOriginType(String transactionOriginType) {
        this.transactionOriginType = transactionOriginType;
        return this;
    }

    public String getPixKey() {
        return pixKey;
    }

    public PixDecodedQrCode setPixKey(String pixKey) {
        this.pixKey = pixKey;
        return this;
    }

    public String getConciliationIdentifier() {
        return conciliationIdentifier;
    }

    public PixDecodedQrCode setConciliationIdentifier(String conciliationIdentifier) {
        this.conciliationIdentifier = conciliationIdentifier;
        return this;
    }

    public String getEndToEndIdentifier() {
        return endToEndIdentifier;
    }

    public PixDecodedQrCode setEndToEndIdentifier(String endToEndIdentifier) {
        this.endToEndIdentifier = endToEndIdentifier;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public PixDecodedQrCode setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public PixDecodedQrCode setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Object getFinality() {
        return finality;
    }

    public PixDecodedQrCode setFinality(Object finality) {
        this.finality = finality;
        return this;
    }

    public double getValue() {
        return value;
    }

    public PixDecodedQrCode setValue(double value) {
        this.value = value;
        return this;
    }

    public Object getChangeValue() {
        return changeValue;
    }

    public PixDecodedQrCode setChangeValue(Object changeValue) {
        this.changeValue = changeValue;
        return this;
    }

    public boolean isCanBePaidWithDifferentValue() {
        return canBePaidWithDifferentValue;
    }

    public PixDecodedQrCode setCanBePaidWithDifferentValue(boolean canBePaidWithDifferentValue) {
        this.canBePaidWithDifferentValue = canBePaidWithDifferentValue;
        return this;
    }

    public boolean isCanModifyCashValue() {
        return canModifyCashValue;
    }

    public PixDecodedQrCode setCanModifyCashValue(boolean canModifyCashValue) {
        this.canModifyCashValue = canModifyCashValue;
        return this;
    }

    public double getInterest() {
        return interest;
    }

    public PixDecodedQrCode setInterest(double interest) {
        this.interest = interest;
        return this;
    }

    public double getFine() {
        return fine;
    }

    public PixDecodedQrCode setFine(double fine) {
        this.fine = fine;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public PixDecodedQrCode setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public PixDecodedQrCode setTotalValue(double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public PixTransactionExternalAccount getReceiver() {
        return receiver;
    }

    public PixDecodedQrCode setReceiver(PixTransactionExternalAccount receiver) {
        this.receiver = receiver;
        return this;
    }

    public PixQrCodePayer getPayer() {
        return payer;
    }

    public PixDecodedQrCode setPayer(PixQrCodePayer payer) {
        this.payer = payer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PixDecodedQrCode setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isCanBePaid() {
        return canBePaid;
    }

    public PixDecodedQrCode setCanBePaid(boolean canBePaid) {
        this.canBePaid = canBePaid;
        return this;
    }

    public Object getCannotBePaidReason() {
        return cannotBePaidReason;
    }

    public PixDecodedQrCode setCannotBePaidReason(Object cannotBePaidReason) {
        this.cannotBePaidReason = cannotBePaidReason;
        return this;
    }
}
