/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.ISOCurrencyEnum;
import com.apcb.utils.utils.ArrayUtils;

/**
 *
 * @author Demian
 */
public class Travel {


    CabinTypeEnum Cabin;
    boolean DirectFlightsOnly;
    Passanger[] passangers; 
    Itinerary[] itinerary; 
    
    ISOCurrencyEnum Currency;
    
    

    public CabinTypeEnum getCabin() {
        return Cabin;
    }

    public void setCabin(CabinTypeEnum Cabin) {
        this.Cabin = Cabin;
    }
    
    public Passanger[] getPassangers() {
        return passangers;
    }
    
    public void putPassangers(Passanger[] passangers) {
        this.passangers =  ArrayUtils.concat(this.passangers, passangers, Passanger.class);
    }
    
    public void putPassangers(Passanger passangers) {
        try {
           this.passangers = ArrayUtils.concat(this.passangers, passangers, Passanger.class); 
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }

    public void setPassangers(Passanger[] passangers) {
        this.passangers = passangers;
    }

    public boolean isDirectFlightsOnly() {
        return DirectFlightsOnly;
    }

    public void setDirectFlightsOnly(boolean DirectFlightsOnly) {
        this.DirectFlightsOnly = DirectFlightsOnly;
    }

    public Itinerary[] getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary[] itinerary) {
        this.itinerary = itinerary;
    }
    
    public void putItinerary(Itinerary[] itinerary) {
         try {
            this.itinerary =  ArrayUtils.concat(this.itinerary, itinerary, Itinerary.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void putItinerary(Itinerary itinerary) {
         try {
            this.itinerary =  ArrayUtils.concat(this.itinerary, itinerary, Itinerary.class);
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

 
       
 
}
