/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BaseClass.GRZService;
import Constants.GRZConstant;
import Bean.GRZUser;
import java.util.List;

/**
 *
 * @author edista
 */
public class GRZUserService extends GRZService {

    public static void insert(String username,
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
        //try{
            tr.begin();
            sess.save(user);
            tr.commit();
       // }catch(Exception e){
        //    tr.rollback();
        //}
    }
    
    public static List selectAll(){
        results = getListFromQuery(GRZConstant.USER_SELECT_ALL_QUERY);
        return results;
    }
    
    public static GRZUser selectWithId(int id){
        results = getListFromQuery(GRZConstant.USER_SELECT_WITH_ID_QUERY(id));
        if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
    
    public static GRZUser select(String username, String password){
        results = getListFromQuery(GRZConstant.USER_SELECT_QUERY(username, password));
        if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
    
    public static GRZUser selectWithUsername(String username){
        results =  getListFromQuery(GRZConstant.USER_SELECT_WITH_USERNAME(username));
         if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
}
