package io.github.jpdev.asaassdk.rest.payment;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Reader;
import io.github.jpdev.asaassdk.utils.BillingType;
import io.github.jpdev.asaassdk.rest.payment.enums.PaymentStatus;

import java.util.Date;

public class PaymentReader extends Reader<Payment> {

    public BillingType billingType;
    public String installment;
    public String customer;
    public PaymentStatus status;
    public Date startDueDate;
    public Date finishDueDate;
    public Date startPaymentDate;
    public Date finishPaymentDate;

    public PaymentReader setBillingType(BillingType billingType) {
        addFilter("billingType");
        this.billingType = billingType;
        return this;
    }


    public PaymentReader setInstallment(String installment) {
        addFilter("installment");
        this.installment = installment;
        return this;
    }
    public PaymentReader setCustomer(String customer) {
        addFilter("customer");
        this.customer = customer;
        return this;
    }

    public PaymentReader setStatus(PaymentStatus status) {
        addFilter("status");
        this.status = status;
        return this;
    }

    public PaymentReader setStartDueDate(Date startDueDate) {
        addFilter("startDueDate", "dueDate[ge]");
        this.startDueDate = startDueDate;
        return this;
    }

    public PaymentReader setFinishDueDate(Date finishDueDate) {
        addFilter("finishDueDate", "dueDate[le]");
        this.finishDueDate = finishDueDate;
        return this;
    }

    public PaymentReader setStartPaymentDate(Date startPaymentDate) {
        addFilter("startPaymentDate", "paymentDate[ge]");
        this.startPaymentDate = startPaymentDate;
        return this;
    }

    public PaymentReader setFinishPaymentDate(Date finishPaymentDate) {
        addFilter("finishPaymentDate", "paymentDate[le]");
        this.finishPaymentDate = finishPaymentDate;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.PAYMENT.toString();
    }

    @Override
    public Class<Payment> getResourceClass() {
        return Payment.class;
    }
}
