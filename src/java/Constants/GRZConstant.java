package Constants;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edista
 */
public class GRZConstant {
    
    public static String PRODUCT_ADD_PAGE = "GRZInserProduct.jsp";
    public static String PRODUCT_LIST_PAGE = "GRZProduct.jsp";
    
    public static String HOME_PAGE = "index.jsp";
    
    public static String USER_ADD_PAGE = "GRZRegister.jsp";
    
    //GRZUser
    //Query for user
    public static String USER_SELECT_ALL_QUERY = "from GRZUser";
    public static String USER_SELECT_QUERY(String username, String password){
        return "from GRZUser where username = '"+ username +"' AND password = '"+ password +"'";
    }
    public static String USER_SELECT_WITH_ID_QUERY(int id){
        return "from GRZUser where id = " + id;
    }
    public static String USER_SELECT_WITH_USERNAME(String username){
        return "from GRZUser where username = '"+ username +"'";
    }
    
    
    //GRZProduct
    //Query for product
    public static String PRODUCT_SELECT_ALL_QUERY = "from GRZProduct";
    public static String PRODUCT_SELECT_WITH_PRICE_QUERY(float min, float max){
        return "from GRZProduct where price between " + min + "and" + max;
    }
    public static String PRODUCT_SELECT_WITH_NAME_LIKE_QUERY(String name){
        return "from GRZProduct where name like '%" + name + "%'";
    }
    public static String PRODUCT_SELECT_WITH_NAME_AND_PRICE_QUERY(String name, float min, float max){
        return "from GRZProduct where name like '%" + name + "%' and price between " + min + " and " + max;
    }
}
