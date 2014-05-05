/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author edista
 */
public class GRZLogout extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            
            Cookie[] cookies = request.getCookies();
            Cookie cookie = null;
            if(cookies != null){
                for(int i=0; i<cookies.length ;i++){
                    cookie = cookies[i];
                    if(cookie.getName().equals("GRZUser")){
                        cookie.setValue("");
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                        
                    }
                }
            }
            session.removeAttribute("user");
            decreaseUserCount(getServletContext());
            
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("index.jsp");
        }
    }
    private void decreaseUserCount(ServletContext app){
        int userCount = Integer.parseInt(app.getAttribute("userCount").toString());
        userCount --;
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
