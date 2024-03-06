/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.validator;

import domain.Article;

/**
 *
 * @author Veljko
 */
public class Validator {
    
    private static Validator instance;
    

    private Validator() {
        
    }
    

    public static Validator getInstance() {
        if(instance==null){
            instance=new Validator();
        }
        return instance;
    }
    
    public boolean isEmpty(String string){
        if(string.isEmpty() || string.isBlank()){
            return true;
        }
        return false;
    }
    
    public boolean isValidEmail(String string){
        if(!string.contains("@") || !string.contains(".")){
            return true;
        }
        
        if(string.indexOf('@')>string.indexOf('.')){
            return true;
        }
        
        if(string.indexOf('@')==0 || string.indexOf('.')==string.length()-1 || string.indexOf('@')-string.indexOf('.')==1){
            return true;
        }
        
        return false;
    }
    
    public boolean isDouble(Object object){
        try {
            Double.parseDouble(object.toString());
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }
    
    public boolean isGreaterThanThreshold(int value, int threshold){
        if(value<threshold){
            return true;
        }
        return false;
    }
    
   
    
}
