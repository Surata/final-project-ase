/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Bean.GRZTransaction;
import Bean.GRZUser;
import Services.GRZTransactionService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edista
 */
public class GRZApplicationHelper {
    public static GRZUser getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        GRZUser user = (GRZUser)session.getAttribute("user");
        return user;
    }
    
    public static String getDate() {
        String time = new SimpleDateFormat("YYYY-MM-dd hh:mm").format(Calendar.getInstance().getTime());
        return time;
    }
    
    public static GRZTransaction getLastTransactionWithUserID(int userID){
        GRZTransaction transaction = GRZTransactionService.selectLastTransactionID(userID);
        int transactionID;
        if(transaction == null){
            GRZTransactionService.insert(userID, 0, 0, "");
            transaction = GRZTransactionService.selectLastTransactionID(userID);
        }
        return transaction;        
    }
}
