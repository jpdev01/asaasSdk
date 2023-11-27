package br.com.jpdev01.asaassdk.rest.myaccount.status;

import br.com.jpdev01.asaassdk.rest.myaccount.commercialinfo.CommercialInfoStatus;

public class MyAccountStatus {

    String id;
    CommercialInfoStatus commercialInfo;
    DocumentationStatus documentation;
    GeneralStatus general;

    public static MyAccountStatusFetcher fetcher() {
        return new MyAccountStatusFetcher();
    }

    public String getId() {
        return id;
    }

    public MyAccountStatus setId(String id) {
        this.id = id;
        return this;
    }

    public CommercialInfoStatus getCommercialInfo() {
        return commercialInfo;
    }

    public MyAccountStatus setCommercialInfo(CommercialInfoStatus commercialInfo) {
        this.commercialInfo = commercialInfo;
        return this;
    }

    public DocumentationStatus getDocumentation() {
        return documentation;
    }

    public MyAccountStatus setDocumentation(DocumentationStatus documentation) {
        this.documentation = documentation;
        return this;
    }

    public GeneralStatus getGeneral() {
        return general;
    }

    public MyAccountStatus setGeneral(GeneralStatus general) {
        this.general = general;
        return this;
    }
}
