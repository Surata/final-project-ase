<%-- 
    Document   : customer
    Created on : Mar 12, 2014, 4:46:11 PM
    Author     : edista
--%>

<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="Bean.GRZUser"%>
<%@page import="java.util.List"%>
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
        <title>Customer Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
            <div class="customerList">
                <h1>Customer List</h1>
                <%
                List users = GRZApplicationHelper.appService.getAllUser();

                for(int i=0; i<users.size();i++){
                    GRZUser user = (GRZUser)users.get(i);
                %>
                <div class ="customerView">
                    <table>
                        <tr>
                            <td>
                                Username : <%= user.getUsername() %>
                            </td>
                            <td>
                                Name : <%= user.getName() %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Email : <%= user.getEmail() %>
                            </td>
                            <td>
                                Phone : <%= user.getPhone() %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Address : <%= user.getAddress() %>
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
        <%@include file="GRZFooter.jsp" %>
    </body>
</html>
