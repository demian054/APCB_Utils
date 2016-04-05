/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_Passenger;
import com.apcb.utils.ticketsHandler.entities.APCB_PassengerDetail;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.apcb.utils.ticketsHandler.enums.ISOCurrencyEnum;
import com.google.gson.Gson;
import org.apache.logging.log4j.ThreadContext;

/**
 *
 * @author Demian
 */
public class RequestTicket {
    
    private APCB_PassengerDetail passengerDetail; 
    private String sesionId;
    private Message message;
    private ISOCurrencyEnum Currency;
    private String bookingReferenceID;

    public RequestTicket() {}

    public RequestTicket(Request request) { 
        this.sesionId = request.getSesionId();
        this.message = request.getMessage();  
        this.Currency = request.getTravelInfo().getCurrency();
        ThreadContext.put("sessionId", sesionId);
    }

    public String getSesionId() {
        return sesionId;
    }

    public void setSesionId(String sesionId) {
        this.sesionId = sesionId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public APCB_PassengerDetail getPassengerDetail() {
        return passengerDetail;
    }

    public void setPassengerDetail(APCB_PassengerDetail passengerDetail) {
        this.passengerDetail = passengerDetail;
    }

    public ISOCurrencyEnum getCurrency() {
        return Currency;
    }

    public void setCurrency(ISOCurrencyEnum Currency) {
        this.Currency = Currency;
    }

    public String getBookingReferenceID() {
        return bookingReferenceID;
    }

    public void setBookingReferenceID(String bookingReferenceID) {
        this.bookingReferenceID = bookingReferenceID;
    }
    
    

        
}
