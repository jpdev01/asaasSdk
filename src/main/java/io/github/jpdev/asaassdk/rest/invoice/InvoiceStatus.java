package io.github.jpdev.asaassdk.rest.invoice;

public enum InvoiceStatus {
    SCHEDULED,
    WAITING_OVERDUE_PAYMENT,
    PENDING,
    SYNCHRONIZED,
    AUTHORIZED,
    PROCESSING_CANCELLATION,
    CANCELLED,
    CANCELLATION_DENIED,
    ERROR
}
