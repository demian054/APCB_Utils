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
public enum MealCodeEnum {
    
    Breakfast  ("Desayuno","B"),
    Snack  ("Refrigerio","S"),
    Dinner  ("Cena","D"),
    HotMeal  ("Comida Caliente","H"),
    Lunch  ("Almuerzo","L"),
    Refreshments  ("Refrescos","R"), 
    Complimentaryliquor  ("Alcohol de Cortesía","C"), 
    Meal  ("Comida","M"), 
    LiquorForPurchase  ("Alcohol disponible para la venta","P"), 
    FoodForPurchase  ("Comida disponible para la venta","F"), 
    ColdMeal  ("Comida Fría","O"),
    NoMeals ("Sin servicio de comida","-");
     
    private final String code; 
    private final String description; 
 
    MealCodeEnum (String code, String description) { 
        this.code = code;
        this.description = description;
    }
    
    public String getCode() { return code; }
    public String getDescription() { return description; }
    
    public static String getDescriptionByCode(String code){
        for (MealCodeEnum mealCodeEnum: MealCodeEnum.values()){
            if (mealCodeEnum.getCode().equalsIgnoreCase(code)){
                return mealCodeEnum.getDescription();
            } 
        }
        return MealCodeEnum.NoMeals.getDescription();
    }
       
}
