/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import com.apcb.utils.utils.ArrayUtils;
import java.util.Calendar;

/**
 *
 * @author Demian
 */
public class Itinerary {
    
    Calendar departureDateTime;
    LocationEnum originLocationCode;    
    LocationEnum destinationLocationCode;
    CabinTypeEnum Cabin;
    boolean DirectFlightsOnly;
 
    Passanger[] passangers;  
    ItineraryOption[] destinationOption;

    public Calendar getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Calendar departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocationEnum getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(LocationEnum originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public LocationEnum getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(LocationEnum destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

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
    
    public void putDestinationOption(ItineraryOption[] destinationOption) {
         try {
            this.destinationOption =  ArrayUtils.concat(this.destinationOption, destinationOption, ItineraryOption.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void putDestinationOption(ItineraryOption destinationOption) {
         try {
            this.destinationOption =  ArrayUtils.concat(this.destinationOption, destinationOption, ItineraryOption.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public ItineraryOption[] getDestinationOption() {
        return destinationOption;
    }

    public void setDestinationOption(ItineraryOption[] destinationOption) {
        this.destinationOption = destinationOption;
    }

    public boolean isDirectFlightsOnly() {
        return DirectFlightsOnly;
    }

    public void setDirectFlightsOnly(boolean DirectFlightsOnly) {
        this.DirectFlightsOnly = DirectFlightsOnly;
    }
       
 
}
