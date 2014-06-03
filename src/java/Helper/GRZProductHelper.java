/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author edista
 */
public class GRZProductHelper {
    public static float getMinPrice(int priceFilter){
        float minRange = 0;
        
        switch(priceFilter){
            case 0 : {
                minRange = 0;
            }break;
            case 1 : {
                minRange = 0;
            }break;
            case 2 : {
                minRange = 35000;
            }break;
            case 3 : {
                minRange = 70000;
            }break;
            case 4 : {
                minRange = 105000;
            }break;
            case 5 : {
                minRange = 140000;
            }
        }
        return minRange;
    }
    
    public static float getMaxPrice(int priceFilter){
        float maxRange = 999999;
        
        switch(priceFilter){
            case 0 : {
                maxRange = 999999;
            }break;
            case 1 : {
                maxRange = 35000;
            }break;
            case 2 : {
                maxRange = 70000;
            }break;
            case 3 : {
                maxRange = 105000;
            }break;
            case 4 : {
                maxRange = 140000;
            }break;
            case 5 : {
                maxRange = 999999;
            }
        }
        return maxRange;
    }
}
