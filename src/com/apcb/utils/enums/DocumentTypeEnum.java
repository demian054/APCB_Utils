/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.enums;

import com.apcb.utils.ticketsHandler.enums.PassangerTypeEnum;

/**
 *
 * @author Demian
 */
public enum DocumentTypeEnum {
    
    Cedula         ("NI"),
    Pasaporte      ("PP");
    
    private final String code; 
 
    DocumentTypeEnum (String description) { 
        this.code = description;
    }

    public String getCode() { return code; }
    
    public static DocumentTypeEnum getByCode(String code){
        for (DocumentTypeEnum documentTypeEnum:DocumentTypeEnum.values()){
            if (documentTypeEnum.getCode().equals(code)){
                return documentTypeEnum;
            }
        }
        return null;
    }
    
}
