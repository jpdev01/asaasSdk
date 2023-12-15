package io.github.jpdev.asaassdk.rest.notification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationConfig {

    public String object;
    public String id;
    public String customer;
    public boolean enabled;
    public boolean emailEnabledForProvider;
    public boolean smsEnabledForProvider;
    public boolean emailEnabledForCustomer;
    public boolean smsEnabledForCustomer;
    public boolean phoneCallEnabledForCustomer;
    public boolean whatsappEnabledForCustomer;
    public String event;
    public int scheduleOffset;
    public boolean deleted;

    public static NotificationConfigUpdater updater(String id) {
        return new NotificationConfigUpdater(id);
    }

    public static CustomerAccountNotificationConfigReader customerAccountReader(String customerAccountId) {
        return new CustomerAccountNotificationConfigReader(customerAccountId);
    }

    public String getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isEmailEnabledForProvider() {
        return emailEnabledForProvider;
    }

    public boolean isSmsEnabledForProvider() {
        return smsEnabledForProvider;
    }

    public boolean isEmailEnabledForCustomer() {
        return emailEnabledForCustomer;
    }

    public boolean isSmsEnabledForCustomer() {
        return smsEnabledForCustomer;
    }

    public boolean isPhoneCallEnabledForCustomer() {
        return phoneCallEnabledForCustomer;
    }

    public String getEvent() {
        return event;
    }

    public int getScheduleOffset() {
        return scheduleOffset;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isWhatsappEnabledForCustomer() {
        return whatsappEnabledForCustomer;
    }
}
