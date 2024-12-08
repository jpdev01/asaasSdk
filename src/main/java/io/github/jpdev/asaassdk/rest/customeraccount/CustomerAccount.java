package io.github.jpdev.asaassdk.rest.customeraccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAccount {

    public String object;
    public String id;
    public Date dateCreated;
    public String name;
    public String email;
    public String phone;
    public String mobilePhone;
    public String address;
    public String addressNumber;
    public String complement;
    public String company;
    public String municipalInscription;

    public String stateInscription;
    public String province;
    public String postalCode;
    public String cpfCnpj;
    public String personType;
    public boolean deleted;
    public String additionalEmails;
    public String externalReference;
    public boolean notificationDisabled;
    public Long city;
    public String state;
    public String country;
    public String observations;

    public static CustomerAccountCreator creator() {
        return new CustomerAccountCreator();
    }

    public static CustomerAccountFetcher fetcher(String id) {
        return new CustomerAccountFetcher(id);
    }

    public static CustomerAccountReader reader() {
        return new CustomerAccountReader();
    }

    public String getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getPersonType() {
        return personType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getAdditionalEmails() {
        return additionalEmails;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public boolean isNotificationDisabled() {
        return notificationDisabled;
    }

    public Long getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getObservations() {
        return observations;
    }
}
