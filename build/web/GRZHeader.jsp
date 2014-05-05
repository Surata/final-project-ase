<%-- 
    Document   : GRZHeader
    Created on : Mar 29, 2014, 3:40:15 PM
    Author     : edista
--%>

<%@page import="Controller.GRZAuthentication"%>
<%@page import="Bean.GRZUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link href="CSS/GRZStyle.css" rel="stylesheet"/>
</head>

<div id="headerBarOuter">
    <div class="headerBar">
        <div id="logo">
            <h>PIZZA</h>
            <p>GRAZIE DELIVERY</p>
        </div>

        <div id="navigationBar">
        <ul>
            <li><a href="./index.jsp">Home</a></li>
            <li><a href="./GRZMenu.jsp">Menu</a></li>
            <%
                GRZAuthentication authCookie = new GRZAuthentication();
                authCookie.checkCookie(getServletContext(), request.getSession(), request);
                if(session.getAttribute("user") != null){

                    GRZUser user = (GRZUser)session.getAttribute("user");
                    String status = user.getStatus();
                    if(status.equals("admin")){
            %>
                    <li><a href="./GRZCustomer.jsp">Customer</a></li>
                    <li><a href="./GRZProduct.jsp">Product</a></li>
            <%
                    }
                }
            %>
        </ul>
        </div>
    </div>
</div>
