/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.enums.LocationEnum;
import com.apcb.utils.utils.ArrayUtils;
import java.util.Calendar;


/**
 *
 * @author Demian
 */
public class APCB_ItineraryOption {

    LocationEnum arrivalLocationCode;    
    LocationEnum DepartureLocationCode;
    CabinTypeEnum Cabin;
    String FlightNumber;
    String JourneyDuration;
    Calendar departureDateTime;
    Calendar arrivalDateTime;
    int StopQuantity;
    String AirEquipType;
    String CompanyShortName;
    Boolean MealServices;
    String[] MealCode; 
    //APCB_Cost totalCost;
    int BookingAvail; 

    public LocationEnum getArrivalLocationCode() {
        return arrivalLocationCode;
    }

    public void setArrivalLocationCode(LocationEnum arrivalLocationCode) {
        this.arrivalLocationCode = arrivalLocationCode;
    }

    public LocationEnum getDepartureLocationCode() {
        return DepartureLocationCode;
    }

    public void setDepartureLocationCode(LocationEnum DepartureLocationCode) {
        this.DepartureLocationCode = DepartureLocationCode;
    }

    public CabinTypeEnum getCabin() {
        return Cabin;
    }

    public void setCabin(CabinTypeEnum Cabin) {
        this.Cabin = Cabin;
    }
    
    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String FlightNumber) {
        this.FlightNumber = FlightNumber;
    }

    public String getJourneyDuration() {
        return JourneyDuration;
    }

    public void setJourneyDuration(String JourneyDuration) {
        this.JourneyDuration = JourneyDuration;
    }

    public Calendar getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Calendar departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Calendar getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Calendar arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public int getStopQuantity() {
        return StopQuantity;
    }

    public void setStopQuantity(int StopQuantity) {
        this.StopQuantity = StopQuantity;
    }

    public String getAirEquipType() {
        return AirEquipType;
    }

    public void setAirEquipType(String AirEquipType) {
        this.AirEquipType = AirEquipType;
    }

    public String getCompanyShortName() {
        return CompanyShortName;
    }

    public void setCompanyShortName(String CompanyShortName) {
        this.CompanyShortName = CompanyShortName;
    }

    public Boolean isMealServices() {
        return MealServices;
    }

    public void setMealServices(Boolean MealServices) {
        this.MealServices = MealServices;
    }

    public String[] getMealCode() {
        if (MealCode==null) MealCode = new String[0];
        return MealCode;
    }
    
    public void putMealCode(String[] MealCode) {
        try {
            this.MealCode =  ArrayUtils.concat(this.MealCode, MealCode, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void putMealCode(String MealCode) {
        try {
            this.MealCode =  ArrayUtils.concat(this.MealCode, MealCode, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void setMealCode(String[] MealCode) {
        this.MealCode = MealCode;
    }
/*
    public APCB_Cost getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(APCB_Cost totalCost) {
        this.totalCost = totalCost;
    }
*/
    public int getBookingAvail() {
        return BookingAvail;
    }

    public void setBookingAvail(int BookingAvail) {
        this.BookingAvail = BookingAvail;
    }
    

}
