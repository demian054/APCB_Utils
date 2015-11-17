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
public enum MessagesTypeEnum {
    
    //MESSAGES OK
    Ok ("200","Ok"),
    
    
    //ERRORS
    AplicationErrorNotHandler ("501", "Aplication error not Handler"),
    
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