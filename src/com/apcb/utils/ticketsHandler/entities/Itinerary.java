/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import com.apcb.utils.utils.ArrayUtils;
import java.util.Calendar;

/**
 *
 * @author Demian
 */
public class Itinerary {
    private Calendar departureDateTime;
    private LocationEnum originLocationCode;    
    private LocationEnum destinationLocationCode;

    private ItineraryOption[] itineraryOption;

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

    public void putItineraryOption(ItineraryOption[] itineraryOption) {
         try {
            this.itineraryOption =  ArrayUtils.concat(this.itineraryOption, itineraryOption, ItineraryOption.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void putItineraryOption(ItineraryOption itineraryOption) {
         try {
            this.itineraryOption =  ArrayUtils.concat(this.itineraryOption, itineraryOption, ItineraryOption.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    
}
