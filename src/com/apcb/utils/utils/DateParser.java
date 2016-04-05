/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Demian
 */
public class DateParser {
    private static Logger log = LogManager.getLogger(DateParser.class);
    
     public static String toDateSring(Calendar date, PropertiesReader prop, String Format) {
        try {
            DateFormat df = new SimpleDateFormat(prop.getProperty(Format, false));
            String strDate = df.format(date.getTime()); 
            log.info("strDate Out "+strDate);
            return strDate;
        } catch (Exception e) {
            log.error("Error toDateString : " + Format, e);
        }
        return "Error toDateString : " + Format;
    }

    public static Calendar fromDateSring(String strDate, PropertiesReader prop, String Format) {
        Calendar date = new GregorianCalendar();
        if (!strDate.isEmpty()) {
            try {
                log.info("strDate in "+strDate);
                DateFormat df = new SimpleDateFormat(prop.getProperty(Format, false));
                date.setTime(df.parse(strDate));
                return date;
            } catch (Exception e) {
                log.error("Error fromDateSring : " + Format, e);
            }
        }
        return date;
    }
    
}
