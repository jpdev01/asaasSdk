package io.github.jpdev.asaassdk.rest.paymentsplit;

import java.math.BigDecimal;

public class Split {

    String id;
    String walletId;
    BigDecimal fixedValue;
    BigDecimal percentualValue;
    BigDecimal totalValue;
    SplitCancellationReason cancellationReason;
    SplitStatus status;
    String externalReference;
    String description;

    public static PaymentSplitPaidReader paidReader() {
        return new PaymentSplitPaidReader();
    }

    public static PaymentSplitReceivedReader receivedReader() {
        return new PaymentSplitReceivedReader();
    }

    public static PaymentSplitPaidFetcher paidFetcher(String id) {
        return new PaymentSplitPaidFetcher(id);
    }

    public static PaymentSplitReceivedFetcher receivedFetcher(String id) {
        return new PaymentSplitReceivedFetcher(id);
    }

    public String getId() {
        return id;
    }

    public String getWalletId() {
        return walletId;
    }

    public BigDecimal getFixedValue() {
        return fixedValue;
    }

    public BigDecimal getPercentualValue() {
        return percentualValue;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public SplitCancellationReason getCancellationReason() {
        return cancellationReason;
    }

    public SplitStatus getStatus() {
        return status;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public String getDescription() {
        return description;
    }
}
