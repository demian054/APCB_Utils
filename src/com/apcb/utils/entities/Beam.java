/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

/**
 *
 * @author Demian
 */
public class Beam {
    Object object;
    Class objectType;

    public Beam() {
    }

    public Beam(Object object, Class objectType) {
        this.object = object;
        this.objectType = objectType;
    }
    
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Class getObjectType() {
        return objectType;
    }

    public void setObjectType(Class objectType) {
        this.objectType = objectType;
    }
    
    
}
