/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.paymentHandler.enums;

/**
 *
 * @author Demian
 */
public enum CardEmisorEnum {
    
    Visa  ("VI","Visa"),
    MasterCard  ("IK","MasterCard"), 
    AmericanExpress  ("AX","AmericanExpress"), 
    Know ("KN","Know");
    
    private final String code; 
    private final String description; 
 
    CardEmisorEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    
    public static String getDescriptionByCode(String code){
        for (CardEmisorEnum cardEmisorEnum: CardEmisorEnum.values()){
            if (cardEmisorEnum.getCode().equalsIgnoreCase(code)){
                return cardEmisorEnum.getDescription();
            } 
        }
        return CardEmisorEnum.Know.getDescription();
    }
    
}
