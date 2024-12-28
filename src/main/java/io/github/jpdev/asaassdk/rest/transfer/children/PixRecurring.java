package io.github.jpdev.asaassdk.rest.transfer.children;

public class PixRecurring {

    PixRecurringFrequency frequency;
    int quantity;

    public static PixRecurringFetcher fetcher(String id) {
        return new PixRecurringFetcher(id);
    }

    public PixRecurringFrequency getFrequency() {
        return frequency;
    }

    public PixRecurring setFrequency(PixRecurringFrequency frequency) {
        this.frequency = frequency;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public PixRecurring setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
