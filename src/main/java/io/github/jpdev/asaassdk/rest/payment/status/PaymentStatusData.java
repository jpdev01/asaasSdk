package io.github.jpdev.asaassdk.rest.payment.status;

import io.github.jpdev.asaassdk.rest.payment.enums.PaymentStatus;

public class PaymentStatusData {

    PaymentStatus status;

    public PaymentStatusData() {}
    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentStatusData setStatus(PaymentStatus status) {
        this.status = status;
        return this;
    }
}
