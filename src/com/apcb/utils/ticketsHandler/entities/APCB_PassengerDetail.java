/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.enums.DocumentTypeEnum;

/**
 *
 * @author Demian
 */
public class APCB_PassengerDetail {
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String documentID;
    private DocumentTypeEnum documentType;
    private String custLoyaltyProgramID;   
    private String custLoyaltyMembershipID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }

    public String getCustLoyaltyProgramID() {
        return custLoyaltyProgramID;
    }

    public void setCustLoyaltyProgramID(String custLoyaltyProgramID) {
        this.custLoyaltyProgramID = custLoyaltyProgramID;
    }

    public String getCustLoyaltyMembershipID() {
        return custLoyaltyMembershipID;
    }

    public void setCustLoyaltyMembershipID(String custLoyaltyMembershipID) {
        this.custLoyaltyMembershipID = custLoyaltyMembershipID;
    }
    
    
    
}
