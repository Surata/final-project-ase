/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author edista
 */
public class GRZValidationUtil {

    public GRZValidationUtil() {
    }
    
    public boolean validateEmptyText(String str){
        if(str.equals("") || str == null){
            return false;
        }
        return true;
    }
    
    public boolean validateMinLongText(String str, int min){
        if(str.length() < min)
            return false;
        
        return true;
    }
    
    public boolean validateNumber(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public boolean validateAlphabet(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public boolean validateAlpnum(String str){
        for(int i = 0; i< str.length(); i++){
            if(validateNumber(str) || validateAlphabet(str))
                return false;
        }
        return true;
    }
    
    public boolean validateEmail(String str){
        int valid = 0; 
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == '@'){
                valid = 1;
            }else if(valid == 1 && str.charAt(i) == '.'){
                valid = 2;
            }
        }
        if(valid == 2)
            return true;
        return false;
    }
}
