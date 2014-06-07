<%-- 
    Document   : product
    Created on : Mar 12, 2014, 4:49:13 PM
    Author     : edista
--%>

<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="java.util.List"%>
<%@page import="Helper.GRZAuthentication"%>
<%@page import="Bean.GRZProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GRZAuthentication auth = new GRZAuthentication();
    auth.onlyAdmin(request.getSession(), response);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Product Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
             <%
                List products = GRZApplicationHelper.appService.getAllProduct();

                int count = products.size();
                
             %>
            <div class="addProduct">
                <p><%= count %> product listed</p>
                <a class="button" href="GRZInsertProduct.jsp" >Add Product</a>
                <a class="button" href="./GRZProductReport" style="width: 130px;">View Product Report</a>
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
                            <td style="width: 80px; text-align: right;">Rp. <%= String.format("%.0f",product.getPrice()) %></td>
                        </tr>
                        <tr>
                            <td><a id="button" style="height: 25px;" href="./GRZUpdateProduct.jsp?id=<%= product.getProductID() %>">Update</a></td>
                            <td><a id="button" style="height: 25px;" href="./GRZDeleteProduct?id=<%= product.getProductID() %>">Delete</a></td>
                        </tr>
                    </table>
                </div>
                <% 
                }
                %>
            </div>
        </div>
        <%@include file="GRZFooter.jsp" %>
    </body>
</html>
