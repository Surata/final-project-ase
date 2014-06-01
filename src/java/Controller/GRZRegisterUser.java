/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BaseClass.GRZBaseController;
import Constants.GRZConstant;
import Helper.GRZValidationUtil;
import Services.GRZUserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edista
 */
public class GRZRegisterUser extends GRZBaseController {

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
        
        ServletContext app = getServletContext();
        String username = request.getParameter("usernameTxt");
        String password = request.getParameter("passwordTxt");
        String confirmPassword = request.getParameter("confirmPassTxt");
        String name = request.getParameter("nameTxt");
        String phone = request.getParameter("phoneTxt");
        String email = request.getParameter("emailTxt");
        String address = request.getParameter("addressTxt");
        String status = "member";
        
        String errorText = "";
        
        GRZValidationUtil validate = new GRZValidationUtil();
        
        if(!validate.validateEmptyText(username)){
            errorText = "errUsername=username must be filled"; 
        }
  
        if(!validate.validateEmptyText(password)){
            errorText = errorText + "&errPassword=password must be filled";
        }else if(!validate.validateAlpnum(password)){
            errorText = errorText + "&errPassword=password must be alphanumeric";
        }else if(!validate.validateMinLongText(password, 6)){
            errorText = errorText + "&errPassword=password must be more than 6 charater";
        }
        
        if(!validate.validateEmptyText(password)){
            errorText = errorText + "&errConfirmPass=confirm password must be filled";
        }else if(confirmPassword.equals(password) ==  false){
            errorText = errorText + "&errConfirmPass=confirm password must be same as password";
        }
        
        if(!validate.validateEmptyText(name)){
            errorText = errorText + "&errName=name must be filled";
        }else if(!validate.validateAlphabet(name)){
            errorText = errorText + "&errName=name must be alphabet";
        }
        
        if(!validate.validateEmptyText(email)){
            errorText = errorText + "&errEmail=email must be filled";
        }else if(!validate.validateEmail(email)){
            errorText = errorText + "&errEmail=email Must be in valid format.Example: admin@example.com";
        }
        
        if(!validate.validateEmptyText(phone)){
            errorText = errorText + "&errPhone=phone must be filled";
        }else if(!validate.validateNumber(phone)){
            errorText = errorText + "&errPhone=phone must be numeric";
        }
        
        if(!validate.validateEmptyText(address)){
            errorText = errorText + "&errAddress=address must be filled";
        }else if(!validate.validateMinLongText(address, 8)){
            errorText = errorText + "&errAddress=address must be more than 8 charaters";
        }
        
        if(errorText.equals("")){
            try{
                GRZUserService.insert(username,
                                    password, 
                                    name, 
                                    email, 
                                    phone, 
                                    address, 
                                    status);
            
                response.sendRedirect(GRZConstant.HOME_PAGE);
            }catch(Exception e){
                failedTransactionErrorHandler(response);
            }
        }else{
            errorHandler(GRZConstant.USER_ADD_PAGE ,errorText, response);
        }

    } // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
