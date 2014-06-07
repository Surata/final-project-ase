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
                <div class="searchBar" style="border: none;">
                <div id="searchDiv">      
                    <form action="GRZCustomer.jsp" method="POST">
                    <%
                        String searchTxt = request.getParameter("searchTxt");
                        if(searchTxt == null)
                            searchTxt = "";
                        out.print("<input id='input' type='text' name='searchTxt' value='" + searchTxt + "'/>");
                    %>
                   <input id="searchButton" type="submit" value="Search" />    
                    </form>
                </div>
                </div>
                <%
                List users;
                if(searchTxt!= null && !searchTxt.equals("")){
                    users = GRZApplicationHelper.appService.getUserWithUsernameLike(searchTxt);
                }else{
                    users = GRZApplicationHelper.appService.getAllUser();
                }

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
                        <tr>
                            <td><a id="button" style="height: 25px;" href="./GRZUpdateUser.jsp?id=<%= user.getUserID() %>">Update</a></td>
                            <td><a id="button" style="height: 25px;" href="./GRZDeleteCustomer?id=<%= user.getUserID() %>">Delete</a></td>
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
