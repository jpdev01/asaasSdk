package io.github.jpdev.asaassdk.rest.accounts;

public class Account {

    public String object;
    public String id;
    public String name;
    public String tradingName;
    public String email;
    public String loginEmail;
    public String phone;
    public String mobilePhone;
    public String address;
    public String addressNumber;
    public String complement;
    public String province;
    public String postalCode;
    public String cpfCnpj;
    public Object birthDate;
    public String personType;
    public String companyType;
    public int city;
    public String state;
    public String country;
    public String site;
    public String apiKey;
    public String walletId;
    public AccountNumber accountNumber;

    public static AccountCreator creator() {
        return new AccountCreator();
    }

    public static AccountFetcher fetcher(String id) {
        return new AccountFetcher(id);
    }

    public static AccountReader reader() {
        return new AccountReader();
    }

    public String getObject() {
        return object;
    }

    public Account setObject(String object) {
        this.object = object;
        return this;
    }

    public String getId() {
        return id;
    }

    public Account setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getTradingName() {
        return tradingName;
    }

    public Account setTradingName(String tradingName) {
        this.tradingName = tradingName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public Account setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Account setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Account setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Account setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public Account setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public Account setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Account setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Account setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public Account setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public Account setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getPersonType() {
        return personType;
    }

    public Account setPersonType(String personType) {
        this.personType = personType;
        return this;
    }

    public String getCompanyType() {
        return companyType;
    }

    public Account setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }

    public int getCity() {
        return city;
    }

    public Account setCity(int city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Account setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Account setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getSite() {
        return site;
    }

    public Account setSite(String site) {
        this.site = site;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Account setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getWalletId() {
        return walletId;
    }

    public Account setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public Account setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }
}
