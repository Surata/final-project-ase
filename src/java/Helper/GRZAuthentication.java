/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Bean.GRZUser;
import Constants.GRZConstant;
import Services.GRZService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edista
 */
public class GRZAuthentication {

    public GRZAuthentication() {
    }
    
    public void onlyAdmin(HttpSession session, HttpServletResponse response) throws IOException{
        if(session.getAttribute("user") == null){
            response.sendRedirect(GRZConstant.HOME_PAGE);
        }else{
            GRZUser currentUser = (GRZUser)session.getAttribute("user");
            if(currentUser.getStatus().equals("member")){
                response.sendRedirect(GRZConstant.HOME_PAGE);
            }
        }
    }
    
    public void allowMember(HttpSession session, HttpServletResponse response) throws IOException{
        if(session.getAttribute("user") == null){
            response.sendRedirect(GRZConstant.HOME_PAGE);
        }
    }
    
    public void checkCookie(ServletContext app,HttpSession session, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies != null){
            for(int i=0; i<cookies.length ;i++){
                cookie = cookies[i];
                if(cookie.getName().equals("GRZUser")){
                    GRZService service = new GRZService(); 
                    GRZUser user = service.selectWithUsername(cookie.getValue());
                    if(user != null){
                        session.setAttribute("user", user);
                    }
                }
            }
        }
    }
    
}
