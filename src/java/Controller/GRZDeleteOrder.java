/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BaseClass.GRZBaseController;
import Bean.GRZOrder;
import Bean.GRZProduct;
import Bean.GRZUser;
import Constants.GRZConstant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edista
 */
public class GRZDeleteOrder extends GRZBaseController {

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
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
       
        String successDesc = "";
        if(id == 0){
            successDesc = "Remove all from cart";
            HttpSession session = request.getSession();
            GRZUser currentUser = (GRZUser)session.getAttribute("user");
            Boolean success = service.removeAllOrderWithUserId(currentUser.getUserID());
            if(success)
                response.sendRedirect(GRZConstant.CART_PAGE+"?success="+successDesc);
            
        }else{
            GRZOrder order = service.getOrderWithId(id);
            GRZProduct product = service.getProductWithId(order.getProductID());
            successDesc = order.getQuantity() +" "+ product.getName() +"(s) Removed from Cart";
            Boolean success = service.removeOrderWithId(id);
            if(success)
                response.sendRedirect(GRZConstant.CART_PAGE+"?success="+successDesc);
        }
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
