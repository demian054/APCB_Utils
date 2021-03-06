/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.conection;

import com.apcb.utils.utils.PropertiesReader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author Demian
 */
public class ServiceGenerator {
    private static Logger log = LogManager.getLogger(ServiceGenerator.class);
    
    
    public static <T> T ServiceGenerator(Class<T> ServiceName) throws Exception {
        String simpleServiceName = ServiceName.getSimpleName();
        try {
            PropertiesReader prop = new PropertiesReader(simpleServiceName); 
            URL url = new URL(prop.getProperty(simpleServiceName+".urlService"));
            QName qname = new QName(
                    prop.getProperty(simpleServiceName+".nameSpaceURI"),
                    prop.getProperty(simpleServiceName+".localPart")
                );  
            Service service = Service.create(url, qname);
            return service.getPort(ServiceName);    

        } catch (Exception e) {
           log.error("Error Conectando a servicio "+ServiceName.getSimpleName(), e);
        }
        return null;
    }
    
}
