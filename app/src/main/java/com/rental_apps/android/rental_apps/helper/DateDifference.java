package com.rental_apps.android.rental_apps.helper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class DateDifference {
    static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static long betweenDates(String firstDate, String secondDate){
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));

        long daysDiff=0;
        long timeDiff=0;
        try {
            Date startDateObj = sdFormat.parse(firstDate);
            Date endDateObj = sdFormat.parse(secondDate);
            timeDiff = endDateObj.getTime() - startDateObj.getTime();
            daysDiff = timeDiff/(1000*60*60*24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return daysDiff;
    }
}
