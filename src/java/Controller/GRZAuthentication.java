/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.GRZUser;
import java.io.IOException;
import java.sql.ResultSet;
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
                    GRZUser user = new GRZUser();
                    ResultSet rs = user.searchForUsername(app,cookie.getValue());
                    try {
                        if(rs.next()){
                            user.setUsername(rs.getString("Username"));
                            user.setName(rs.getString("Name"));
                            user.setStatus(rs.getString("Status"));
                            session.setAttribute("user", user);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(GRZAuthentication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
}
