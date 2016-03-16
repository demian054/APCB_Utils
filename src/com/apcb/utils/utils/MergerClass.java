/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.paymentHandler.enums.PaymentTypeEnum;
import com.apcb.utils.paymentHandler.enums.StatusIdEnum;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Demian
 */
public class MergerClass {
    
    public Object merge(Object objA, Object objB) {
        try {
            if (objA.getClass() ==  objB.getClass()){ 
               Field[] fieldsObjA = objA.getClass().getDeclaredFields(); 
               Field[] fieldsObjB = objB.getClass().getDeclaredFields(); 

                for (Field fieldA : fieldsObjA) {
                    fieldA.setAccessible(true);
                    for (Field fieldB : fieldsObjB) {
                        fieldB.setAccessible(true);
                        if (fieldB.get(fieldB.getName())!=null){
                            if (fieldA.getName().equals(fieldB.getName()) && fieldA.getType() == fieldB.getClass() ){
                                if (fieldA.getType().isPrimitive()){
                                    fieldA.set(fieldA, fieldB.get(fieldB));
                                } else {
                                    merge(fieldA.get(fieldA), fieldB.get(fieldB));
                                }
                                break;
                            }
                        }

                    }
                }  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objA;
    }
    
    public static void main(String[] args) {
        String objeto1 = "HOLA1";
        String objeto2 = "HOLA2";
        MergerClass mewClass = new MergerClass();
                mewClass.merge(objeto2, objeto2);
        
    }
}
