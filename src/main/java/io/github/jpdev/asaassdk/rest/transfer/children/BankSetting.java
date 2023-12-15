package io.github.jpdev.asaassdk.rest.transfer.children;

public class BankSetting {

    private String code;

    public BankSetting setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return code;
    }
}
