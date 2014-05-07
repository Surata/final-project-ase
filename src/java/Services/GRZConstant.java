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
    
    //GRZUser
    //Query for user
    static String USER_SELECT_ALL_QUERY = "from GRZUser";
    static String USER_SELECT_QUERY(String username, String password){
        return "from GRZUser where username = '"+ username +"' AND password = '"+ password +"'";
    }
    static String USER_SELECT_WITH_ID_QUERY(int id){
        return "from GRZUser where id = " + id;
    }
    static String USER_SELECT_WITH_USERNAME(String username){
        return "from GRZUser where username = '"+ username +"'";
    }
    
    
    //GRZProduct
    //Query for product
    static String PRODUCT_SELECT_ALL_QUERY = "from GRZProduct";
    static String PRODUCT_SELECT_WITH_PRICE_QUERY(float min, float max){
        return "from GRZProduct where price between " + min + "and" + max;
    }
    static String PRODUCT_SELECT_WITH_NAME_LIKE_QUERY(String name){
        return "from GRZProduct where name like '%" + name + "%'";
    }
    static String PRODUCT_SELECT_WITH_NAME_AND_PRICE_QUERY(String name, float min, float max){
        return "from GRZProduct where name like '%" + name + "%' and price between " + min + " and " + max;
    }
}
