/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.PassangerTypeEnum;

/**
 *
 * @author Demian
 */
public class Passanger {
    PassangerTypeEnum passangerType;
    int PassangerQuantity;

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
    
    
    
    
    
}
