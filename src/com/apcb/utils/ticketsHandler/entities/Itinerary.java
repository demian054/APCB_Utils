/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import java.util.Calendar;
import java.util.List;

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
  
    List<Passanger> passagers; 
    
    List<ItineraryOption> destinationOption;
    


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

    public List<Passanger> getPassagers() {
        return passagers;
    }

    public void setPassagers(List<Passanger> passagers) {
        this.passagers = passagers;
    }

    public boolean isDirectFlightsOnly() {
        return DirectFlightsOnly;
    }

    public void setDirectFlightsOnly(boolean DirectFlightsOnly) {
        this.DirectFlightsOnly = DirectFlightsOnly;
    }

    public List<ItineraryOption> getDestinationOption() {
        return destinationOption;
    }

    public void setDestinationOption(List<ItineraryOption> destinationOption) {
        this.destinationOption = destinationOption;
    }
    
    
    
}
