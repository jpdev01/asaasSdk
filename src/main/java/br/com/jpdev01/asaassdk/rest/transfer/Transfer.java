package br.com.jpdev01.asaassdk.rest.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Transfer {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static TransferCreator creator() {
        return new TransferCreator();
    }
}
