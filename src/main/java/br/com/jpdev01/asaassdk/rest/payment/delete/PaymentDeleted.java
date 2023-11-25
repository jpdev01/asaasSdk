package br.com.jpdev01.asaassdk.rest.payment.delete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDeleted {

    public boolean deleted;
    public String id;

    public boolean isDeleted() {
        return deleted;
    }

    public PaymentDeleted setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getId() {
        return id;
    }

    public PaymentDeleted setId(String id) {
        this.id = id;
        return this;
    }
}
