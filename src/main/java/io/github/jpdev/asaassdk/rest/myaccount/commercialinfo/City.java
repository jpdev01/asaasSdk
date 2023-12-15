package io.github.jpdev.asaassdk.rest.myaccount.commercialinfo;

public class City {

    public String object;
    public int id;
    public String ibgeCode;
    public String name;
    public String districtCode;
    public String district;
    public String state;

    public String getObject() {
        return object;
    }

    public City setObject(String object) {
        this.object = object;
        return this;
    }

    public int getId() {
        return id;
    }

    public City setId(int id) {
        this.id = id;
        return this;
    }

    public String getIbgeCode() {
        return ibgeCode;
    }

    public City setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public City setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public City setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getState() {
        return state;
    }

    public City setState(String state) {
        this.state = state;
        return this;
    }
}
