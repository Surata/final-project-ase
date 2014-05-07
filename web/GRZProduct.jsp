<%-- 
    Document   : product
    Created on : Mar 12, 2014, 4:49:13 PM
    Author     : edista
--%>

<%@page import="java.util.List"%>
<%@page import="Services.GRZProductService"%>
<%@page import="Controller.GRZAuthentication"%>
<%@page import="Bean.GRZProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GRZAuthentication auth = new GRZAuthentication();
    auth.checkUser(request.getSession(), response);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
             <%
                GRZProductService productService = new GRZProductService();
                List products = productService.selectAll();

                int count = products.size();
                
             %>
            <div class="addProduct">
                <p><%= count %> product listed</p>
                <a class="button" href="GRZInsertProduct.jsp" >Add Product</a>
            </div>
            <div class="productList">
                <%
                for(int i=0;i<products.size();i++){
                    GRZProduct product = (GRZProduct)products.get(i);
                %>
                <div class="productView">
               <%
                     out.print("<img src='" + product.getImage() + "' />");
                     %>
                    <table>
                        <tr>
                            <td style="width: 170px; color: red;"><%= product.getName() %></td>
                            <td style="width: 80px; text-align: right;">Rp. <%= product.getPrice() %></td>
                        </tr>
                    </table>
                </div>
                <% 
                }
                %>
            </div>
        </div>
        <%@include file="GRZFooter.html" %>
    </body>
</html>
