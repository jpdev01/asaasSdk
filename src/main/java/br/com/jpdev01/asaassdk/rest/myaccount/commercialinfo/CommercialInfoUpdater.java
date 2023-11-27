package br.com.jpdev01.asaassdk.rest.myaccount.commercialinfo;

import br.com.jpdev01.asaassdk.http.Domain;
import br.com.jpdev01.asaassdk.rest.action.Updater;
import br.com.jpdev01.asaassdk.utils.PersonType;

import java.util.Date;

public class CommercialInfoUpdater extends Updater<CommercialInfo> {

    PersonType personType;
    String cpfCnpj;
    Date birthDate;
    String companyType;
    String email;
    String phone;
    String mobilePhone;
    String site;
    String postalCode;
    String address;
    String addressNumber;
    String complement;
    String province;

    public PersonType getPersonType() {
        return personType;
    }

    public CommercialInfoUpdater setPersonType(PersonType personType) {
        this.personType = personType;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public CommercialInfoUpdater setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public CommercialInfoUpdater setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCompanyType() {
        return companyType;
    }

    public CommercialInfoUpdater setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CommercialInfoUpdater setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CommercialInfoUpdater setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public CommercialInfoUpdater setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getSite() {
        return site;
    }

    public CommercialInfoUpdater setSite(String site) {
        this.site = site;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public CommercialInfoUpdater setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CommercialInfoUpdater setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public CommercialInfoUpdater setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public CommercialInfoUpdater setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public CommercialInfoUpdater setProvince(String province) {
        this.province = province;
        return this;
    }

    @Override
    public String getResourceUrl() {
        return Domain.COMMERCIAL_INFO.toString();
    }

    @Override
    public Class<CommercialInfo> getResourceClass() {
        return CommercialInfo.class;
    }
}
