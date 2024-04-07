package io.github.jpdev.asaassdk.rest.webhook;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

import java.util.ArrayList;

public class WebhookCreator extends Creator<Webhook> {

    public String name;
    public String url;
    public String email;
    public SendType sendType;
    public boolean enabled;
    public boolean interrupted;
    public String authToken;
    public ArrayList<Event> events;

    @Override
    public String getResourceUrl() {
        return Domain.WEBHOOK.toString();
    }

    @Override
    public Class<Webhook> getResourceClass() {
        return Webhook.class;
    }

    public String getName() {
        return name;
    }

    public WebhookCreator setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public WebhookCreator setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WebhookCreator setEmail(String email) {
        this.email = email;
        return this;
    }

    public SendType getSendType() {
        return sendType;
    }

    public WebhookCreator setSendType(SendType sendType) {
        this.sendType = sendType;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public WebhookCreator setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public WebhookCreator setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
        return this;
    }

    public String getAuthToken() {
        return authToken;
    }

    public WebhookCreator setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public WebhookCreator setEvents(ArrayList<Event> events) {
        this.events = events;
        return this;
    }

    public WebhookCreator addEvent(Event event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
        return this;
    }
}
