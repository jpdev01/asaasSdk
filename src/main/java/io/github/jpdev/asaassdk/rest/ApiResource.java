package io.github.jpdev.asaassdk.rest;

import io.github.jpdev.asaassdk.http.ratelimit.RateLimitData;

public class ApiResource {

    RateLimitData rateLimit;

    public RateLimitData getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(RateLimitData rateLimit) {
        this.rateLimit = rateLimit;
    }
}
