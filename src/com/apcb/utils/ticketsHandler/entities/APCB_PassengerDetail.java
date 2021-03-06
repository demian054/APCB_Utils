/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.entities;

import com.apcb.utils.ticketsHandler.enums.NamePrefixTypeEnum;
import com.apcb.utils.enums.TimeTypeEnum;
import com.apcb.utils.enums.DocumentTypeEnum;

/**
 *
 * @author Demian
 */
public class APCB_PassengerDetail {
    private NamePrefixTypeEnum namePrefix;
    private String name;
    private String surname;
    private String middleName;
    private String telephone;
    private String telephoneHome;
    private String email;
    private String documentID;
    private DocumentTypeEnum documentType;
    private String custLoyaltyProgramID;   
    private String custLoyaltyMembershipID;
    private String documentNationality;
    private String age;
    private TimeTypeEnum ageType;
    
    private String ticketNumber;
    private String ticket;
    private APCB_Cost detailCost;

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

    public String getDocumentNationality() {
        return documentNationality;
    }

    public void setDocumentNationality(String documentNationality) {
        this.documentNationality = documentNationality;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public TimeTypeEnum getAgeType() {
        return ageType;
    }

    public void setAgeType(TimeTypeEnum ageType) {
        this.ageType = ageType;
    }

    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    public NamePrefixTypeEnum getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(NamePrefixTypeEnum namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
    public APCB_Cost getDetailCost() {
        return detailCost;
    }

    public void setDetailCost(APCB_Cost detailCost) {
        this.detailCost = detailCost;
    }

    @Override
    public boolean equals(Object obj) {
        //if (obj.getClass().isInstance(APCB_PassengerDetail.class)){
        try {
            APCB_PassengerDetail aPCB_PassengerDetail = (APCB_PassengerDetail) obj;
            if (aPCB_PassengerDetail.getName().equalsIgnoreCase(this.getName())
                && (aPCB_PassengerDetail.getMiddleName() == null || aPCB_PassengerDetail.getMiddleName().equalsIgnoreCase(this.getMiddleName()))
                && aPCB_PassengerDetail.getSurname().equalsIgnoreCase(this.getSurname())
                && (aPCB_PassengerDetail.getNamePrefix() == null || aPCB_PassengerDetail.getNamePrefix().equals(this.getNamePrefix()))){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    
    
}
