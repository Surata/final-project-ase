/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Bean.GRZOrder;
import Bean.GRZProduct;
import Bean.GRZTransaction;
import Bean.GRZUser;
import Constants.GRZConstant;
import Helper.GRZProductHelper;
import java.util.List;

/**
 *
 * @author edista
 */
public class GRZService {
    private GRZAdapter adapter; 
    private List results;
    
    public GRZService() {
        adapter = new GRZAdapter();
    }
    
    //User
    
    public Boolean setUser(String username,
                              String password,
                              String name,
                              String email,
                              String phone,
                              String address,
                              String status){
        
        GRZUser user = new GRZUser(username, 
                                   password, 
                                   name, 
                                   email, 
                                   phone, 
                                   address, 
                                   status);
        
        return adapter.doInsert(user);
    }
    
    public List getAllUser(){
        return adapter.doSelect(GRZConstant.USER_SELECT_ALL_QUERY);
    }
    
    public GRZUser getUserWithId(int id){
        results = adapter.doSelect(GRZConstant.USER_SELECT_WITH_ID_QUERY(id));
        
        if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
    
    public GRZUser loginUser(String username, String password){
        results = adapter.doSelect(GRZConstant.USER_SELECT_QUERY(username, password));
        if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
    
    public GRZUser selectWithUsername(String username){
        results =  adapter.doSelect(GRZConstant.USER_SELECT_WITH_USERNAME(username));
         if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
   
    //Product
    
    public Boolean setProduct(String name,
                       String description,
                       float price,
                       String image){
        
        GRZProduct product = new GRZProduct(name, description, price, image);
        
        return adapter.doInsert(product);
    }
    
    public List getAllProduct(){
        results = adapter.doSelect(GRZConstant.PRODUCT_SELECT_ALL_QUERY);
        return results;
    }
    
    public GRZProduct getProductWithId(int id){
        results = adapter.doSelect(GRZConstant.PRODUCT_SELECT_WITH_ID_QUERY(id));
        if(results.size()>0){
            GRZProduct product = (GRZProduct)results.get(0);
            return product;
        }
        return null;
    }
    
    public List getProductForPriceRange(int priceRange){
        float minRange = GRZProductHelper.getMinPrice(priceRange);
        float maxRange = GRZProductHelper.getMaxPrice(priceRange);
  
        results = adapter.doSelect(GRZConstant.PRODUCT_SELECT_WITH_PRICE_QUERY(minRange, maxRange));
        return results;
    }
    
    public List searchProductWithNameKey(String name){
        results = adapter.doSelect(GRZConstant.PRODUCT_SELECT_WITH_NAME_LIKE_QUERY(name));
        return results;
    }
    
    public List searchProdcutWithNameAndPriceKey(String name, int priceRange){
        float minRange = GRZProductHelper.getMinPrice(priceRange);
        float maxRange = GRZProductHelper.getMaxPrice(priceRange);

        results = adapter.doSelect(GRZConstant.PRODUCT_SELECT_WITH_NAME_AND_PRICE_QUERY(name, minRange, maxRange));  
        return results;
    }
    
    //order
    
    public Boolean setOrder(int productID, int quantity, float subTotal, int transactionID){
        GRZOrder order = new GRZOrder(productID, quantity, subTotal, transactionID);
        
        return adapter.doInsert(order);
    }
    
    public GRZOrder getOrderWithId(int id){
        results = adapter.doSelect(GRZConstant.ORDER_SELECT(id));
        if(results.size()>0){
            return (GRZOrder)results.get(0);
        }
        return null;
    }
    
    public List getOrderWithTransactionId(int transactionID){
        results = adapter.doSelect(GRZConstant.ORDER_SELECT_WITH_TRANSACTION(transactionID));
        return results;
    }
    
    public List getOrderWithUserId(int userID){
        results = adapter.doSelect(GRZConstant.ORDER_SELECT_WITH_USER(userID));
        return results;
    }
    
    public Boolean removeOrderWithId(int id){
        return adapter.doDelete(GRZConstant.ORDER_DELETE(id));
    }
    
    public Boolean removeAllOrderWithUserId(int userID){
        return adapter.doDelete(GRZConstant.ORDER_DELETE_ALL_WITH_USER_ID(userID));
    }
    
    //transaction
    
    public Boolean setTransaction(int userID, float total, int status, String date){
        GRZTransaction transaction = new GRZTransaction(userID, total, status, date);
        return adapter.doInsert(transaction);
    }
    
    public GRZTransaction getLastTransactionWithUserId(int userID){
        results = adapter.doSelect(GRZConstant.TRANSACTION_SELECT_WITH_USER(userID));
        if(results.size()>0){
            return (GRZTransaction)results.get(0);
        }else{
            GRZTransaction transaction = new GRZTransaction(userID, 0, 0, "");
            Boolean success = adapter.doInsert(transaction);
            if(success)
                return transaction;
            else return null;
        }   
    }
    
    public List getAllTransactionWithUserId(int userID){
        results = adapter.doSelect(GRZConstant.TRANSACTION_SELECT_ALL_WITH_USER(userID) );
        return results;
    }
    
    public Boolean changeTransaction(int userID, float total, int status, String date){
        GRZTransaction transaction = getLastTransactionWithUserId(userID);
        transaction.setUserID(userID);
        transaction.setDate(date);
        transaction.setTotal(total);
        transaction.setStatus(status);
        
        return adapter.doUpdate(transaction);
    }
}
