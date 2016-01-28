/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.Enums.ISOCurrencyEnum;
import java.util.List;

/**
 *
 * @author Demian
 */
public class APCB_Cost {
    private double totalAmount;
    private String currencyCode;
    private List<APCB_Tax> taxes; 
    
}
