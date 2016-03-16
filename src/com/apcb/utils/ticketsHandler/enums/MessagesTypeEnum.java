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
public enum MessagesTypeEnum {
    
    //MESSAGES OK
    Ok ("200","Ok"),
    
    
    //ERRORS
    Error_AplicationErrorNotHandler ("501", "Aplication error not Handler"),
    
    //VALIDATION ERRORS
    ErrorValidate_DateFormatIncorrect ("801", "Error Validate DateFormat Incorrect"),
    ErrorValidate_ObjectPayMain       ("802", "Error Validate Object PayMain"),
    ErrorValidate_NoItineraryOptionsAvailable ("803", "Error Validate No Itinerary Options Available"),
    ErrorValidate_CostOrDisponibility ("804", "Error Validate Cost Or Disponibility"),
        
    //Error access to services
    
    ErrorAccess_Business            ("601", "Errot to access to service Business"),
    ErrorAccess_TicketsHandler      ("602", "Errot to access to service TicketsHandler"),
    ErrorAccess_PaymentHandler      ("603", "Errot to access to service PaymentHandler"),
    
     //Error access to External services
    
    ErrorAccessExt_Kiu              ("701", "Errot to access to External service KIU"),
    ErrorAccessExt_IntaPago         ("702", "Errot to access to External service IntaPago"),
    


    
    
    KnowMessage ("000", "Know Message");
    
    private final String code; 
    private final String description; 
 
    MessagesTypeEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    
        
    public static MessagesTypeEnum getMessagesType(String code, String description){
        for (MessagesTypeEnum messagesTypeEnum: MessagesTypeEnum.values()){
            if (messagesTypeEnum.getCode().equalsIgnoreCase(code) && messagesTypeEnum.getDescription().equalsIgnoreCase(description)){
                return messagesTypeEnum;
            } 
        }
        return MessagesTypeEnum.KnowMessage;
    }
    
}
