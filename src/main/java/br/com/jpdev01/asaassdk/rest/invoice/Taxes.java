package br.com.jpdev01.asaassdk.rest.invoice;

import java.math.BigDecimal;

public class Taxes {

    Boolean retainIss;
    Boolean iss;
    BigDecimal cofins;
    BigDecimal csll;
    BigDecimal inss;
    BigDecimal ir;
    BigDecimal pis;

    public Boolean getRetainIss() {
        return retainIss;
    }

    public Taxes setRetainIss(Boolean retainIss) {
        this.retainIss = retainIss;
        return this;
    }

    public Boolean getIss() {
        return iss;
    }

    public Taxes setIss(Boolean iss) {
        this.iss = iss;
        return this;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public Taxes setCofins(BigDecimal cofins) {
        this.cofins = cofins;
        return this;
    }

    public BigDecimal getCsll() {
        return csll;
    }

    public Taxes setCsll(BigDecimal csll) {
        this.csll = csll;
        return this;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public Taxes setInss(BigDecimal inss) {
        this.inss = inss;
        return this;
    }

    public BigDecimal getIr() {
        return ir;
    }

    public Taxes setIr(BigDecimal ir) {
        this.ir = ir;
        return this;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public Taxes setPis(BigDecimal pis) {
        this.pis = pis;
        return this;
    }
}
