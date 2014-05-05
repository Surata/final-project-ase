<%-- 
    Document   : product
    Created on : Mar 12, 2014, 4:49:13 PM
    Author     : edista
--%>

<%@page import="Controller.GRZAuthentication"%>
<%@page import="java.sql.ResultSet"%>
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
                GRZProduct products = new GRZProduct();

                ResultSet rs  = products.searchAll(getServletContext());
                int count = products.getRowCount(rs);
                
             %>
            <div class="addProduct">
                <p><%= count %> product listed</p>
                <a class="button" href="GRZInsertProduct.jsp" >Add Product</a>
            </div>
            <div class="productList">
                <%
                while(rs.next()){
                %>
                <div class="productView">
               <%
                     out.print("<img src='" + rs.getString("Image") + "' />");
                     %>
                    <table>
                        <tr>
                            <td style="width: 170px; color: red;"><%= rs.getString("Name") %></td>
                            <td style="width: 80px; text-align: right;">Rp. <%= rs.getString("Price") %></td>
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
