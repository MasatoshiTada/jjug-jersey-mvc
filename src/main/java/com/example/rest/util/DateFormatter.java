package com.example.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author tada
 */
@Named("formatter")
@ApplicationScoped
public class DateFormatter {
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    
    public String format(Date date) {
        return new SimpleDateFormat(DATE_PATTERN).format(date);
    }
    
    public Date parse(String dateStr) throws ParseException {
        return new SimpleDateFormat(DATE_PATTERN).parse(dateStr);
    }
}
