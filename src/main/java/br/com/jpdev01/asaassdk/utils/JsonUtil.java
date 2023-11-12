package br.com.jpdev01.asaassdk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonUtil {

    private static ObjectMapper objectMapper = null;

    public static Object parse(String json, Class<?> clazz) {
        return parse(json, clazz, false);
    }

    public static Object parse(String json, Class<?> clazz, Boolean showLog) {
        return parse(json, clazz, showLog, false);
    }

    public static Object parse(String json, Class<?> clazz, Boolean showLog, Boolean verificaDataBR) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            if (showLog) {
                System.out.println("Error parsing with Jackson\n" + json);
                e.printStackTrace();
            }
            return null;
        }
    }

    public static String toJSON(Object obj) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
