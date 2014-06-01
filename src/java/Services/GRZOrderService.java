/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BaseClass.GRZService;
import Bean.GRZOrder;
import Bean.GRZProduct;
import Constants.GRZConstant;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author edista
 */
public class GRZOrderService extends GRZService{
    public static void insert(int productID, int quantity, float subTotal, int transactionID){
        GRZOrder order = new GRZOrder(productID, quantity, subTotal, transactionID);
        try{
            tr.begin();
            sess.save(order);
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
    }
    
    public static GRZOrder select(int id){
        results = getListFromQuery(GRZConstant.ORDER_SELECT(id));
        if(results.size()>0){
            return (GRZOrder)results.get(0);
        }
        return null;
    }
    
    public static List selectWithTransactionID(int transactionID){
        results = getListFromQuery(GRZConstant.ORDER_SELECT_WITH_TRANSACTION(transactionID));
        return results;
    }
    
    public static List selectWithUserID(int userID){
        results = getListFromQuery(GRZConstant.ORDER_SELECT_WITH_USER(userID));
        return results;
    }
    
    public static GRZProduct product(int id){
        return GRZProductService.select(id);
    }
    
    public static void delete(int id){
        GRZOrder order = select(id);
        try{
            tr.begin();
            sess.delete(order);
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
    }
    
    public static void deleteAllWithUser(int userID){
        try{
            tr.begin();
            Query query = sess.createQuery(GRZConstant.ORDER_DELETE_ALL_WITH_USER(userID));
            query.executeUpdate();
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
    }
}
