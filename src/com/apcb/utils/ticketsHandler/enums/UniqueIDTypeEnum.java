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
public enum UniqueIDTypeEnum {
    
    BookingReferenceID ("14", "Booking"), 
    TicketNumber ("30", "Ticket");
 
    private final String code;
    private final String description;
 
    UniqueIDTypeEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public static UniqueIDTypeEnum getByCode(String code){
        for (UniqueIDTypeEnum cabinTypeEnum:UniqueIDTypeEnum.values()){
            if (cabinTypeEnum.getCode().equals(code)){
                return cabinTypeEnum;
            }
        }
        return null;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    
   
}
