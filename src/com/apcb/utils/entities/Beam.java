/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sun.corba.se.spi.presentation.rmi.PresentationManager.ClassData;
import java.lang.reflect.Type;

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
    
    public static class BeamSerializer implements JsonSerializer<Beam> {
        @Override
        public JsonElement serialize(Beam src, Type typeOfSrc, JsonSerializationContext context) {
            
            return null;//new JsonPrimitive(src.jsonString);
        }

    }
    
    
}


