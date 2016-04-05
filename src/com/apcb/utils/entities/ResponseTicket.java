/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_PassengerDetail;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;

/**
 *
 * @author Demian
 */
public class ResponseTicket {
    private APCB_PassengerDetail passengerDetail; 
    private String sesionId;
    private Message message;
    private Message[] warninig;

    public ResponseTicket(String sesionId) {
        this.sesionId = sesionId;
        this.message = new Message(MessagesTypeEnum.Ok);
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

    public Message[] getWarninig() {
        return warninig;
    }

    public void setWarninig(Message[] warninig) {
        this.warninig = warninig;
    }

    public APCB_PassengerDetail getPassengerDetail() {
        return passengerDetail;
    }

    public void setPassengerDetail(APCB_PassengerDetail passengerDetail) {
        this.passengerDetail = passengerDetail;
    }
    
}
