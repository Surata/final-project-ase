/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BaseClass.GRZService;
import Constants.GRZConstant;
import Bean.GRZProduct;
import java.util.List;

/**
 *
 * @author edista
 */
public class GRZProductService extends GRZService {
    public static Boolean insert(String name,
                       String description,
                       float price,
                       String image){
        
        GRZProduct product = new GRZProduct(name, description, price, image);
        try{
            tr.begin();
            sess.save(product);
            tr.commit();
            return true;
        }catch(Exception e){
            tr.rollback();
            return false;
        }
    }
    
    public static List selectAll(){
        results = getListFromQuery(GRZConstant.PRODUCT_SELECT_ALL_QUERY);
        return results;
    }
    
    public static List selectWithPrice(int priceRange){
        float minRange = getMinPrice(priceRange);
        float maxRange = getMaxPrice(priceRange);
  
        results = getListFromQuery(GRZConstant.PRODUCT_SELECT_WITH_PRICE_QUERY(minRange, maxRange));
        return results;
    }
    
    public static List selectWithNameLike(String name){
        results = getListFromQuery(GRZConstant.PRODUCT_SELECT_WITH_NAME_LIKE_QUERY(name));
        return results;
    }
    
    public static List selectWithNameAndPrice(String name, int priceRange){
        float minRange = getMinPrice(priceRange);
        float maxRange = getMaxPrice(priceRange);

        results = getListFromQuery(GRZConstant.PRODUCT_SELECT_WITH_NAME_AND_PRICE_QUERY(name, minRange, maxRange));  
        return results;
    }
    
    private static float getMinPrice(int priceFilter){
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
    
    private static float getMaxPrice(int priceFilter){
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
