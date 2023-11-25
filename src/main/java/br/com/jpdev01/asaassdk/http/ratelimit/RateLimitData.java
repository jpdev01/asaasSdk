package br.com.jpdev01.asaassdk.http.ratelimit;

public class RateLimitData {

    private final int limit;
    private final int remaining;
    private final int reset;

    public RateLimitData(int limit, int remaining, int reset) {
        this.limit = limit;
        this.remaining = remaining;
        this.reset = reset;
    }

    public int getLimit() {
        return limit;
    }

    public int getRemaining() {
        return remaining;
    }

    public int getReset() {
        return reset;
    }
}
