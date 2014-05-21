/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseClass;

import Helper.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author edista
 */
public class GRZService {
    
    protected static Session sess;
    protected static Transaction tr;
    protected static List results;
    
    static {
        sess = getSession();
        tr = sess.beginTransaction();
    }

    public GRZService() {
    }
    
    protected static Session getSession(){
        return HibernateUtil.getSessionFactory().openSession();   
    }
    
    protected static List getListFromQuery(String query){
        return sess.createQuery(query).list();
    }
    
}
