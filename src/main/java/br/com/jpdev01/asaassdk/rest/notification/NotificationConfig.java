package br.com.jpdev01.asaassdk.rest.notification;

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
    public String event;
    public int scheduleOffset;
    public boolean deleted;

    public static NotificationConfigUpdater updater(Long id) {
        return new NotificationConfigUpdater(id);
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
}
