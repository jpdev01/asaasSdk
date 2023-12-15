package io.github.jpdev.asaassdk.rest.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletedResource {

    public boolean deleted;
    public String id;

    public boolean isDeleted() {
        return deleted;
    }

    public DeletedResource setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getId() {
        return id;
    }

    public DeletedResource setId(String id) {
        this.id = id;
        return this;
    }
}
