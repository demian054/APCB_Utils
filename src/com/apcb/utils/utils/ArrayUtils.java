/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

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
    
}
