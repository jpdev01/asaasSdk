package br.com.jpdev01.asaassdk.http;

public enum Domain {

    TRANSFER("transfers"),
    PAYMENT("payments");

    private final String value;

    private Domain(final String value) {
        this.value = value;
    }

    public String addPathVariable(String value) {
        return this.toString() + "/" + value;
    }

    public String toString() {
        return value;
    }
}
