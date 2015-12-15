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
    
    VENEZUELA ("VE","Venezuela"),
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
        for (ISOCountryEnum iSOCountryEnum: ISOCountryEnum.values()){
            if (iSOCountryEnum.getCode().equalsIgnoreCase(code)){
                return iSOCountryEnum.getDescription();
            } 
        }
        return ISOCountryEnum.KNOW.getDescription();
    }
    
    public static String getCodeByDescription(String description){
        for (ISOCountryEnum iSOCountryEnum: ISOCountryEnum.values()){
            if (iSOCountryEnum.getDescription().equalsIgnoreCase(description)){
                return iSOCountryEnum.getCode();
            } 
        }
        return ISOCountryEnum.KNOW.getDescription();
    }
}
