/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BaseClass.GRZService;
import Bean.GRZTransaction;
import Constants.GRZConstant;
import Helper.GRZApplicationHelper;
import java.util.List;

/**
 *
 * @author edista
 */
public class GRZTransactionService extends GRZService{
    public static void insert(int userID, float total, int status, String date){
        GRZTransaction transaction = new GRZTransaction(userID, total, status, date);
        try{
            tr.begin();
            sess.save(transaction);
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
    }
    
    public static void update(int userID, float total, int status, String date){
        GRZTransaction transaction = GRZApplicationHelper.getLastTransactionWithUserID(userID);
        transaction.setUserID(userID);
        transaction.setDate(date);
        transaction.setTotal(total);
        transaction.setStatus(status);
        
        try{
            tr.begin();
            sess.update(transaction);
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
    }
    
    public static List select(int userID){
        results = getListFromQuery(GRZConstant.TRANSACTION_SELECT_WITH_USERID(userID));
        return results;
    }
    
    public static GRZTransaction selectLastTransactionID(int userID){
        results = getListFromQuery(GRZConstant.TRANSACTION_SELECT_WITH_USER(userID) );
        if(results.size()>0){
            GRZTransaction transaction = (GRZTransaction)results.get(0);
            return transaction;
        }
        return null;
    }
}
