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
public enum CabinTypeEnum {
    
    Business ("BUS","Business","B"), 
    Cockpit ("COC","Cockpit","H"), 
    Economy ("ECO","Economy","Y"), 
    First ("FIR","First","N"), 
    PremiumBusiness ("PRB","PremiumBusiness","B"), 
    PremiumEconomy ("PRE","PremiumEconomy","B");
 
    private final String code;
    private final String bookingCode;
    private final String description; 
 
    CabinTypeEnum (String code, String description, String bookingCode) { 
        this.code = code;
        this.description = description;
        this.bookingCode = bookingCode;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public String getBookingCode() { return bookingCode; }
       
}
