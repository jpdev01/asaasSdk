package io.github.jpdev.asaassdk.rest.accounts;

public class Webhook {

    String url;
    String email;
    Integer apiVersion;
    boolean enabled;
    boolean interrupted;
    String authToken;

    public String getUrl() {
        return url;
    }

    public Webhook setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Webhook setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getApiVersion() {
        return apiVersion;
    }

    public Webhook setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Webhook setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public Webhook setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
        return this;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Webhook setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }
}
