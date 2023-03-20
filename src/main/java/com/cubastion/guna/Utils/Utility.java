package com.cubastion.guna.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cubastion.guna.Utils.KEY.DATE_FORMAT;


public class Utility {


    public static Date parseDate(String date) throws ParseException {
        if (date == null || date.isBlank() || date.equals("null")) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.parse(date);
    }
}

