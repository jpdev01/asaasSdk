package io.github.jpdev.asaassdk.rest.transfer.children.response;

public class Bank {

    public String code;
    public String name;
    public String ispb;

    public String getCode() {
        return code;
    }

    public Bank setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bank setName(String name) {
        this.name = name;
        return this;
    }

    public String getIspb() {
        return ispb;
    }

    public Bank setIspb(String ispb) {
        this.ispb = ispb;
        return this;
    }
}
