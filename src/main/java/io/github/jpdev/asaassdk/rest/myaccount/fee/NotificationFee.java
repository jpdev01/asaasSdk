package io.github.jpdev.asaassdk.rest.myaccount.fee;

public class NotificationFee {

    public double phoneCallFeeValue;
    public double whatsAppFeeValue;
    public double messagingFeeValue;

    public double getPhoneCallFeeValue() {
        return phoneCallFeeValue;
    }

    public NotificationFee setPhoneCallFeeValue(double phoneCallFeeValue) {
        this.phoneCallFeeValue = phoneCallFeeValue;
        return this;
    }

    public double getWhatsAppFeeValue() {
        return whatsAppFeeValue;
    }

    public NotificationFee setWhatsAppFeeValue(double whatsAppFeeValue) {
        this.whatsAppFeeValue = whatsAppFeeValue;
        return this;
    }

    public double getMessagingFeeValue() {
        return messagingFeeValue;
    }

    public NotificationFee setMessagingFeeValue(double messagingFeeValue) {
        this.messagingFeeValue = messagingFeeValue;
        return this;
    }
}
