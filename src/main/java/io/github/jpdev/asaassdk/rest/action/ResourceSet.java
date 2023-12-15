package io.github.jpdev.asaassdk.rest.action;

import io.github.jpdev.asaassdk.http.AsaasRestClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class ResourceSet<T> {

    String object;
    boolean hasMore;
    Integer totalCount;
    Integer limit;
    Integer offset;
    List<T> data;

    public static <T> ResourceSet<T> fromJson(String recordKey, String json, Class<T> recordType, ObjectMapper mapper) {
        try {
            List<T> results = new ArrayList<>();
            JsonNode root = mapper.readTree(json);
            JsonNode records = root.get(recordKey);
            for (final JsonNode record : records) {
                results.add(mapper.readValue(record.toString(), recordType));
            }

            ResourceSet<T> set = new ResourceSet<>();
            set.data = results;
            set.hasMore = root.get("hasMore").asBoolean();
            set.object = root.get("object") != null ? root.get("object").asText() : null;
            set.totalCount = root.get("totalCount").asInt();
            set.limit = root.get("limit").asInt();
            set.offset = root.get("offset").asInt();
            return set;
        } catch (final IOException e) {
            throw new RuntimeException(
                    "Unable to deserialize response: " + e.getMessage() + "\nJSON: " + json, e
            );
        }
    }

    public String getObject() {
        return object;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public List<T> getData() {
        return data;
    }
}
