package io.github.jpdev.asaassdk.rest.customeraccount;

import io.github.jpdev.asaassdk.http.Domain;
import io.github.jpdev.asaassdk.rest.action.Creator;

public class CustomerAccountCreator extends Creator<CustomerAccount> {

    String name;
    String cpfCnpj;
    String email;
    String phone;
    String mobilePhone;
    String address;
    String addressNumber;
    String complement;
    Boolean notificationDisabled;
    String observations;
    String company;

    public String getName() {
        return name;
    }

    public CustomerAccountCreator setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public CustomerAccountCreator setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerAccountCreator setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerAccountCreator setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public CustomerAccountCreator setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerAccountCreator setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public CustomerAccountCreator setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public CustomerAccountCreator setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public Boolean getNotificationDisabled() {
        return notificationDisabled;
    }

    public CustomerAccountCreator setNotificationDisabled(Boolean notificationDisabled) {
        this.notificationDisabled = notificationDisabled;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public CustomerAccountCreator setObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public CustomerAccountCreator setCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.CUSTOMER_ACCOUNT.toString();
    }

    @Override
    public Class<CustomerAccount> getResourceClass() {
        return CustomerAccount.class;
    }
}
