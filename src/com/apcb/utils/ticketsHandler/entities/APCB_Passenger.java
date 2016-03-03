/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.PassangerTypeEnum;

/**
 *
 * @author Demian
 */
public class APCB_Passenger {
    PassangerTypeEnum passangerType;
    int passangerQuantity;
    APCB_PassengerDetail[] passengersDetail;
    APCB_Cost detailCost;

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

    public APCB_Cost getDetailCost() {
        return detailCost;
    }

    public void setDetailCost(APCB_Cost detailCost) {
        this.detailCost = detailCost;
    }

    public APCB_PassengerDetail[] getPassengersDetail() {
        return passengersDetail;
    }

    public void setPassengersDetail(APCB_PassengerDetail[] passengersDetail) {
        this.passengersDetail = passengersDetail;
    }
    
    
    
    
    
}
