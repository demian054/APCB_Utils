/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.entities;

import com.google.gson.Gson;

/**
 *
 * @author Demian
 */
public class Beam {
    String objectStr;
    String objectType;

    public Beam(){
    }

    public Beam(String objectStr, String objectType) {
        this.objectStr = objectStr;
        this.objectType = objectType;
    }
    
     /*   
    public static class BeamSerializer implements JsonSerializer<Beam> {
        @Override
        public JsonElement serialize(Beam beam, Type typeOfSrc, JsonSerializationContext context) {
            
            try {
                //Class<beam.getObjectType().getClass()> obj = beam.getObjectType().newInstance();
                Class.forName(beam.getObjectType()).newInstance();
            
            beam.getObjectType().
            final JsonElement jsonObject = context.serialize();
            final JsonElement jsonClass = context.serialize(beam.getAuthorsIds());
            } catch (Exception ex) {
                Logger.getLogger(Beam.class.getName()).log(Level.SEVERE, null, ex);
            }
    jsonObject.add("authors", jsonAuthros);
            return null;//new JsonPrimitive(src.jsonString);
        }

    }
    */

    public String getObjectStr() {
        return objectStr;
    }

    public void setObjectStr(String objectStr) {
        this.objectStr = objectStr;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
    
}


