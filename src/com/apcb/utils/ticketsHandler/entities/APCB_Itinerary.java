/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.LocationEnum;
import com.apcb.utils.utils.ArrayUtils;
import java.util.Calendar;

/**
 *
 * @author Demian
 */
public class APCB_Itinerary {
    private Calendar departureDateTime;
    private LocationEnum originLocationCode;    
    private LocationEnum destinationLocationCode;

    private APCB_ItineraryOption[] itineraryOption;

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

    public void putItineraryOption(APCB_ItineraryOption[] itineraryOption) {
         try {
            this.itineraryOption =  ArrayUtils.concat(this.itineraryOption, itineraryOption, APCB_ItineraryOption.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void putItineraryOption(APCB_ItineraryOption itineraryOption) {
         try {
            this.itineraryOption =  ArrayUtils.concat(this.itineraryOption, itineraryOption, APCB_ItineraryOption.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public APCB_ItineraryOption[] getItineraryOption() {
        return itineraryOption;
    }

    public void setItineraryOption(APCB_ItineraryOption[] itineraryOption) {
        this.itineraryOption = itineraryOption;
    }
  
    
}
