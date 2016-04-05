/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.ISOCurrencyEnum;
import java.util.List;

/**
 *
 * @author Demian
 */
public class APCB_Cost {
    private double totalAmount;
    private double baseAmount;
    private String currencyCode;
    private List<APCB_Tax> taxes; 

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<APCB_Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<APCB_Tax> taxes) {
        this.taxes = taxes;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(double baseAmount) {
        this.baseAmount = baseAmount;
    }
    
    
    
}
