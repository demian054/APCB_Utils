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
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class DateParser {
     private final static Logger log = Logger.getLogger(DateParser.class);
    
     public static String toDateSring(Calendar date, PropertiesReader prop, String Format) {
        try {
            DateFormat df = new SimpleDateFormat(prop.getProperty(Format, false));
            return df.format(date.getTime());
        } catch (Exception e) {
            log.error("Error toDateString : " + Format, e);
        }
        return "Error toDateString : " + Format;
    }

    public static Calendar fromDateSring(String strDate, PropertiesReader prop, String Format) {
        Calendar date = new GregorianCalendar();
        if (!strDate.isEmpty()) {
            try {
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
