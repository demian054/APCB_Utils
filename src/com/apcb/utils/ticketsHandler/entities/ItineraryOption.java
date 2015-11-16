/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import com.apcb.utils.ticketsHandler.Enums.MealCodeEnum;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Demian
 */
public class ItineraryOption {

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
    List<String> MealCode; 

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

    public List<String> getMealCode() {
        return MealCode;
    }

    public void setMealCode(List<String> MealCode) {
        this.MealCode = MealCode;
    }
    
    
}
