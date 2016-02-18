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
    int PassangerQuantity;
    APCB_Cost detailCost;

    public PassangerTypeEnum getPassangerType() {
        return passangerType;
    }

    public void setPassangerType(PassangerTypeEnum passangerType) {
        this.passangerType = passangerType;
    }

    public int getPassangerQuantity() {
        return PassangerQuantity;
    }

    public void setPassangerQuantity(int PassangerQuantity) {
        this.PassangerQuantity = PassangerQuantity;
    }

    public APCB_Cost getDetailCost() {
        return detailCost;
    }

    public void setDetailCost(APCB_Cost detailCost) {
        this.detailCost = detailCost;
    }
    
    
    
    
    
}
