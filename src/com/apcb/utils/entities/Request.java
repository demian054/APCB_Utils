/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.paymentHandler.entities.PayMainRequest;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Demian
 */
public class Request {

    private Beam beam;
    private String sesionId;
    private Message message;
    private Message[] warninig;
    private PayMainRequest payMainRequest;

    public Request() {}
    
    public Request(String strRequest) {
        fromString(strRequest);
    }

    public Beam getBeam() {
        return beam;
    }

    public void setBeam(Beam beam) {
        this.beam = beam;
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

    public PayMainRequest getPayMainRequest() {
        return payMainRequest;
    }

    public void setPayMainRequest(PayMainRequest payMainRequest) {
        this.payMainRequest = payMainRequest;
    }

   
    public void fromString(String strRequest) { 
        Request request = new Gson().fromJson(strRequest, this.getClass());
        this.beam = request.getBeam();
        this.sesionId = request.getSesionId();
        this.message = request.getMessage();
        this.payMainRequest = request.getPayMainRequest();
        
    }
        
}
