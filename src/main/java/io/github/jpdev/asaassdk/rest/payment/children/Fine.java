package io.github.jpdev.asaassdk.rest.payment.children;


import io.github.jpdev.asaassdk.utils.FineTypeValue;

import java.math.BigDecimal;

/**
 * Informações de multa para pagamento após o vencimento
 *
 * @author jpdev01
 */
public class Fine {

    private BigDecimal value;
    private FineTypeValue type;

    public Fine() {
    }

    public Fine(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @param value Percentual de multa sobre o valor da cobrança para pagamento
     * após o vencimento
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public FineTypeValue getType() {
        return type;
    }

    public Fine setType(FineTypeValue type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Fine{" + "value=" + value + '}';
    }

}
