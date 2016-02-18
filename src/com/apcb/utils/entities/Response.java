/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.paymentHandler.entities.PayMainResponse;
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;
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
    private PayMainResponse payMainResponse;

    public Response() {
        message = new Message(MessagesTypeEnum.Ok);
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
    
    public List<Message> getWarninig() {
        return warninig;
    }

    public void setWarninig(List<Message> warninig) {
        this.warninig = warninig;
    }

    public PayMainResponse getPayMainResponse() {
        return payMainResponse;
    }

    public void setPayMainResponse(PayMainResponse payMainResponse) {
        this.payMainResponse = payMainResponse;
    }
    
    
 
}
