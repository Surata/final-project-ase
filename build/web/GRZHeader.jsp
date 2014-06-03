<%-- 
    Document   : GRZHeader
    Created on : Mar 29, 2014, 3:40:15 PM
    Author     : edista
--%>

<%@page import="Constants.GRZConstant"%>
<%@page import="Helper.GRZAuthentication"%>
<%@page import="Bean.GRZUser"%>

<div id="headerBarOuter">
    <div class="headerBar">
        <div id="logo">
            <h1>PIZZA</h1>
            <p>GRAZIE DELIVERY</p>
        </div>

        <div id="navigationBar">
        <ul>
            <li><a href="./<%= GRZConstant.HOME_PAGE %>">Home</a></li>
            <li><a href="./<%= GRZConstant.MENU_PAGE %>">Menu</a></li>
            
            <%
                GRZAuthentication authCookie = new GRZAuthentication();
                authCookie.checkCookie(getServletContext(), request.getSession(), request);
                if(session.getAttribute("user") != null){
                    %>
                    <li><a href="<%= GRZConstant.TRACK_PAGE %>">Track</li>
                    <li><a href="<%= GRZConstant.ORDER_PAGE %>">Order</a></li>
                    <li><a href="<%= GRZConstant.CART_PAGE %>">Cart</a></li>
                    <%
                    GRZUser user = (GRZUser)session.getAttribute("user");
                    String status = user.getStatus();
                    if(status.equals("admin")){
            %>
                    <li><a href="./<%= GRZConstant.CUSTOMER_PAGE %>">Customer</a></li>
                    <li><a href="./<%= GRZConstant.PRODUCT_LIST_PAGE %>">Product</a></li>
                    <li><a href="">Transaction</a></li>
            <%
                    }
                }else{
                    %>
                   
                    <li>Track</li>
                    <li>Order</li>
                    <li>Cart</li>
                    
                     <%
                }
            %>
            
        </ul>
        </div>
    </div>
</div>
