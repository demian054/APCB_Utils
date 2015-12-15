/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.logging.Level;
import org.apache.log4j.Logger;


/**
 *
 * @author Demian
 */
public class PropertiesReader {
    private final static Logger log = Logger.getLogger(PropertiesReader.class);
    private Properties prop;
    private String target;
      
    public PropertiesReader() {
        prop = new Properties();
    }

    public PropertiesReader(String propFileName) throws IOException {
        prop = new Properties();       
        addProperyFile(propFileName);
    }
    
    public void addProperyFile(String propFileName){
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName+".properties");
        try {
            if (inputStream != null) {
                prop.load(inputStream);
                target = prop.getProperty("Target");
                log.info(propFileName+" Target Selected "+target);
                this.prop.putAll(prop);
            } else {
                throw new IOException();
            } 
        } catch (IOException ex) {
            log.error("property file '" + propFileName + ".properties' not found in the classpath");
        }
    }
        
    public String getProperty(String propertyName){
        return getProperty(propertyName, true);
    }
    
    public String getProperty(String propertyName, boolean useTarget){
        if (useTarget){
            propertyName = new StringBuilder(target).append(".").append(propertyName).toString();
        }
        String resp = prop.getProperty(propertyName);
        if (resp==null || resp.isEmpty()){
            System.err.println("Error to Charge propertyName "+propertyName);
            return "";
        }
        return resp;
    }
    
    public void setProperty(String propertyName, String value){
        prop.put(propertyName, value);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    
}
