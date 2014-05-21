/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controller.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author edista
 */
public class GRZService {
    
    protected Session sess;
    protected Transaction tr;
    protected List results;

    public GRZService() {
    }
    
    protected Session getSession(){
        return HibernateUtil.getSessionFactory().openSession();   
    }
    
}
