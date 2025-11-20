package com.mamajulit.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationUtil {

    public static boolean isNotEmpty(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean isInteger(String s) {
        if (!isNotEmpty(s)) return false;
        try {
            Integer.parseInt(s.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String s) {
        if (!isNotEmpty(s)) return false;
        try {
            Float.parseFloat(s.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidDate(String s) {
        if (!isNotEmpty(s)) return false;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            Date d = df.parse(s.trim());
            return d != null;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidTime(String s) {
        if (!isNotEmpty(s)) return false;
        try {
            SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
            tf.setLenient(false);
            Date d = tf.parse(s.trim());
            return d != null;
        } catch (ParseException e) {
            return false;
        }
    }
}
