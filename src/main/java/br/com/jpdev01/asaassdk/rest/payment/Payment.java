package br.com.jpdev01.asaassdk.rest.payment;

import br.com.jpdev01.asaassdk.rest.payment.children.Discount;
import br.com.jpdev01.asaassdk.rest.payment.children.Fine;
import br.com.jpdev01.asaassdk.rest.payment.children.Interest;
import br.com.jpdev01.asaassdk.rest.payment.identificationfield.PaymentIdentificationField;
import br.com.jpdev01.asaassdk.rest.payment.identificationfield.PaymentIdentificationFieldFetcher;
import br.com.jpdev01.asaassdk.rest.payment.status.PaymentStatusFetcher;
import br.com.jpdev01.asaassdk.utils.BillingType;
import br.com.jpdev01.asaassdk.utils.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

    @JsonProperty("object")
    private String object;
    private String id;
    private String dateCreated;
    private String customer;
    private String paymentLink;
    private BigDecimal value;
    private BigDecimal netValue;
    private BigDecimal originalValue;
    private BigDecimal interestValue;
    private String description;
    private BillingType billingType;
    private String pixTransaction;
    private PaymentStatus status;
    private Date dueDate;
    private Date originalDueDate;
    private Date paymentDate;
    private Date clientPaymentDate;
    private String installment;
    private String installmentNumber;
    private String invoiceUrl;
    private String invoiceNumber;
    private String externalReference;
    private boolean deleted;
    private boolean anticipated;
    private boolean anticipable;
    private String creditDate;
    private String estimatedCreditDate;
    private String transactionReceiptUrl;
    private String nossoNumero;
    private String bankSlipUrl;
    private String lastInvoiceViewedDate;
    private String lastBankSlipViewedDate;
    private Discount discount;
    private Fine fine;
    private Interest interest;
    private boolean postalService;
    private Object custody;  // You may need to define a specific type for this property
    private Object refunds;  // You may need to define a specific type for this property

    public static PaymentCreator creator() {
        return new PaymentCreator();
    }

    public static PaymentRefunder refunder(Long id) {
        return new PaymentRefunder(id);
    }

    public static PaymentStatusFetcher statusFetcher(String id) {
        return new PaymentStatusFetcher(id);
    }

    public static PaymentIdentificationFieldFetcher identificationFieldFetcher(String id) {
        return new PaymentIdentificationFieldFetcher(id);
    }

    public String getObject() {
        return object;
    }

    public Payment setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public Payment setId(String id) {
        this.id = id;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public Payment setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Payment setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public Payment setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Payment setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public Payment setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
        return this;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public Payment setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
        return this;
    }

    public BigDecimal getInterestValue() {
        return interestValue;
    }

    public Payment setInterestValue(BigDecimal interestValue) {
        this.interestValue = interestValue;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Payment setDescription(String description) {
        this.description = description;
        return this;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public Payment setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public String getPixTransaction() {
        return pixTransaction;
    }

    public Payment setPixTransaction(String pixTransaction) {
        this.pixTransaction = pixTransaction;
        return this;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Payment setStatus(PaymentStatus status) {
        this.status = status;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Payment setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getOriginalDueDate() {
        return originalDueDate;
    }

    public Payment setOriginalDueDate(Date originalDueDate) {
        this.originalDueDate = originalDueDate;
        return this;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Payment setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public Date getClientPaymentDate() {
        return clientPaymentDate;
    }

    public Payment setClientPaymentDate(Date clientPaymentDate) {
        this.clientPaymentDate = clientPaymentDate;
        return this;
    }

    public String getInstallmentNumber() {
        return installmentNumber;
    }

    public Payment setInstallmentNumber(String installmentNumber) {
        this.installmentNumber = installmentNumber;
        return this;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public Payment setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
        return this;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Payment setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public Payment setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Payment setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public boolean isAnticipated() {
        return anticipated;
    }

    public Payment setAnticipated(boolean anticipated) {
        this.anticipated = anticipated;
        return this;
    }

    public boolean isAnticipable() {
        return anticipable;
    }

    public Payment setAnticipable(boolean anticipable) {
        this.anticipable = anticipable;
        return this;
    }

    public String getCreditDate() {
        return creditDate;
    }

    public Payment setCreditDate(String creditDate) {
        this.creditDate = creditDate;
        return this;
    }

    public String getEstimatedCreditDate() {
        return estimatedCreditDate;
    }

    public Payment setEstimatedCreditDate(String estimatedCreditDate) {
        this.estimatedCreditDate = estimatedCreditDate;
        return this;
    }

    public String getTransactionReceiptUrl() {
        return transactionReceiptUrl;
    }

    public Payment setTransactionReceiptUrl(String transactionReceiptUrl) {
        this.transactionReceiptUrl = transactionReceiptUrl;
        return this;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public Payment setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
        return this;
    }

    public String getBankSlipUrl() {
        return bankSlipUrl;
    }

    public Payment setBankSlipUrl(String bankSlipUrl) {
        this.bankSlipUrl = bankSlipUrl;
        return this;
    }

    public String getLastInvoiceViewedDate() {
        return lastInvoiceViewedDate;
    }

    public Payment setLastInvoiceViewedDate(String lastInvoiceViewedDate) {
        this.lastInvoiceViewedDate = lastInvoiceViewedDate;
        return this;
    }

    public String getLastBankSlipViewedDate() {
        return lastBankSlipViewedDate;
    }

    public Payment setLastBankSlipViewedDate(String lastBankSlipViewedDate) {
        this.lastBankSlipViewedDate = lastBankSlipViewedDate;
        return this;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Payment setDiscount(Discount discount) {
        this.discount = discount;
        return this;
    }

    public Fine getFine() {
        return fine;
    }

    public Payment setFine(Fine fine) {
        this.fine = fine;
        return this;
    }

    public Interest getInterest() {
        return interest;
    }

    public Payment setInterest(Interest interest) {
        this.interest = interest;
        return this;
    }

    public boolean isPostalService() {
        return postalService;
    }

    public Payment setPostalService(boolean postalService) {
        this.postalService = postalService;
        return this;
    }

    public Object getCustody() {
        return custody;
    }

    public Payment setCustody(Object custody) {
        this.custody = custody;
        return this;
    }

    public Object getRefunds() {
        return refunds;
    }

    public Payment setRefunds(Object refunds) {
        this.refunds = refunds;
        return this;
    }

    public String getInstallment() {
        return installment;
    }

    public Payment setInstallment(String installment) {
        this.installment = installment;
        return this;
    }
}
