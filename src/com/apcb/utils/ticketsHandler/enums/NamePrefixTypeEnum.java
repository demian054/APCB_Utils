package com.apcb.utils.ticketsHandler.enums;

/**
 *
 * @author Demian
 */
public enum NamePrefixTypeEnum {

    MR       ("MR"),
    MRS      ("MRS"),
    MSS      ("MSS"),
    JR       ("JR"),
    KNOW     ("KNOW");
    
    private final String code; 
 
    NamePrefixTypeEnum (String description) { 
        this.code = description;
    }

    public String getCode() { return code; }
    
    public static NamePrefixTypeEnum getByCode(String code){
        for (NamePrefixTypeEnum namePrefixTypeEnum:NamePrefixTypeEnum.values()){
            if (namePrefixTypeEnum.getCode().equals(code)){
                return namePrefixTypeEnum;
            }
        }
        return NamePrefixTypeEnum.KNOW;
    }
    
}
