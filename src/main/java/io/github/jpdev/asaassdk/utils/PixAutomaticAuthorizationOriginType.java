package io.github.jpdev.asaassdk.utils;

public enum PixAutomaticAuthorizationOriginType {

    IMMEDIATE_PAYMENT_AND_RECURRING_QR_CODE(3),
    PAYMENT_AND_RECURRING_OFFER_QR_CODE(4);

    private final int journey;

    private PixAutomaticAuthorizationOriginType(int journey) {
        this.journey = journey;
    }

    public int getJourney() {
        return this.journey;
    }
}
