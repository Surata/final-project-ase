<%-- 
    Document   : GRZCart
    Created on : May 25, 2014, 4:12:38 PM
    Author     : edista
--%>

<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="Bean.GRZTransaction"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Services.GRZProductService"%>
<%@page import="Bean.GRZOrder"%>
<%@page import="java.util.List"%>
<%@page import="Services.GRZOrderService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GRZAuthentication auth = new GRZAuthentication();
    auth.allowMember(request.getSession(), response);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Cart Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
            <div class="cartDiv">
                <table>
                    <tr id="tableHeader">
                        <td>Product Name</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Subtotal</td>
                        <td></td>
                    </tr>
                <%
                GRZUser user = GRZApplicationHelper.getCurrentUser(request);
                List orders = GRZOrderService.selectWithUserID(user.getUserID());
                float total = 0;
                for(int i=0; i<orders.size(); i++){
                    GRZOrder order = (GRZOrder)orders.get(i);
                    order.setProduct(GRZOrderService.product(order.getProductID()));
                    total += order.getSubTotal();
                %>
               
                    <tr>
                        <td><%= order.getProduct().getName() %></td>
                        <td><%= String.format("%.0f", order.getProduct().getPrice())%></td>
                        <td><%= order.getQuantity() %></td>
                        <td><%= String.format("%.0f", order.getSubTotal()) %></td>
                        <td><a id="button" href="./GRZDeleteOrder?id=<%= total %>" style="height: 25px;">Delete Item</a></td>
                    </tr>
                
                <%
                }
                %>
                <tr>
                    <td><a id="button" style="height: 25px;" href="./GRZDeleteOrder?id=0">Delete All</a></td>
                    <td><a id="button" style="height: 25px;" href="./GRZAddTransaction?total=<%=total%>">Confirm Order</a></td>
                    <td>Total</td>
                    <td><%= String.format("%.0f", total) %></td>
                </tr>
                <tr>
                    <td><%= user.getUserID()%></td>
                </tr>
                </table>
            </div>
        </div>
        <%@include file="GRZFooter.jsp" %>
    </body>
</html>