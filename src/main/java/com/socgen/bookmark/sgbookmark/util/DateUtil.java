package com.socgen.bookmark.sgbookmark.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    
    public static Date convertTimestampToDate(Timestamp timestamp) {
    	
    	return new Date(timestamp.getTime());
    }
    
    public static Timestamp convertDateToTimestamp(Date date) {
    	return new Timestamp(date.getTime());
    }
}
