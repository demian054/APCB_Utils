/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.Enums;

/**
 *
 * @author Demian
 */
public enum ISOCountryEnum {
    
    VENEZUELA ("VEN","Venezuela"),
    KNOW ("KNOW","Know Country");
    private final String code; 
    private final String description; 
 
    ISOCountryEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
       
    public static String getDescriptionByCode(String code){
        for (ISOCountryEnum iSOCurrencyEnum: ISOCountryEnum.values()){
            if (iSOCurrencyEnum.getCode().equalsIgnoreCase(code)){
                return iSOCurrencyEnum.getDescription();
            } 
        }
        return ISOCountryEnum.KNOW.getDescription();
    }
}
