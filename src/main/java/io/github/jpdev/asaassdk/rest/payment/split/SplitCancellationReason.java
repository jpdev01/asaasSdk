package io.github.jpdev.asaassdk.rest.payment.split;

public enum SplitCancellationReason {

    PAYMENT_DELETED,
    PAYMENT_OVERDUE,
    PAYMENT_RECEIVED_IN_CASH,
    PAYMENT_REFUNDED,
    VALUE_DIVERGENCE_BLOCK,
    WALLET_UNABLE_TO_RECEIVE
}
