package br.com.stant.libraries.uilibrary.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by root on 06/10/16.
 */
public class DateUtils {

    public static final String ISO_8601_FORMAT     = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String BRAZILIAN_FORMAT    = "dd/MM/yyyy";
    public static final String BRAZILIAN_FORMAT_YY = "dd/MM/yy";

    public static Date stringToDate(String dateFormat, String date){
        dateFormat = dateFormat != null ? dateFormat : BRAZILIAN_FORMAT;
        try {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String setActualDate() {
        Calendar calendar  = Calendar.getInstance();
        return dateToStringWithFormat(calendar.getTime(), BRAZILIAN_FORMAT);
    }

    public static String dateToString(Date date) {
        if(date == null)
            return "";
        return dateToStringWithFormat(date, BRAZILIAN_FORMAT_YY);
    }

    public static String dateToStringWithBrazilianFormat(Date date) {
        if(date == null)
            return "";
        return dateToStringWithFormat(date, BRAZILIAN_FORMAT);
    }

    private static String dateToStringWithFormat(Date date, String dateFormat) {
        if(date == null)
            return "";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static String getISO8601StringForDate(Date date) {
        if(date == null)
            return "";
        DateFormat dateFormat = new SimpleDateFormat(ISO_8601_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTF-8"));
        return dateFormat.format(date);
    }

    public static Date stringToDate(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat(BRAZILIAN_FORMAT_YY);

        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date stringToDateWithFormat(String dateStr, String dateFormat){
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);

        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatBrDate(Date date) {
        if(date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(BRAZILIAN_FORMAT);
        return dateFormat.format(date);
    }

    public static String getDayFromDate(Date date){
        if(date == null)
            return "";
        else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Integer day = cal.get(Calendar.DAY_OF_MONTH);

            return day.toString();
        }
    }

    public static String getDateMonth(Date date){
        if(date == null)
            return "";
        else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String month = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
            return month.toUpperCase();
        }
    }

    public static String getStrftimeFormatToQueryCompare(String fieldName, boolean fieldIsUnixepochDateFormat){
        int multiplierValueToDateFormatter = 1000;
        String unixepochFormatter = "";

        if(fieldIsUnixepochDateFormat)
            unixepochFormatter = " / "+multiplierValueToDateFormatter+", 'unixepoch'";

        return "strftime('%YYYY/%m/%d', "+fieldName+" "+unixepochFormatter+")";
    }

    public static Date longToDate(String longDate) {
        if(longDate == null || longDate.equals("")) return null;
        return new java.sql.Date(Long.parseLong(longDate));
    }
}
