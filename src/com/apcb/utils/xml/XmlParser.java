/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.xml;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Demian
 */
public class XmlParser {
    
    public static String toXML(Object object, Class claseType){
        StringWriter stringWriter = new StringWriter(); 
        try {

          JAXBContext jaxbContext = JAXBContext.newInstance(claseType);
          Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

          // output pretty printed
          jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
          jaxbMarshaller.marshal(object, stringWriter);
        } catch (JAXBException e) {
          e.printStackTrace();
        }
        return stringWriter.getBuffer().toString();
    }
    
    public static Object fromXML(String strXml, Class claseType){
        try {
            
            JAXBContext jaxbContext = JAXBContext.newInstance(claseType);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(strXml);
            return jaxbUnmarshaller.unmarshal(stringReader);
  
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
    }

   
    
    

    
    
    
}

