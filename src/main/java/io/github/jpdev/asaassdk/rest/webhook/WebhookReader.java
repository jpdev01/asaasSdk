package io.github.jpdev.asaassdk.rest.webhook;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;

public class WebhookReader extends Reader<Webhook> {

    @Override
    public String getResourceUrl() {
        return Domain.WEBHOOK.toString();
    }

    @Override
    public Class<Webhook> getResourceClass() {
        return Webhook.class;
    }
}
