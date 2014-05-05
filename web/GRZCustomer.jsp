<%-- 
    Document   : customer
    Created on : Mar 12, 2014, 4:46:11 PM
    Author     : edista
--%>

<%@page import="Controller.GRZAuthentication"%>
<%@page import="java.sql.ResultSet"%>
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
            <div class="customerList">
                <h1>Customer List</h1>
                <%
                GRZUser users = new GRZUser();

                ResultSet rs  = users.searchAll(getServletContext());

                while(rs.next()){
                %>
                <div class ="customerView">
                    <table>
                        <tr>
                            <td>
                                Username : <%= rs.getString("Username") %>
                            </td>
                            <td>
                                Name : <%= rs.getString("Name") %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Email : <%= rs.getString("Email") %>
                            </td>
                            <td>
                                Phone : <%= rs.getString("Phone") %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Address : <%= rs.getString("Address") %>
                            </td>
                            <td> </td>
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
