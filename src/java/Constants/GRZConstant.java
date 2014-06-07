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
    
    public static String PRODUCT_ADD_PAGE = "GRZInsertProduct.jsp";
    public static String PRODUCT_LIST_PAGE = "GRZProduct.jsp";
    public static String HOME_PAGE = "index.jsp";
    public static String USER_ADD_PAGE = "GRZRegister.jsp";
    public static String CUSTOMER_PAGE = "GRZCustomer.jsp";
    public static String MENU_PAGE = "GRZMenu.jsp";
    public static String ORDER_PAGE = "GRZOrder.jsp";
    public static String CART_PAGE = "GRZCart.jsp";
    public static String TRACK_PAGE = "GRZTrack.jsp";
    public static String PRODUCT_UPDATE_PAGE = "GRZUpdateProduct.jsp";
    public static String USER_UPDATE_PAGE = "GRZUpdateUser.jsp";
    public static String TRANSACTION_PAGE = "GRZTransaction.jsp";
    
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
    
    public static String USER_SELECT_LIKE(String key){
        return "from GRZUser where username like '%" +key +"%'";
    }
    
    public static String USER_DELETE_WITH_ID(int userID){
        return "delete from GRZUser where id=" + userID;
    }
    
    
    //GRZProduct
    //Query for product
    public static String PRODUCT_SELECT_ALL_QUERY = "from GRZProduct ORDER BY id DESC";
    public static String PRODUCT_SELECT_WITH_ID_QUERY(int id){
        return "from GRZProduct where id = " + id;
    }
    public static String PRODUCT_SELECT_WITH_PRICE_QUERY(float min, float max){
        return "from GRZProduct where price between " + min + "and" + max + "ORDER BY id DESC";
    }
    public static String PRODUCT_SELECT_WITH_NAME_LIKE_QUERY(String name){
        return "from GRZProduct where name like '%" + name + "%'" + "ORDER BY id DESC";
    }
    public static String PRODUCT_SELECT_WITH_NAME_AND_PRICE_QUERY(String name, float min, float max){
        return "from GRZProduct where name like '%" + name + "%' and price between " + min + " and " + max + "ORDER BY id DESC";
    }
    public static String PRODUCT_DELETE_WITH_ID(int productID){
        return "delete from GRZProduct where id=" + productID;
    }
    
    //Order
    
    public static String ORDER_SELECT_ALL = "from GRZOrder";
    public static String ORDER_SELECT_WITH_USER(int userID){
        return "from GRZOrder where transactionID = "
                + "(SELECT transactionID from GRZTransaction where status = 0 and userID =" + userID +")";
    }
    public static String ORDER_SELECT(int id){
        return "from GRZOrder where id =" + id;
    }
    
    public static String ORDER_DELETE(int id){
        return "delete from GRZOrder where id =" + id;
    }
    
    public static String ORDER_DELETE_ALL_WITH_USER_ID(int userID){
        return "delete from GRZOrder where transactionID = "
                + "(SELECT transactionID from GRZTransaction where status = 0 and userID =" + userID +")";
    }
    
    public static String ORDER_SELECT_WITH_TRANSACTION(int transactionID){
        return "from GRZOrder where transactionID =" +transactionID;
    }
    
    //Transaction
    
    public static String TRANSACTION_SELECT_ALL = "from GRZTransaction where status > 0 ORDER BY id DESC";
    public static String TRANSACTION_SELECT_WITH_ID(int id){
        return "from GRZTransaction where transactionID =" +id;
    }
    public static String TRANSACTION_SELECT_WITH_USER(int userID){
        return "from GRZTransaction where userID="+ userID + "and status=0";
    }
    public static String TRANSACTION_SELECT_ALL_WITH_USER(int userID){
        return "from GRZTransaction where userID=" + userID + "and status > 0";
    }
}
