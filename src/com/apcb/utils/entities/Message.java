/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.apcb.utils.ticketsHandler.Enums.MessagesTypeEnum;

/**
 *
 * @author Demian
 */
public class Message {
    private String msgCode;
    private String msgDesc;

    public Message() {
    }
    
    public Message(MessagesTypeEnum MessagesType) {
        this.msgCode = MessagesType.getCode();
        this.msgDesc = MessagesType.getDescription();   
    }
    
    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }
    
    public MessagesTypeEnum getMessagesType(String msgCode, String msgDesc){
        return MessagesTypeEnum.getMessagesType(msgCode, msgDesc); 
    }  
}
