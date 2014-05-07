/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.GRZUser;
import Services.GRZUserService;
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
    
    public void checkUser(HttpSession session, HttpServletResponse response) throws IOException{
        if(session.getAttribute("user") == null){
            response.sendRedirect("index.jsp");
        }else{
            GRZUser currentUser = (GRZUser)session.getAttribute("user");
            if(currentUser.getStatus().equals("member")){
                response.sendRedirect("index.jsp");
            }
        }
    }
    
    public void checkCookie(ServletContext app,HttpSession session, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies != null){
            for(int i=0; i<cookies.length ;i++){
                cookie = cookies[i];
                if(cookie.getName().equals("GRZUser")){
                    GRZUserService userService = new GRZUserService();
                    GRZUser user = userService.selectWithUsername(cookie.getValue());
                    if(user != null){
                        session.setAttribute("user", user);
                    }
                }
            }
        }
    }
    
}
