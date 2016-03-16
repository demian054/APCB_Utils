/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import com.apcb.utils.ticketsHandler.entities.APCB_Passenger;
import com.apcb.utils.ticketsHandler.entities.APCB_PassengerDetail;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Demian
 */
public class ArrayUtils {
    
    public static <T> T[] concat(T[] first, T second, Class<T> clase) throws Exception {
        T[] arraySecond = (T[]) Array.newInstance(clase, 1);
        arraySecond[0] = second;
        return concat(first,arraySecond, clase);
    }
    
    
    public static <T> T[] concat(T[] first, T[] second, Class<T> clase) {
        if (first==null) first = (T[]) Array.newInstance(clase, 0);
        if (second==null) second = (T[]) Array.newInstance(clase, 0);
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    
    public static <T> T[] concatAll(Class<T> clase, T[] first, T[]... rest) {
        if (first==null) first = (T[]) Array.newInstance(clase, 1); 
        int totalLength = first.length;
        for (T[] array : rest) {
          if (array==null) array = (T[]) Array.newInstance(clase, 1);
          totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
          System.arraycopy(array, 0, result, offset, array.length);
          offset += array.length;
        }
        return result;
    }
    
    public static <T> T[] delete(T[] array, T toEliminate, Class<T> clase) {
        T[] result = (T[]) Array.newInstance(clase, array.length-1); 
        int deleted = 0; 
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(toEliminate)){
                deleted++;
            } else {
                result[i-deleted] = array[i];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Integer[] arreglo = new Integer[5];
        arreglo[0] = 1;
        arreglo[1] = 2;
        arreglo[2] = 3;
        arreglo[3] = 4;
        arreglo[4] = 5;
        
        arreglo = delete(arreglo, arreglo[2], Integer.class);
        for (Integer integer : arreglo) {
          System.out.println(integer);  
        }
        
        List<APCB_PassengerDetail> passengerDetailADT = new ArrayList<APCB_PassengerDetail>();
        passengerDetailADT.add(new APCB_PassengerDetail());
        passengerDetailADT.add(new APCB_PassengerDetail());
        passengerDetailADT.add(new APCB_PassengerDetail());
        
        
        APCB_Passenger aPCB_Passenger = new APCB_Passenger();
        aPCB_Passenger.putPassengersDetail(passengerDetailADT.toArray(new APCB_PassengerDetail[passengerDetailADT.size()]));
     
        for (APCB_PassengerDetail passengerDetail : aPCB_Passenger.getPassengersDetail()) {
          System.out.println(passengerDetail);  
        }
    }
}
