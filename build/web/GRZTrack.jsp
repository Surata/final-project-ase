<%-- 
    Document   : GRZTrack
    Created on : Jun 1, 2014, 7:16:29 PM
    Author     : edista
--%>

<%@page import="Bean.GRZProduct"%>
<%@page import="Bean.GRZOrder"%>
<%@page import="Bean.GRZTransaction"%>
<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="java.util.List"%>
<%@page import="Helper.GRZAuthentication"%>
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
        <title>Track Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
            <div class="trackDiv">
                <%
                String success = request.getParameter("success");
                if(success != null && !success.equals("")){
                %>
                <div id="info" style="background-color: #468847; text-align: center; color: white; width: 400px; height: 25px; margin: 15px auto 0 auto;">
                    <%= success %>
                </div>
                <%
                }
                %>
                <h2>My Order</h2>
                <%
                    GRZUser user = GRZApplicationHelper.getCurrentUser(request);
                    List transactions = GRZApplicationHelper.appService.getAllTransactionWithUserId(user.getUserID());
                    for(int i=0; i< transactions.size(); i++){
                        GRZTransaction transaction = (GRZTransaction)transactions.get(i);
                        List orders = GRZApplicationHelper.appService.getOrderWithTransactionId(transaction.getTransactionID());
                        int status = transaction.getStatus();
                        String statusDesc = GRZApplicationHelper.getStatusDesc(status);
                        %>
                        <div style="text-align: left;">
                            <table>
                                <tr>
                                    <td>Customer : <%= user.getUsername()%></td>
                                    <td><%= transaction.getDate() %></td>
                                    <td>Status : <%= statusDesc %></td>
                                    <td><a href="./GRZChangeOrderStatus?id=<%= transaction.getTransactionID() %>&status=6" id="button" style="height: 25px;">Cancel Order</a></td>
                                </tr>
                                <tr style="font-weight: bold; background: #CCCCCC;">
                                    <td>Product Name</td>
                                    <td>Price</td>
                                    <td>Quantity</td>
                                    <td>Subtotal</td>
                                </tr>
                                <%
                                    for(int j=0; j<orders.size(); j++){
                                        GRZOrder order = (GRZOrder)orders.get(j);
                                        GRZProduct product = GRZApplicationHelper.appService.getProductWithId(order.getProductID());
                                        if(product == null){
                                            %>
                                            <tr>
                                                <td colspan="4" style="color: red;">Product has been removed from menu</td>
                                            </tr>
                                            <%
                                        }else{
                                        %>
                                        <tr>
                                            <td><%= product.getName() %></td>
                                            <td><%= String.format("%.0f",product.getPrice()) %></td>
                                            <td><%= order.getQuantity() %></td>
                                            <td><%= String.format("%.0f", order.getSubTotal()) %></td>
                                        </tr>
                                        <%
                                        }
                                    }
                                %>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>Total</td>
                                    <td><%= String.format("%.0f",transaction.getTotal()) %></td>
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
