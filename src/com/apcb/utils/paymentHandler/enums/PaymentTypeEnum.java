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
public enum PaymentTypeEnum {
    
    Efectivo ("1", "Cash", "0"),
    TarjetaCredito ("5", "Credit Card", "1"),
    TarjetaDebito ("6", "Debit Card", "2"),
    Invoice ("34", "Invoice", "0"),
    Miscellaneous ("37", "Miscellaneous", "0"),
    Know ("0","Know", "0");
    
    private final String code; 
    private final String codeAlternative; 
    private final String description; 
 
    PaymentTypeEnum (String code, String description, String codeAlternative) { 
        this.code = code;
        this.description = description;
        this.codeAlternative = codeAlternative;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public String getCodeAlternative() { return codeAlternative; }
    
    
    public static String getDescriptionByCode(String code){
        for (PaymentTypeEnum mealCodeEnum: PaymentTypeEnum.values()){
            if (mealCodeEnum.getCode().equalsIgnoreCase(code)){
                return mealCodeEnum.getDescription();
            } 
        }
        return PaymentTypeEnum.Know.getDescription();
    }
    
}
