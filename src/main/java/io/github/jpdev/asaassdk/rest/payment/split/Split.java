package io.github.jpdev.asaassdk.rest.payment.split;

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

    public String getId() {
        return id;
    }
}
