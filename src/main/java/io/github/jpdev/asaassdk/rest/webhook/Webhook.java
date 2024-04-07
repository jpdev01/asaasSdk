package io.github.jpdev.asaassdk.rest.webhook;

import java.util.ArrayList;

public class Webhook {

    public String id;
    public String name;
    public String url;
    public String email;
    public boolean enabled;
    public boolean interrupted;
    public int apiVersion;
    public String authToken;
    public String sendType;
    public ArrayList<Event> events;

    public Webhook() {
    }

    public static WebhookReader reader() {
        return new WebhookReader();
    }

    public static WebhookCreator creator() {
        return new WebhookCreator();
    }
}
