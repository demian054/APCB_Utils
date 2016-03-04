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
    
    Efectivo ("1", "Cash"),
    TarjetaCredito ("5", "Credit Card"),
    TarjetaDebito ("6", "Debit Card"), 
    Invoice ("34", "Invoice"),
    Miscellaneous ("37", "Miscellaneous"),
    Know ("0","Know");
    
    private final String code; 
    private final String description; 
 
    PaymentTypeEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    
    public static String getDescriptionByCode(String code){
        for (PaymentTypeEnum mealCodeEnum: PaymentTypeEnum.values()){
            if (mealCodeEnum.getCode().equalsIgnoreCase(code)){
                return mealCodeEnum.getDescription();
            } 
        }
        return PaymentTypeEnum.Know.getDescription();
    }
    
}
