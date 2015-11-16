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
public class Response {
    private Gson gson;
    private Beam beam;
    private String sesionId;
    private Message message;

    public Response() {
        gson = new Gson();
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
    
    public void fromString(String strResponse) { 
        Response response = gson.fromJson(strResponse, this.getClass());
        this.beam = response.getBeam();
        this.sesionId = response.getSesionId();
        this.message = response.getMessage();
    }
 */
}
