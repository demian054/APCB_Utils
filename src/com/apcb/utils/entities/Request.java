/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.google.gson.Gson;

/**
 *
 * @author Demian
 */
public class Request {
    private Gson gson;
    private Beam beam;
    private String sesionId;
    private Message message;

    public Request() {
    }
    
    public Request(String strRequest) {
        fromString(strRequest);
    }
    
    public Beam getBeam() {
        return beam;
    }

    public void setBeam(Beam beam) {
        this.beam = beam;
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
    /*
    @Override
    public String toString() {
        return gson.toJson(this);
    }
    */
    public void fromString(String strRequest) { 
        Request request = gson.fromJson(strRequest, this.getClass());
        this.beam = request.getBeam();
        this.sesionId = request.getSesionId();
        this.message = request.getMessage();
    }
        
}
