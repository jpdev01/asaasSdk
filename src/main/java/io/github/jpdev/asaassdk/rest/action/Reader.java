package io.github.jpdev.asaassdk.rest.action;

import io.github.jpdev.asaassdk.http.Asaas;
import io.github.jpdev.asaassdk.http.AsaasRestClient;
import io.github.jpdev.asaassdk.http.Response;
import io.github.jpdev.asaassdk.rest.action.filter.FilterVO;
import io.github.jpdev.asaassdk.utils.CustomDateUtils;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class Reader<T> {

    public int limit = 10;
    public long offset = 0;

    private static final int LIMIT_MIN_VALUE = 1;
    private static final int LIMIT_MAX_VALUE = 100;

    public List<FilterVO> activeFilters;

    public Integer getLimit() {
        return limit;
    }

    public Reader<T> setLimit(Integer limit) {
        if (limit > LIMIT_MAX_VALUE) throw new IllegalArgumentException("Limit cannot be greater than " + LIMIT_MAX_VALUE);
        if (limit < LIMIT_MIN_VALUE) throw new IllegalArgumentException("Limit cannot be less than " + LIMIT_MIN_VALUE);

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
        activeFilters.add(new FilterVO(
                propertyName
        ));
    }

    public void addFilter(String propertyName, String filterName) {
        if (activeFilters == null) activeFilters = new ArrayList<>();
        activeFilters.add(new FilterVO(
                propertyName,
                filterName
        ));
    }

    public Reader<T> nextPage() {
        offset += limit;
        return this;
    }

    private String buildFullPath() {
        String path = getResourceUrl();
        path = path.concat(fillPagination());

        String filters = applyFilters();
        if (filters != null) path = path.concat(filters);

        return path;
    }

    private String concatDelimiterFilter(String currentFilter) {
        if (currentFilter.isEmpty()) return currentFilter.concat("?");
        return currentFilter.concat("&");
    }

    private String fillPagination() {
        String pathParams = "";
        pathParams = concatDelimiterFilter(pathParams)
                .concat("limit=")
                .concat(String.valueOf(limit));

        pathParams = concatDelimiterFilter(pathParams)
                .concat("offset=")
                .concat(String.valueOf(offset));

        return pathParams;
    }

    private String applyFilters() {
        if (activeFilters == null || activeFilters.isEmpty()) return null;

        try {
            StringBuilder pathParams = new StringBuilder();

            for (FilterVO filterVO : activeFilters) {
                pathParams.append("&");
                Field field = this.getClass().getDeclaredField(filterVO.getPropertyName());

                pathParams = new StringBuilder(pathParams.toString()
                        .concat(parseFilterKey(filterVO))
                        .concat("="));

                Object value = field.get(this);
                pathParams = new StringBuilder(pathParams.toString().concat(parseFilterValue(value)));
            }

            return pathParams.toString();
        } catch (
                NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
                unexpectedException
        ) {
            throw new IllegalStateException("Erro ao parsear filtros.");
        }
    }

    private String parseFilterKey(FilterVO filterVO) {
        return URLEncoder.encode(filterVO.getFilterKey());
    }

    private String parseFilterValue(Object value) {
        if (value instanceof String || value instanceof Enum || value instanceof Integer) {
            return value.toString();
        } else if (value instanceof Date) {
            return CustomDateUtils.toString((Date) value, CustomDateUtils.DATE);
        }

        throw new IllegalStateException("Filtro não mapeado");
    }
}
