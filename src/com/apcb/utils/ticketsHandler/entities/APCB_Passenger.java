/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.PassangerTypeEnum;
import com.apcb.utils.utils.ArrayUtils;

/**
 *
 * @author Demian
 */
public class APCB_Passenger {
    PassangerTypeEnum passangerType;
    int passangerQuantity;
    APCB_PassengerDetail[] passengersDetail;

    public PassangerTypeEnum getPassangerType() {
        return passangerType;
    }

    public void setPassangerType(PassangerTypeEnum passangerType) {
        this.passangerType = passangerType;
    }

    public int getPassangerQuantity() {
        return passangerQuantity;
    }

    public void setPassangerQuantity(int PassangerQuantity) {
        this.passangerQuantity = PassangerQuantity;
    }

    public APCB_PassengerDetail[] getPassengersDetail() {
        return passengersDetail;
    }

    public void setPassengersDetail(APCB_PassengerDetail[] passengersDetail) {
        this.passengersDetail = passengersDetail;
    }
    
    public void putPassengersDetail(APCB_PassengerDetail[] passengersDetail) {
         try {
            this.passengersDetail =  ArrayUtils.concat(this.passengersDetail, passengersDetail, APCB_PassengerDetail.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void putPassengersDetail(APCB_PassengerDetail passengersDetail) {
         try {
            this.passengersDetail =  ArrayUtils.concat(this.passengersDetail, passengersDetail, APCB_PassengerDetail.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    
    
    
}
