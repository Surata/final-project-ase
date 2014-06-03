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
                <div></div>
                <h2>My Order</h2>
                <%
                    GRZUser user = GRZApplicationHelper.getCurrentUser(request);
                    List transactions = GRZApplicationHelper.appService.getAllTransactionWithUserId(user.getUserID());
                    for(int i=0; i< transactions.size(); i++){
                        GRZTransaction transaction = (GRZTransaction)transactions.get(i);
                        List orders = GRZApplicationHelper.appService.getOrderWithTransactionId(transaction.getTransactionID());
                        int status = transaction.getStatus();
                        String statusDesc;
                        if(status == 1){
                            statusDesc = "In Progress";
                        }else{
                            statusDesc = "others";
                        }
                        %>
                        <div>
                            Customer : <%= user.getUsername()%> <br />
                            Order Time : <%= transaction.getDate() %> <br />
                            Status : <%= statusDesc %> <br />
                            <table>
                                <tr>
                                    <td>Product Name</td>
                                    <td>Price</td>
                                    <td>Quantity</td>
                                    <td>Subtotal</td>
                                </tr>
                                <%
                                    for(int j=0; j<orders.size(); j++){
                                        GRZOrder order = (GRZOrder)orders.get(j);
                                        GRZProduct product = GRZApplicationHelper.appService.getProductWithId(order.getProductID());
                                        %>
                                        <tr>
                                            <td><%= product.getName() %></td>
                                            <td><%= product.getPrice() %></td>
                                            <td><%= order.getQuantity() %></td>
                                            <td><%= order.getSubTotal() %></td>
                                        </tr>
                                        <%
                                    }
                                %>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>Total</td>
                                    <td><%= transaction.getTotal() %></td>
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
