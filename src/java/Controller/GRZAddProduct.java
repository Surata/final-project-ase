/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.GRZValidationUtil;
import BaseClass.GRZBaseController;
import Bean.GRZProduct;
import Constants.GRZConstant;
import Services.GRZProductService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edista
 */
public class GRZAddProduct extends GRZBaseController {

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
        String name = request.getParameter("nameTxt");
        String desc = request.getParameter("descriptionTxt");
        String price = request.getParameter("priceTxt");
        String imageURL = request.getParameter("imageURL");
        
        String errorText = "";
        
        GRZValidationUtil validate = new GRZValidationUtil();
        
        if(!validate.validateEmptyText(name)){
            errorText = "errName=name must be filled"; 
        }
        
        if(!validate.validateEmptyText(desc)){
            errorText += "&errDesc=description must be filled";
        }else if(!validate.validateMinLongText(desc, 8)){
            errorText += "&errDesc=description must be more than 8 character";
        }
        
        if(!validate.validateEmptyText(price)){
            errorText += "&errPrice=price must be filled";
        }else if(!validate.validateNumber(price)){
            errorText += "&errPrice=price must be numeric";
        }
        
        if(!validate.validateEmptyText(imageURL)){
            errorText += "&errImage=image must be filled";
        }
        
        if(errorText.equals("")){
            try{
                GRZProductService.insert(name, desc, Float.parseFloat(price), "Image/"+imageURL);
                response.sendRedirect(GRZConstant.PRODUCT_LIST_PAGE);
            }catch(Exception e){
                failedTransactionErrorHandler(response);
            }
        }else{
            errorHandler(GRZConstant.PRODUCT_ADD_PAGE, errorText, response);
        }
        
    }  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
