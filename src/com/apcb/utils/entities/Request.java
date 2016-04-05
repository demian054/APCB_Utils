/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.google.gson.Gson;
import org.apache.logging.log4j.ThreadContext;

/**
 *
 * @author Demian
 */
public class Request {

    private APCB_Travel travelInfo;
    private String sesionId;
    private Message message;
    private Message[] warninig;
    private APCB_PayMain payMainInfo;

    public Request() {}
    
    public Request(String strRequest) {
        fromString(strRequest);
        ThreadContext.put("sessionId", sesionId);
        if (payMainInfo!=null){
            ThreadContext.put("sessionIP", payMainInfo.getIP());
        }
    }

    public APCB_Travel getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(APCB_Travel travelInfo) {
        this.travelInfo = travelInfo;
    }

    public APCB_PayMain getPayMainInfo() {
        return payMainInfo;
    }

    public void setPayMainInfo(APCB_PayMain payMainInfo) {
        this.payMainInfo = payMainInfo;
    }

    public Message[] getWarninig() {
        return warninig;
    }

    public void setWarninig(Message[] warninig) {
        this.warninig = warninig;
    }

    public String getSesionId() {
        return sesionId;
    }

    public void setSesionId(String sesionId) {
        this.sesionId = sesionId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

   
    public void fromString(String strRequest) { 
        Request request = new Gson().fromJson(strRequest, this.getClass());
        this.travelInfo = request.getTravelInfo();
        this.sesionId = request.getSesionId();
        this.message = request.getMessage();
        this.payMainInfo = request.getPayMainInfo();       
    }
        
}
