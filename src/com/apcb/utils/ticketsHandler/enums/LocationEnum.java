/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.ticketsHandler.enums;

/**
 *
 * @author Demian
 */
public enum LocationEnum {
    
        CCS ("CCS","CARACAS"), 
        BRM ("BRM","BARQUISIMETO"), 
	CUM ("CUM","CUMANA"), 
	LSP ("LSP","LAS PIEDRAS"), 
        MAR ("MAR","MARACAIBO"), 
	MUN ("MUN","MATURIN"), 
	PMV ("PMV","PORLAMAR"), 
	PBL ("PBL","PUERTO CABELLO"), 
	POS ("POS","PUERTO ESPAÑA"), 
	PZO ("PZO","PUERTO ORDAZ"), 
	VLN ("VLN","VALENCIA"), 
	PTY ("PTY","PANAMA");
 
    private final String code; 
    private final String description; 
 
    LocationEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public static LocationEnum getByCode(String code){
        for (LocationEnum cocationEnum:LocationEnum.values()){
            if (cocationEnum.getCode().equals(code)){
                return cocationEnum;
            }
        }
        return null;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
       
}
