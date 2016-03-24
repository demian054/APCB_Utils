/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.enums.ISOCurrencyEnum;
import com.apcb.utils.utils.ArrayUtils;

/**
 *
 * @author Demian
 */
public class APCB_Travel {

    String transactionId;
    CabinTypeEnum Cabin;
    boolean DirectFlightsOnly;
    APCB_Passenger[] passangers; 
    APCB_Itinerary[] itinerary;
    ISOCurrencyEnum Currency;
    
    
    String bookingReferenceID;
    String ticketNumber;
    String ticket;
    Integer TicketTimeLimit;
    
    String qRCode;
    String pdfLink;
            
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public CabinTypeEnum getCabin() {
        return Cabin;
    }

    public void setCabin(CabinTypeEnum Cabin) {
        this.Cabin = Cabin;
    }
    
    public APCB_Passenger[] getPassangers() {
        return passangers;
    }
    
    public void putPassangers(APCB_Passenger[] passangers) {
        this.passangers =  ArrayUtils.concat(this.passangers, passangers, APCB_Passenger.class);
    }
    
    public void putPassangers(APCB_Passenger passangers) {
        try {
           this.passangers = ArrayUtils.concat(this.passangers, passangers, APCB_Passenger.class); 
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }

    public void setPassangers(APCB_Passenger[] passangers) {
        this.passangers = passangers;
    }

    public boolean isDirectFlightsOnly() {
        return DirectFlightsOnly;
    }

    public void setDirectFlightsOnly(boolean DirectFlightsOnly) {
        this.DirectFlightsOnly = DirectFlightsOnly;
    }

    public APCB_Itinerary[] getItinerary() {
        return itinerary;
    }

    public void setItinerary(APCB_Itinerary[] itinerary) {
        this.itinerary = itinerary;
    }
    
    public void putItinerary(APCB_Itinerary[] itinerary) {
         try {
            this.itinerary =  ArrayUtils.concat(this.itinerary, itinerary, APCB_Itinerary.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void putItinerary(APCB_Itinerary itinerary) {
         try {
            this.itinerary =  ArrayUtils.concat(this.itinerary, itinerary, APCB_Itinerary.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
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

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Integer getTicketTimeLimit() {
        return TicketTimeLimit;
    }

    public void setTicketTimeLimit(Integer TicketTimeLimit) {
        this.TicketTimeLimit = TicketTimeLimit;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getqRCode() {
        return qRCode;
    }

    public void setqRCode(String qRCode) {
        this.qRCode = qRCode;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }
    
    
 
}
