/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.ticketsHandler.entities.Itinerary;
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
    

    /*
    public <T> T getObjectBean() throws ClassNotFoundException{
        return (T) new Gson().fromJson(beam.getObjectStr().replace("\\",""), Itinerary.class);//Class.forName(beam.getObjectType()).getClass());  
    }*/

    public Message[] getWarninig() {
        return warninig;
    }

    public void setWarninig(Message[] warninig) {
        this.warninig = warninig;
    }

    
    /*public void setBeam(Object objectStr, Class objectType) {
        Beam beam = new Beam();
        beam.setObject(new Gson().toJson(objectStr));
        beam.setObjectType(objectType.getName());
        this.beam = beam;
    }*/

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
        Request request = new Gson().fromJson(strRequest, this.getClass());
        this.beam = request.getBeam();
        this.sesionId = request.getSesionId();
        this.message = request.getMessage();
    }
        
}
