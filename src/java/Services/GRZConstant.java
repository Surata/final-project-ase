package Services;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edista
 */
public class GRZConstant {
    
    static String USER_SEARCH_QUERY(String username, String password){
        return "from GRZUser where username = '"+ username +"' AND password = '"+ password +"'";
    }
    
    static String USER_SEARCH_BY_ID_QUERY(int id){
        return "from GRZUser where id =" + id;
    }
}
