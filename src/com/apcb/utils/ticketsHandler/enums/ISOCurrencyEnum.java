/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.enums;

/**
 *
 * @author Demian
 */
public enum ISOCurrencyEnum {
    
    BOLIVARFUERTE ("VEF","Bsf."), 
    USDOLLAR ("USD","Usd."),
    KNOW ("KNOW","Know Currency");
 
    private final String code; 
    private final String description; 
 
    ISOCurrencyEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
       
    public static String getDescriptionByCode(String code){
        for (ISOCurrencyEnum iSOCurrencyEnum: ISOCurrencyEnum.values()){
            if (iSOCurrencyEnum.getCode().equalsIgnoreCase(code)){
                return iSOCurrencyEnum.getDescription();
            } 
        }
        return ISOCurrencyEnum.KNOW.getDescription();
    }
    
    public static String getCodeByDescription(String description){
        for (ISOCurrencyEnum iSOCurrencyEnum: ISOCurrencyEnum.values()){
            if (iSOCurrencyEnum.getDescription().equalsIgnoreCase(description)){
                return iSOCurrencyEnum.getCode();
            } 
        }
        return ISOCountryEnum.KNOW.getDescription();
    }
    
    public static boolean isValid(ISOCurrencyEnum iSOCurrencyEnum){
        return iSOCurrencyEnum!=null && ISOCurrencyEnum.getDescriptionByCode(iSOCurrencyEnum.getDescription()).equals(ISOCurrencyEnum.KNOW.getDescription());
    }
}
