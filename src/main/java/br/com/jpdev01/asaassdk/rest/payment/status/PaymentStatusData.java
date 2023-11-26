package br.com.jpdev01.asaassdk.rest.payment.status;

import br.com.jpdev01.asaassdk.rest.payment.enums.PaymentStatus;

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
