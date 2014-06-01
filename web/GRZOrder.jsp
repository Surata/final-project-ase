<%-- 
    Document   : GRZOrder
    Created on : May 22, 2014, 7:40:11 PM
    Author     : edista
--%>

<%@page import="Bean.GRZTransaction"%>
<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="Bean.GRZProduct"%>
<%@page import="java.util.List"%>
<%@page import="Services.GRZProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GRZAuthentication auth = new GRZAuthentication();
    auth.checkUser(request.getSession(), response);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Order Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
            <div class="orderDiv">
                <div id="info">

                </div>
                <h1>Available Product(s)</h1>
                <div>
                    <%
                        List products = GRZProductService.selectAll();
                        int userID = GRZApplicationHelper.getCurrentUser(request).getUserID();
                        GRZTransaction transaction = GRZApplicationHelper.getLastTransactionWithUserID(userID);
                    %>
                    <%
                        for(int i =0;i<products.size();i++){
                            GRZProduct product = (GRZProduct)products.get(i);
                            %>
                            <form method="POST" action="./GRZAddOrder">
                                <input type="text" name="productID" hidden="true" value="<%=product.getProductID()%>"/>
                                <input type="text" name="price" hidden="true" value="<%=product.getPrice()%>"/>
                                <input type="text" name="transactionID" hidden="true" value="<%=transaction.getTransactionID() %>"/>
                                <table>
                                    <tr>
                                        <td style="width: 150px"><%= product.getName() %></td>
                                        <td style="width: 70px"><%= product.getPrice() %></td>
                                        <td style="width: 25px"><input type="text" name="quantityInput" placeholder="qty" style="width: 25px;"/></td>
                                        <td style="width: 50px"><input id="button" type="submit" name="order" value="Add to Cart" style="height: 25px;"></td>
                                    </tr>
                                </table>
                            </form>
                            <%
                        }
                    %>
                </div>
               
            </div>
        </div>
        <%@include file="GRZFooter.jsp" %>
    </body>
</html>
