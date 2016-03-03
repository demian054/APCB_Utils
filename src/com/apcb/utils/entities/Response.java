/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Demian
 */
public class Response {
    private APCB_Travel travelInfo;
    private String sesionId;
    private Message message;
    private List<Message> warninig;
    private APCB_PayMain payMainInfo;

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

    public Response() {
        message = new Message(MessagesTypeEnum.Ok);
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

 
}
