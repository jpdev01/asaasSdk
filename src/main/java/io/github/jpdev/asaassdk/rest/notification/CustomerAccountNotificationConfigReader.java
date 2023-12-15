package io.github.jpdev.asaassdk.rest.notification;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class CustomerAccountNotificationConfigReader extends Reader<NotificationConfig> {

    public String customerAccountId;

    public CustomerAccountNotificationConfigReader(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    @Override
    public String getResourceUrl() {
        return Domain.CUSTOMER_ACCOUNT_NOTIFICATIONS.toString().replace("$id", this.customerAccountId);
    }

    @Override
    public Class<NotificationConfig> getResourceClass() {
        return NotificationConfig.class;
    }
}
