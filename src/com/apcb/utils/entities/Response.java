/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Demian
 */
public class Response {
    private Beam beam;
    private String sesionId;
    private Message message;
    private List<Message> warninig;

    public Response() {
    }

    /*
    public <T> T getObjectBean() throws ClassNotFoundException{
    return (T) new Gson().fromJson(beam.getObject(), Class.forName(beam.getObjectType()).getClass());  
    }
    public void setBeam(Object objectStr, Class objectType) {
    Beam beam = new Beam();
    beam.setObject(new Gson().toJson(objectStr));
    beam.setObjectType(objectType.getName());
    this.beam = beam;
    }*/
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
    
    public List<Message> getWarninig() {
        return warninig;
    }

    public void setWarninig(List<Message> warninig) {
        this.warninig = warninig;
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
