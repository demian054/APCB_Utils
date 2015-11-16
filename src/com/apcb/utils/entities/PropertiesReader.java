/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import org.apache.log4j.Logger;


/**
 *
 * @author Demian
 */
public class PropertiesReader {
    private final static Logger log = Logger.getLogger(PropertiesReader.class);
    private InputStream inputStream;
    private Properties prop;
    private String target;
      
    public PropertiesReader() {
        prop = new Properties();
    }

    /*public PropertiesReader(String propertyFileName, Class clase) {
        prop = new Properties();
        //this.getClass().getResourceAsStream(propertyFileName+".properties");
         String propertyFilePath = new StringBuilder(System.getProperty("user.dir"))
                    .append(File.separator).append(propertyFileName)
                    .append(".properties").toString();
         read(propertyFilePath, clase);
    }*/
    
    public PropertiesReader(String propFileName) throws IOException {
        prop = new Properties();       
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName+".properties");
        if (inputStream != null) {
            prop.load(inputStream);
            target = prop.getProperty("Target");
            log.info("Target Selected "+target);
        } else {
            log.error("property file '" + propFileName + ".properties' not found in the classpath");
        }  
    }
    
    /*private void read(String propertyFilePath, Class clase){
	InputStream inputFile = null;
	try {      
            prop.load(clase.getClass().getClassLoader().getResourceAsStream("Config.properties"));
            target = prop.getProperty("Target");
            log.info("Target Selected "+target);
	} catch (IOException ex) {
            log.error("Error to Charge "+propertyFilePath);
            ex.printStackTrace();
        } finally{
            if(inputFile!=null){
                try {
                        inputFile.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }
    
    }*/
    
    public String getProperty(String propertyName){
        return getProperty(propertyName, true);
    }
    
    public String getProperty(String propertyName, boolean useTarget){
        if (useTarget){
            propertyName = new StringBuilder(target).append(".").append(propertyName).toString();
        }
        String resp = prop.getProperty(propertyName);
        if (resp==null || resp.isEmpty()){
            System.err.println("Error to Charge propertyName "+target+propertyName);
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
