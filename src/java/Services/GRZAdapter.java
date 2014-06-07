/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Helper.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author edista
 */
public class GRZAdapter {
    protected static Session sess;
    protected static Transaction tr;
    protected static List results;

    public GRZAdapter() {
        sess = HibernateUtil.getSessionFactory().openSession();  
        tr = sess.beginTransaction();
    }
  
    public Boolean doInsert(Object o){
        try{
            tr.begin();
            sess.save(o);
            tr.commit();
            return true;
        }catch(Exception e){
            tr.rollback();
            return true;
        }
    }
    
    public List doSelect(String query){
        try{
            List objects = sess.createQuery(query).list();
            return objects;
        }catch(Exception e){
            return null;
        }
    }
    
    public Boolean doUpdate(Object o){
        try{
            tr.begin();
            sess.update(o);
            tr.commit();
            return true;
        }catch(Exception e){
            tr.rollback();
            return false;
        }
    }
    
    public Boolean doDelete(String query){
        try{
            tr.begin();
            sess.createQuery(query).executeUpdate();
            tr.commit();
            return true;
        }catch(Exception e){
            tr.rollback();
            return false;
        }
    }
}
