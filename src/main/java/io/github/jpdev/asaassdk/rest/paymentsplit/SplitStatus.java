package io.github.jpdev.asaassdk.rest.paymentsplit;

public enum SplitStatus {

    PENDING,
    AWAITING_CREDIT,
    CANCELLED,
    DONE,
    REFUNDED,
    BLOCKED_BY_VALUE_DIVERGENCE
}
