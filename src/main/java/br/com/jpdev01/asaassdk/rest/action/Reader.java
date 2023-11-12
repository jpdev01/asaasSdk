package br.com.jpdev01.asaassdk.rest.action;

import br.com.jpdev01.asaassdk.http.Asaas;
import br.com.jpdev01.asaassdk.http.AsaasRestClient;
import br.com.jpdev01.asaassdk.http.Response;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Reader<T> {

    public Integer limit;
    public Long offset;

    public Integer getLimit() {
        return limit;
    }

    public Reader<T> setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Long getOffset() {
        return offset;
    }

    public Reader<T> setOffset(Long offset) {
        this.offset = offset;
        return this;
    }

    public List<String> activeFilters;

    public ResourceSet<T> read() {
        return read(Asaas.getRestClient());
    }

    public ResourceSet<T> read(final AsaasRestClient client) {
        Response response = client.get(buildFullPath());
        return ResourceSet.fromJson(
                "data",
                response.getContent(),
                getResourceClass(),
                client.getObjectMapper()
        );
    }

    public abstract String getResourceUrl();
    public abstract Class<T> getResourceClass();

    public void addFilter(String propertyName) {
        if (activeFilters == null) activeFilters = new ArrayList<>();
        activeFilters.add(propertyName);
    }

    private String buildFullPath() {
        try {
            String path = getResourceUrl();
            if (activeFilters.isEmpty()) return path;

            String pathParams = "";
            for (String propertyName : activeFilters) {
                pathParams = concatDelimiterFilter(pathParams);
                Field field = this.getClass().getDeclaredField(propertyName);
                pathParams = pathParams
                        .concat(field.getName())
                        .concat("=");

                Object value = field.get(this);
                if (value instanceof String || value instanceof Enum) {
                    pathParams = pathParams
                            .concat(value.toString());
                } else if (value instanceof Integer) {
                    pathParams = pathParams
                            .concat(value.toString());
                } else {
                    throw new IllegalStateException("Filtro não mapeado");
                }
            }

            if (limit != null) {
                pathParams = concatDelimiterFilter(pathParams)
                        .concat("limit=")
                        .concat(limit.toString());
            }

            if (offset != null) {
                pathParams = concatDelimiterFilter(pathParams)
                        .concat("offset=")
                        .concat(offset.toString());
            }

            return path.concat(pathParams);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException |
                 IllegalAccessException unexpectedException) {
            throw new IllegalStateException("Erro ao parsear filtros.");
        }
    }

    private String concatDelimiterFilter(String currentFilter) {
        if (currentFilter.isEmpty()) return currentFilter.concat("?");
        return currentFilter.concat("&");
    }
}
