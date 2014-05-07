/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Bean.GRZUser;
import Controller.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author edista
 */
public class GRZUserService {
    private Session sess;
    private Transaction tr;
    private List users;
    
    public GRZUserService() {
        sess = HibernateUtil.getSessionFactory().openSession();   
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
}
