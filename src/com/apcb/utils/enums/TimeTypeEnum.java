/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.enums;

/**
 *
 * @author Demian
 */
public enum TimeTypeEnum {
      
    Meses         ("M"),
    Años          ("Y");
    
    private final String code; 
 
    TimeTypeEnum (String description) { 
        this.code = description;
    }

    public String getCode() { return code; }
    
    public static TimeTypeEnum getByCode(String code){
        for (TimeTypeEnum timeTypeEnum:TimeTypeEnum.values()){
            if (timeTypeEnum.getCode().equals(code)){
                return timeTypeEnum;
            }
        }
        return null;
    }
    
    
}
