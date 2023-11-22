package br.com.jpdev01.asaassdk.rest.notification;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Updater;

public class NotificationConfigUpdater extends Updater<NotificationConfig> {

    private Long id;
    Boolean enabled;
    Boolean emailEnabledForProvider;
    Boolean smsEnabledForProvider;
    Boolean emailEnabledForCustomer;
    Boolean smsEnabledForCustomer;
    Boolean phoneCallEnabledForCustomer;
    Boolean whatsappEnabledForCustomer;
    String scheduleOffset;

    public NotificationConfigUpdater(Long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public NotificationConfigUpdater setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getEmailEnabledForProvider() {
        return emailEnabledForProvider;
    }

    public NotificationConfigUpdater setEmailEnabledForProvider(Boolean emailEnabledForProvider) {
        this.emailEnabledForProvider = emailEnabledForProvider;
        return this;
    }

    public Boolean getSmsEnabledForProvider() {
        return smsEnabledForProvider;
    }

    public NotificationConfigUpdater setSmsEnabledForProvider(Boolean smsEnabledForProvider) {
        this.smsEnabledForProvider = smsEnabledForProvider;
        return this;
    }

    public Boolean getEmailEnabledForCustomer() {
        return emailEnabledForCustomer;
    }

    public NotificationConfigUpdater setEmailEnabledForCustomer(Boolean emailEnabledForCustomer) {
        this.emailEnabledForCustomer = emailEnabledForCustomer;
        return this;
    }

    public Boolean getSmsEnabledForCustomer() {
        return smsEnabledForCustomer;
    }

    public NotificationConfigUpdater setSmsEnabledForCustomer(Boolean smsEnabledForCustomer) {
        this.smsEnabledForCustomer = smsEnabledForCustomer;
        return this;
    }

    public Boolean getPhoneCallEnabledForCustomer() {
        return phoneCallEnabledForCustomer;
    }

    public NotificationConfigUpdater setPhoneCallEnabledForCustomer(Boolean phoneCallEnabledForCustomer) {
        this.phoneCallEnabledForCustomer = phoneCallEnabledForCustomer;
        return this;
    }

    public Boolean getWhatsappEnabledForCustomer() {
        return whatsappEnabledForCustomer;
    }

    public NotificationConfigUpdater setWhatsappEnabledForCustomer(Boolean whatsappEnabledForCustomer) {
        this.whatsappEnabledForCustomer = whatsappEnabledForCustomer;
        return this;
    }

    public String getScheduleOffset() {
        return scheduleOffset;
    }

    public NotificationConfigUpdater setScheduleOffset(String scheduleOffset) {
        this.scheduleOffset = scheduleOffset;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.NOTIFICATION.addPathVariable(this.id.toString());
    }

    @Override
    public Class<NotificationConfig> getResourceClass() {
        return null;
    }
}
