package br.com.jpdev01.asaassdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateUtils {

    public static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");

    public static String toString(Date date, SimpleDateFormat format) {
        try {
            return format.format(date);
        } catch (Exception exception) {
            return null;
        }
    }
}
