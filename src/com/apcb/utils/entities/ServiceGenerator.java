/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class ServiceGenerator {
    private static final Logger logger = LogManager.getLogger(ServiceGenerator.class);
    
    
    public static <T> T ServiceGenerator(Class<T> ServiceName) throws Exception {
        //String filename = "services.properties";
        String simpleServiceName = ServiceName.getSimpleName();
        try {
            PropertiesReader prop = new PropertiesReader(simpleServiceName); 
        //servletContext.getResourceAsStream("/WEB-INF/myfile");
         /*   InputStream input = ServiceGenerator.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                throw new Exception("Archivo "+filename+" No encontrado");
            }
            Properties properties = new Properties();
            properties.load(input);*/
            URL url = new URL(prop.getProperty("urlService"));
            QName qname = new QName(
                    prop.getProperty("nameSpaceURI"),
                    prop.getProperty("localPart")
                );  
            Service service = Service.create(url, qname);
            return service.getPort(ServiceName);    

        } catch (Exception e) {
           logger.error("Error Conectando a servicio "+ServiceName.getSimpleName(), e);
        }
        return null;
    }
    
}
