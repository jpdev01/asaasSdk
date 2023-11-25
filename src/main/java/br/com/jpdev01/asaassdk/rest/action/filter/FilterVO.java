package br.com.jpdev01.asaassdk.rest.action.filter;

public class FilterVO {

    public String propertyName;
    public String filterKey;

    public FilterVO(String propertyName, String filterKey) {
        this.propertyName = propertyName;
        this.filterKey = filterKey;
    }

    public FilterVO(String propertyName) {
        this.propertyName = propertyName;
        this.filterKey = this.propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getFilterKey() {
        return filterKey;
    }
}
