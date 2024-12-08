package io.github.jpdev.asaassdk.rest.accounts;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AccountCreator extends Creator<Account> {

    String name;
    String email;
    String loginEmail;
    String cpfCnpj;
    Date birthDate;
    String companyType;
    String phone;
    String mobilePhone;
    String site;
    String address;
    String addressNumber;
    String complement;
    String province;
    String postalCode;
    BigDecimal incomeValue;
    List<Webhook> webhooks;

    public String getName() {
        return name;
    }

    public AccountCreator setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AccountCreator setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public AccountCreator setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public AccountCreator setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public AccountCreator setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCompanyType() {
        return companyType;
    }

    public AccountCreator setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AccountCreator setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public AccountCreator setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getSite() {
        return site;
    }

    public AccountCreator setSite(String site) {
        this.site = site;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AccountCreator setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public AccountCreator setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public AccountCreator setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public AccountCreator setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AccountCreator setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public List<Webhook> getWebhooks() {
        return webhooks;
    }

    public AccountCreator setWebhooks(List<Webhook> webhooks) {
        this.webhooks = webhooks;
        return this;
    }

    public AccountCreator setIncomeValue(BigDecimal incomeValue) {
        this.incomeValue = incomeValue;
        return this;
    }

    public BigDecimal getIncomeValue() {
        return incomeValue;
    }

    @Override
    public String getResourceUrl() {
        return Domain.ACCOUNT.toString();
    }

    @Override
    public Class<Account> getResourceClass() {
        return Account.class;
    }
}
