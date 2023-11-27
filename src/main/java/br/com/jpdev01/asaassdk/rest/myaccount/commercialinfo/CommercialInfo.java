package br.com.jpdev01.asaassdk.rest.myaccount.commercialinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommercialInfo {

    public CommercialInfoStatus status;
    public String personType;
    public String cpfCnpj;
    public String name;
    public Object birthDate;
    public String companyName;
    public String companyType;
    public String email;
    public String phone;
    public String mobilePhone;
    public String postalCode;
    public String address;
    public String addressNumber;
    public String complement;
    public String province;
    public City city;
    public Object denialReason;

    public static CommercialInfoFetcher fetcher() {
        return new CommercialInfoFetcher();
    }

    public static CommercialInfoUpdater updater() {
        return new CommercialInfoUpdater();
    }

    public CommercialInfoStatus getStatus() {
        return status;
    }

    public CommercialInfo setStatus(CommercialInfoStatus status) {
        this.status = status;
        return this;
    }

    public String getPersonType() {
        return personType;
    }

    public CommercialInfo setPersonType(String personType) {
        this.personType = personType;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public CommercialInfo setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getName() {
        return name;
    }

    public CommercialInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public CommercialInfo setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CommercialInfo setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyType() {
        return companyType;
    }

    public CommercialInfo setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CommercialInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CommercialInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public CommercialInfo setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public CommercialInfo setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CommercialInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public CommercialInfo setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public CommercialInfo setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public CommercialInfo setProvince(String province) {
        this.province = province;
        return this;
    }

    public City getCity() {
        return city;
    }

    public CommercialInfo setCity(City city) {
        this.city = city;
        return this;
    }

    public Object getDenialReason() {
        return denialReason;
    }

    public CommercialInfo setDenialReason(Object denialReason) {
        this.denialReason = denialReason;
        return this;
    }
}
