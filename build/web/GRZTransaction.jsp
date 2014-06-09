<%-- 
    Document   : GRZTransaction
    Created on : Jun 7, 2014, 10:32:29 AM
    Author     : edista
--%>

<%@page import="Bean.GRZProduct"%>
<%@page import="Bean.GRZOrder"%>
<%@page import="Bean.GRZTransaction"%>
<%@page import="java.util.List"%>
<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="Helper.GRZAuthentication"%>
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
        <title>Transaction Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
            <div class="trackDiv">
                <div></div>
                <h2>Transaction List</h2>
                <a href="./GRZTransactionsReport" style="color: red;">View Transaction Report</a>
                <%
                    List transactions = GRZApplicationHelper.appService.getAllTransactions();
                    for(int i=0; i<transactions.size(); i++){
                        GRZTransaction transaction = (GRZTransaction)transactions.get(i);
                        List orders = GRZApplicationHelper.appService.getOrderWithTransactionId(transaction.getTransactionID());
                        GRZUser user = GRZApplicationHelper.appService.getUserWithId(transaction.getUserID());
                        %>
                        <div>
                            <form method="POST" action="./GRZChangeOrderStatus?id=<%= transaction.getTransactionID() %>">
                                <table>
                                <tr>
                                    <td>Customer : <%=  user.getName() %></td>
                                    <td>Order Time : <%= transaction.getDate() %></td>
                                    <td>Status : <select name="status">
                                            <%
                                                int status = transaction.getStatus();
                                                if (status == 1) out.print("<option value='1' selected>In Progress</option>");
                                                else out.print("<option value='1'>In Progress</option>");
                                                if (status == 2) out.print("<option value='2' selected>Packing</option>");
                                                else out.print("<option value='2'>Packing</option>");
                                                if (status == 3) out.print("<option value='3' selected>En Route</option>");
                                                else out.print("<option value='3'>En Route</option>");
                                                if (status == 4) out.print("<option value='4' selected>Delivered</option>");
                                                else out.print("<option value='4'>Delivered</option>");
                                                if (status == 5) out.print("<option value='5' selected>Cancelled</option>");
                                                else out.print("<option value='5'>Cancelled</option>");
                                            %>
                                                </select>
                                    </td>
                                    <td><input type="submit" value="Change Order Status" id="button" style="height: 25px; width: 150px;"></td>
                                </tr>
                                <tr style="font-weight: bold;background: #CCCCCC;">
                                    <td>Product Name</td>
                                    <td>Product Price</td>
                                    <td>Product Quantity</td>
                                    <td>Product Subtotal</td>
                                </tr>
                           
                        <%
                        for(int j=0;j< orders.size(); j++){
                            GRZOrder order = (GRZOrder)orders.get(i);
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
                                    <td><%= product.getPrice() %></td>
                                    <td><%= order.getQuantity() %></td>
                                    <td><%= order.getSubTotal() %></td>
                                </tr>

                            <%
                            }
                        }
                        %>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>Total Price</td>
                                    <td><%= transaction.getTotal() %></td>
                                </tr>
                             </table>
                            </form>
                        </div>
                        <%
                    }
                %>
            </div>
        </div>
        <%@include file="GRZFooter.jsp" %>
    </body>
</html>
