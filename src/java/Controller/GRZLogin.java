/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.GRZUser;
import Services.GRZUserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author edista
 */
public class GRZLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("usernameTxt");
        String password = request.getParameter("passwordTxt");
        String[] rememberMe = request.getParameterValues("rememberMeChk");
        
        ServletContext app = getServletContext();
        GRZUserService userService = new GRZUserService();
        GRZUser user = userService.select(username, password);
        
        try {
            if(user != null){
                
                if(app.getAttribute("userCount") == null){
                    app.setAttribute("userCount", 1);
                }else {
                    increaseUserCount(app);
                }
                
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
         
                if(rememberMe != null){
                    Cookie cookie = new Cookie("GRZUser",user.getUsername());
                    cookie.setMaxAge(60*60);
                    response.addCookie(cookie);
                  
                }
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("index.jsp?err=Username password salah");
            }
        } catch (Exception ex) {
            Logger.getLogger(GRZUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void increaseUserCount(ServletContext app){
        int userCount = Integer.parseInt(app.getAttribute("userCount").toString());
        userCount ++;
        app.setAttribute("userCount",userCount);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
