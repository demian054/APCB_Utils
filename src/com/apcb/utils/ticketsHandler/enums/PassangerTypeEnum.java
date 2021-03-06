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
public enum PassangerTypeEnum {
    
    Adulto ("ADT","Adults"), 
    Niño ("CNN","Children"),
    Infante ("INF","Infants");

 
    private final String code; 
    private final String description; 
 
    PassangerTypeEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    
    public static PassangerTypeEnum getByCode(String code){
        for (PassangerTypeEnum passangerTypeEnum:PassangerTypeEnum.values()){
            if (passangerTypeEnum.getCode().equals(code)){
                return passangerTypeEnum;
            }
        }
        return null;
    }
       
}
