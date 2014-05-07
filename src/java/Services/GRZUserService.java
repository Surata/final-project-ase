/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Bean.GRZUser;
import java.util.List;

/**
 *
 * @author edista
 */
public class GRZUserService extends GRZService {
    
    public GRZUserService() {
        sess = getSession();
    }

    public void insert(String username,
                       String password,
                       String name,
                       String email,
                       String phone,
                       String address,
                       String status){
        
        GRZUser user = new GRZUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setStatus(status);
        
        tr = sess.beginTransaction();
        tr.begin();
        sess.save(user);
        tr.commit();
    }
    
    public List selectAll(){
        tr = sess.beginTransaction();
        results = sess.createQuery(GRZConstant.USER_SELECT_ALL_QUERY).list();
        return results;
    }
    
    public GRZUser selectWithId(int id){

        tr = sess.beginTransaction();
        results = sess.createQuery(GRZConstant.USER_SELECT_WITH_ID_QUERY(id)).list();
        if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        
        return null;
    }
    
    public GRZUser select(String username, String password){

        tr = sess.beginTransaction();
        results = sess.createQuery(GRZConstant.USER_SELECT_QUERY(username, password)).list();
        if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
        
    }
    
    public GRZUser selectWithUsername(String username){
        tr = sess.beginTransaction();
        results =  sess.createQuery(GRZConstant.USER_SELECT_WITH_USERNAME(username)).list();
         if(results.size()>0){
            GRZUser user = (GRZUser)results.get(0);
            return user;
        }
        return null;
    }
}
