package io.github.jpdev.asaassdk.webhook.payment;

import io.github.jpdev.asaassdk.rest.payment.enums.PaymentStatus;
import io.github.jpdev.asaassdk.utils.BillingType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Payment {

    public String object;
    public String id;
    public Date dateCreated;
    public String customer;
    public String subscription;
    public String installment;
    public String paymentLink;
    public String dueDate;
    public String originalDueDate;
    public BigDecimal value;
    public BigDecimal netValue;
    public BigDecimal originalValue;
    public BigDecimal interestValue;
    public Object nossoNumero;
    public String description;
    public String externalReference;
    public BillingType billingType;
    public PaymentStatus status;
    public Object pixTransaction;
    public String confirmedDate;
    public String paymentDate;
    public String clientPaymentDate;
    public Object installmentNumber;
    public String creditDate;
    public Object custody;
    public String estimatedCreditDate;
    public String invoiceUrl;
    public Object bankSlipUrl;
    public String transactionReceiptUrl;
    public String invoiceNumber;
    public boolean deleted;
    public boolean anticipated;
    public boolean anticipable;
    public String lastInvoiceViewedDate;
    public Object lastBankSlipViewedDate;
    public boolean postalService;
    public CreditCard creditCard;
    public Discount discount;
    public Fine fine;
    public Interest interest;
    public ArrayList<Split> split;
    public Chargeback chargeback;
    public Object refunds;
}
